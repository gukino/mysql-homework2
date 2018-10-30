package dao.daoImp;

import dao.DaoUtil;
import dao.PackageDao;
import po.Package;
import po.User;
import utils.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackageDaoImp implements PackageDao{

	public void insert(Package packages) {

		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "insert into package (flow,calls,message,price) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			//pstmt.setString(1, null);
			pstmt.setString(1, Integer.toString(packages.getFlow()));
			pstmt.setString(2, Integer.toString(packages.getCall()));
			pstmt.setString(3, Integer.toString(packages.getMessage()));
			pstmt.setString(4, Double.toString(packages.getPrice()));
			i = pstmt.executeUpdate();
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Package query(int pid) {
		Package aPackage = null;
		Connection conn = DaoUtil.getConnection();
		int i = 0;
		String sql = "select * from package where pid = ?";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(pid));

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			aPackage = new Package(pid, rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5));
			pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aPackage;
	}
}
