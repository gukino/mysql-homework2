package dao.daoImp;

import dao.DaoUtil;
import dao.OrderDao;
import po.Order;
import po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImp implements OrderDao {
	public void insert(Order order) {
		int i = 0;
		String sql = "insert into ORDER (uid,pid,operate,time) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {
			Connection conn = DaoUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(order.getUid()));
			pstmt.setString(2, String.valueOf(order.getPid()));
			pstmt.setString(3, String.valueOf(order.getOperate()));
			pstmt.setString(4, String.valueOf(order.getEnd_time()));
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void  update(Order order) {
		int i = 0;
		String sql = "update order set uid='" + order.getUid() + "' where pid='" + order.getPid() + "'";
		PreparedStatement pstmt;
		try {
			Connection conn = DaoUtil.getConnection();

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Order order) {
		int i = 0;
		String sql = "delete from ORDER where Name='" + uid + "'";
		PreparedStatement pstmt;
		try {
			Connection conn = DaoUtil.getConnection();

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
