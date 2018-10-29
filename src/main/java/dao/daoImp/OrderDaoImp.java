package dao.daoImp;

import dao.DaoUtil;
import dao.OrderDao;
import po.Order;
import po.User;
import utils.Operate;
import utils.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImp implements OrderDao {
	public void insert(Order order) {
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "insert into Orders(uid,pid,operate,time) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(order.getUid()));
			pstmt.setString(2, String.valueOf(order.getPid()));
			pstmt.setString(3, order.getOperate().toString());
			pstmt.setString(4, order.getEnd_time().toString());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Order> query(int uid) {
		ArrayList<Order> orderArrayList = new ArrayList<Order>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from orders where uid = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				Order order = new Order(uid, rs.getInt(2), Operate.valueOf(rs.getString(3)), rs.getDate(4));
				orderArrayList.add(order);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderArrayList;
	}
}
