package dao.daoImp;

import dao.DaoUtil;
import dao.UserDao;
import po.User;
import utils.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
	public void insert(User user) {
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "insert into USER (uid,name,sex,amount) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, user.getName());
			pstmt.setString(3, String.valueOf(user.getSex()));
			pstmt.setString(4, String.valueOf(user.getAmount()));
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User query(int uid) {
		User user = null;
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from USER where uid = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(uid));

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user = new User(uid, rs.getString(2), Sex.valueOf(rs.getString(3)), rs.getDouble(4));
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}


