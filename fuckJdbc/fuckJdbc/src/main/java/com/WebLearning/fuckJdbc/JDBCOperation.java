package com.WebLearning.fuckJdbc;


import java.sql.*;

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
            System.out.println("改变了 " + i + "同学的信息");
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
        String sql = "update students set times='" + student.getTimes() + "' where id='" + student.getId() + "'";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
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
            System.out.println("改变了 " + i + "同学的信息");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String args[]) {
        JDBCOperation.insert(new TKDstudent("111", "Male", 14));
        JDBCOperation.update(new TKDstudent("111", "Ian", 12));
    }


    /*

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bunoob"+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "zsy999666.";

    public static void main(String[] args) {

        String currentTable = "new_table";

        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            //这里是在mysql终端执行具体的命令
            sql = "INSERT INTO new_table (id,name,times) VALUES (111,Ian,20)";
            if (stmt.execute(sql)){
                System.out.println("操作成功");
            }

            //sql = "SELECT id, name , times FROM new_table";
            /*
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("，名称: " + name);
                System.out.print("\n");
            }

            // 完成后关闭
            rs.close();

            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
    */
}