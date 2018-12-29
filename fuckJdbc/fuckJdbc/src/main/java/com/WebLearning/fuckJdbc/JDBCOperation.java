package com.WebLearning.fuckJdbc;


import javax.rmi.CORBA.StubDelegate;
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
            conn = (Connection) DriverManager.getConnection(url, username, password);
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
        /*
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update students set times=");
        stringBuilder.append(student.getTimes()+1);
        stringBuilder.append("where id=");
        */
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
        TKDstudent tdKstudent1 = new TKDstudent("12", "Ma", 1);
        JDBCOperation.update(tdKstudent1);
        JDBCOperation.getConn();
    }


}