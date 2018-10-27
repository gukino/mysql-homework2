package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Contest {
	public static void main(String[] args){
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost/index2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=true";
			String username="root";
			String password="123456";
			conn = DriverManager.getConnection(url,username,password);
			stmt = conn.createStatement();
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("用户名：" + rs.getString(2)+" 密码："+ rs.getString("sex"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
