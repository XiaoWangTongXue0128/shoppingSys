package dao;

import domain.User;

import java.sql.*;

public class UserDao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/shoppingsystem?useSSL=false";
    private static String user = "wtc";
    private static String password = "52mq";
    public User selectOne(String aname) {
        String sql = "SELECT ANAME,APASSWORD,ABALANCE FROM USERS WHERE ANAME = ?";
        User newuser = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, aname);
            ResultSet rs =pstat.executeQuery();
            if (rs.next()) {
                newuser = new User();
                newuser.setAname(rs.getString("aname"));
                newuser.setApassword(rs.getString("apassword"));
                newuser.setAbalance(Float.parseFloat(rs.getString("abalance")));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return newuser;
    }
    public User insert(String aname,String apassword,Float abalance) {
        String sql = "INSERT INTO USERS VALUES (?, ?, ?)";
        User newuser = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, aname);
            pstat.setString(2, apassword);
            pstat.setString(3, String.valueOf(abalance));
            pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return newuser;
    }

    public Boolean update(String aname,Float money) {
        String sql = "UPDATE USERS SET ABALANCE = ? WHERE ANAME = ?";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setFloat(1, money);
            pstat.setString(2, aname);
            int num=pstat.executeUpdate();
            if (num!=0) {
                return true;
            }
            pstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
