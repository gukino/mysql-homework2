package dao.daoImp;

import dao.DaoUtil;
import dao.OrderDao;
import po.Order;
import po.User;
import utils.Operate;
import utils.Sex;
import utils.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImp implements OrderDao {
	public void insert(Order order) {
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "insert into Orders(uid,pid,operate,time,state) values(?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(order.getUid()));
			pstmt.setString(2, String.valueOf(order.getPid()));
			pstmt.setString(3, order.getOperate().toString());
			pstmt.setString(4, order.getEnd_time().toString());
			pstmt.setString(5, order.getState().toString());
			i = pstmt.executeUpdate();

			if (order.getOperate().equals(Operate.退订)){
				updateState(order, conn);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Order> queryAll(int uid) {

		String sql = "select * from orders where uid = ?";
		return query(uid,sql);
	}


	ArrayList<Order> query(int uid, String sql) {
		ArrayList<Order> orderArrayList = new ArrayList<Order>();
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){

				Order order = new Order(uid, rs.getInt(2), Operate.valueOf(rs.getString(3)),
					rs.getDate(4), State.valueOf(rs.getString(5)));
				orderArrayList.add(order);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderArrayList;

	}

	public ArrayList<Order> queryCurrent(int uid) {

		String sql = "select * from (select * from orders where uid = ? order by end_time) group by uid,pid";
		return query(uid,sql);
	}

	void updateState(Order order, Connection conn) {

		int i = 0;
		String sql = "update orders set state='失效' where uid= ? and pid = ? ";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(order.getUid()));
			pstmt.setString(2, String.valueOf(order.getPid()));
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
