package org.Ian.Dao;

import java.sql.*;
import java.util.Calendar;

import org.Ian.entity.Student;

public class UpdateDao {
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
    

    public static int update(Student student) {
        Connection conn = getConn();
        int i = 0;
        String today = getDate();
        String updateDate = student.getDate() +today;
        String sql = "update students set times= ? , date = ? where id= ? ";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,student.getTimes()+1);
            pstmt.setString(2,updateDate);
            pstmt.setString(3,student.getId());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回修改的人数
        return i;
    }

    static private String getDate(){
        String y,m,d;
        Calendar cal=Calendar.getInstance();
        y=String.valueOf(cal.get(Calendar.YEAR));
        m=String.valueOf(cal.get(Calendar.MONTH));
        d=String.valueOf(cal.get(Calendar.DATE));
        return y +"/"+ m +"/"+ d+";";
    }

}
