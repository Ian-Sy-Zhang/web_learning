package org.Ian.Dao;

import java.sql.*;

import org.Ian.entity.Student;

public class LoginDao {
	private static Connection getConn() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bunoob" + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String username = "root";
		String password = "zsy999666.";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 返回1说明登陆成功，返回0说明用户名与密码不符合，返回-1说明程序出现异常
	public static int login(Student student) throws ClassNotFoundException {
		int flag = 0;
		String name = student.getName();
		String id = student.getId();
		Connection conn = getConn();
		String sql = "select * from students where name=? and id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				flag = 1;//登陆成功
			}
			else flag = 0;//用户名/密码错误
		}catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
		}catch (Exception e) {
			e.printStackTrace();
			flag = -1;
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

}
