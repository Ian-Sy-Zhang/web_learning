package com.WebLearning.fuckJdbc;
import java.sql.*;




//数据访问层：原子性的增删改查
public class StudentDao {
	
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

    public  int insert(Student student) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into Student (id,name,age,address) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getID());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getAddressString());
            i = pstmt.executeUpdate();
            System.out.println("插入了 " + i + "同学的信息");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null ) conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return i;
    }

    public static Integer getAll() {
        Connection conn = getConn();
        String sql = "select * from Student";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
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
        }finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null ) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
        return null;
    }

    public static int login(String name, String id) {
        Connection conn = getConn();
        String sql = "select * from Student where id=? and name = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,name);
            ResultSet i = pstmt.executeQuery();
            int count= 0;
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

    public  int delete(String id) {
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from Student where id='" + id + "'";
        PreparedStatement pstmt = null;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("删除了 " + i + "同学的信息");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null ) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
        return i;
    }
    
    //查询学生的具体信息
    public  Student check(String ID) {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	Connection connection = getConn();
    	String sql = "select * from Student where ID =?";
    	try {
    		pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				Student student = new Student(ID, name, age, address);
				return student;
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
		return null;
    	
}

    
    //查询学生是否存在于数据库中，区别于check方法
    public  boolean IsExsit(String ID) {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	Connection connection = getConn();
    	String sql = "select * from Student where ID =?";
    	try {
    		pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return false;
    }

    public static void main(String args[]) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student("22","cy",20,"nju");
        System.out.println(studentDao.insert(student));
    }
}
