package myWebProject1;

import java.sql.*;
public class LoginDao {
	private static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bunoob"+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "zsy999666.";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

	//返回1说明登陆成功，返回0说明用户名与密码不符合，返回-1说明程序出现异常
	public int login(String name, String id) {
		Connection conn = getConn();
		String sql = "select * from students where name=? and id = ?";
		PreparedStatement pstmt = null;
		try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,id);
            ResultSet i = pstmt.executeQuery();
            int count= -1;
            if (i.next()) {
            	count = i.getInt(1);
            }
    		return count;
        } 
		catch (SQLException e) {
            e.printStackTrace();
        }
		finally {
            try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	/*
    private static Integer getAll() {
        Connection conn = getConn();
        String sql = "select * from students";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	 */



}
