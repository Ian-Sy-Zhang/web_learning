package org.Ian.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.Ian.entity.Student;

public class CheckTimes {
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
	
	public static int checktimes(Student student) {
		Connection connection = getConn();
		PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String ID = student.getId();
    	String sql = "select * from students where id = ?";
    	try {
    		pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int times = rs.getInt("times");
				return times;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
				try {
					if(rs != null)rs.close();
					if(pstmt != null) pstmt.close();
					if(connection != null ) connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
    	return 999;
	}
}

