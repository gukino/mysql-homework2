package dao.daoImp;

import dao.DaoUtil;
import dao.MessageRecordDao;
import po.MessageRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MessageRecordDaoImp implements MessageRecordDao {

	public void insert(MessageRecord messageRecord) {
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "insert into Message_record (uid,amount,price,end_time) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, messageRecord.getUid());
			pstmt.setInt(2, messageRecord.getAmount());
			pstmt.setDouble(3, messageRecord.getPrice());
			pstmt.setDate(4, messageRecord.getEnd_time());
			i = pstmt.executeUpdate();
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<MessageRecord> queryAll(int uid) {
		ArrayList<MessageRecord> messageRecordArrayList = new ArrayList<MessageRecord>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from Message_record where uid = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				MessageRecord messageRecord = new MessageRecord(uid, rs.getInt(2), Double.valueOf(rs.getString(3)), rs.getDate(4));
				messageRecordArrayList.add(messageRecord);
			}
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messageRecordArrayList;
	}

	public ArrayList<MessageRecord> querybyMonth(int uid, LocalDate date) {

		ArrayList<MessageRecord> messageRecordArrayList = new ArrayList<MessageRecord>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from Message_record where uid = ? and year(end_time)=? and MONTH (end_time)=?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));
			pstmt.setInt(2, date.getYear());
			pstmt.setInt(3, date.getMonthValue());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				MessageRecord messageRecord = new MessageRecord(uid, rs.getInt(2), Double.valueOf(rs.getString(3)), rs.getDate(4));
				messageRecordArrayList.add(messageRecord);
			}
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messageRecordArrayList;
	}

	public MessageRecord getAmountByMonth(int uid, LocalDate date) {

		MessageRecord messageRecord= new MessageRecord();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select sum(amount),sum(price) from Message_record where uid = ? and year(end_time)=? and MONTH (end_time)=?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));
			pstmt.setString(2, String.valueOf(date.getYear()));
			pstmt.setString(3, String.valueOf(date.getMonthValue()));

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			messageRecord.setAmount(rs.getInt(1));
			messageRecord.setPrice(rs.getDouble(2));

			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messageRecord;
	}
}
