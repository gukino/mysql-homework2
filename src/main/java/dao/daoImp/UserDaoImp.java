package dao.daoImp;

import dao.DaoUtil;
import dao.UserDao;
import po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
	public void insert(User user) {
		int i = 0;
		String sql = "insert into USER (uid,name,sex,amount) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {
			Connection conn = DaoUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(user.getUid()));
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

	public void update(User user) {

	}

	public void delete(User user) {

	}
}
