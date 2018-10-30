package dao.daoImp;

import dao.DaoUtil;
import dao.FlowRecordDao;
import po.FlowRecord;
import utils.Flowtype;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FlowRecordDaoImp implements FlowRecordDao{

	public void insert(FlowRecord flowRecord) {
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "insert into Flow_record (uid,amount,price,end_time,type) values(?,?,?,?,?)";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, flowRecord.getUid());
			pstmt.setInt(2, flowRecord.getAmount());
			pstmt.setDouble(3, flowRecord.getPrice());
			pstmt.setDate(4, flowRecord.getEnd_time());
			pstmt.setString(5, flowRecord.getType().toString());

			i = pstmt.executeUpdate();
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<FlowRecord> queryAll(int uid) {
		ArrayList<FlowRecord> flowRecordArrayList = new ArrayList<FlowRecord>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from Flow_record where uid = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				FlowRecord flowRecord = new FlowRecord(uid, rs.getInt(2), rs.getDouble(3),
					rs.getDate(4), Flowtype.valueOf(rs.getString(5)));
				flowRecordArrayList.add(flowRecord);
			}
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flowRecordArrayList;
	}

	public ArrayList<FlowRecord> querybyMonth(int uid, LocalDate date, Flowtype flowtype) {

		ArrayList<FlowRecord> flowRecordArrayList = new ArrayList<FlowRecord>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from Flow_record where uid = ? and year(end_time)=? and MONTH (end_time)=? and type = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));
			pstmt.setInt(2, date.getYear());
			pstmt.setInt(3, date.getMonthValue());
			pstmt.setString(4,flowtype.toString());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				FlowRecord flowRecord = new FlowRecord(uid, rs.getInt(2), rs.getDouble(3),
					rs.getDate(4), Flowtype.valueOf(rs.getString(5)));
				flowRecordArrayList.add(flowRecord);
			}
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flowRecordArrayList;
	}

	public FlowRecord getAmountByMonth(int uid, LocalDate date, Flowtype flowtype) {

		FlowRecord flowRecord= new FlowRecord();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select sum(amount),sum(price) from Flow_record where uid = ? and year(end_time)=? and MONTH (end_time)=? and type = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));
			pstmt.setString(2, String.valueOf(date.getYear()));
			pstmt.setString(3, String.valueOf(date.getMonthValue()));
			pstmt.setString(4,flowtype.toString());

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			flowRecord.setAmount(rs.getInt(1));
			flowRecord.setPrice(rs.getDouble(2));

			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flowRecord;
	}
}
