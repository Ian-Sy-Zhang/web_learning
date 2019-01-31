package com.WebLearning.fuckJdbc;


import java.sql.*;
import java.util.Calendar;

public class JDBCOperation {

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

    private static int insert(TKDstudent student) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into students (id,name,times) values(?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getTimes());
            i = pstmt.executeUpdate();
            System.out.println("插入了 " + i + "同学的信息");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    private static int update(TKDstudent student) {
        Connection conn = getConn();
        int i = 0;
        String today = getDate();
        String updateData = student.getTimes() + "、"+today;
        String sql = "update students set times= ? , date = ? where id= ? ";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,student.getTimes());
            pstmt.setString(2,updateData);
            pstmt.setString(3,student.getId());
            i = pstmt.executeUpdate();

            System.out.println("改变了 " + i + "同学的信息");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

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

    public static int login(String name, String id) {
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
            /*
            if (count > 0 ) {
            	//登陆成功
            }
            else {
				//登陆失败
			}
			*/
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

    private static int delete(String id) {
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from students where id='" + id + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("删除了 " + i + "同学的信息");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    static private String getDate(){
        String y,m,d;
        Calendar cal=Calendar.getInstance();
        y=String.valueOf(cal.get(Calendar.YEAR));
        m=String.valueOf(cal.get(Calendar.MONTH));
        d=String.valueOf(cal.get(Calendar.DATE));
        return y + m + d;
    }



    public static void main(String args[]) {
        System.out.println(JDBCOperation.login("ma","12"));
    }


}