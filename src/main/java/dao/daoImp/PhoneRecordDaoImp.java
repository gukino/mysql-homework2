package dao.daoImp;

import dao.DaoUtil;
import dao.PhoneRecordDao;
import po.PhoneRecord;
import po.PhoneRecord;
import utils.Operate;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class PhoneRecordDaoImp implements PhoneRecordDao{

	public void insert(PhoneRecord phoneRecord) {
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "insert into Phone_record (uid,time,price,end_time) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, phoneRecord.getUid());
			pstmt.setInt(2, phoneRecord.getTime());
			pstmt.setDouble(3, phoneRecord.getPrice());
			pstmt.setDate(4, phoneRecord.getEnd_time());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<PhoneRecord> queryAll(int uid) {
		ArrayList<PhoneRecord> phoneRecordArrayList = new ArrayList<PhoneRecord>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from Phone_record where uid = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				PhoneRecord phoneRecord = new PhoneRecord(uid, rs.getInt(2), Double.valueOf(rs.getString(3)), rs.getDate(4));
				phoneRecordArrayList.add(phoneRecord);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return phoneRecordArrayList;
	}

	public ArrayList<PhoneRecord> querybyMonth(int uid, LocalDate date) {

		ArrayList<PhoneRecord> phoneRecordArrayList = new ArrayList<PhoneRecord>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from Phone_record where uid = ? and year(end_time)=? and MONTH (end_time)=?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));
			pstmt.setInt(2, date.getYear());
			pstmt.setInt(3, date.getMonthValue());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				PhoneRecord phoneRecord = new PhoneRecord(uid, rs.getInt(2), Double.valueOf(rs.getString(3)), rs.getDate(4));
				phoneRecordArrayList.add(phoneRecord);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return phoneRecordArrayList;
	}
}
