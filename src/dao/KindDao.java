package dao;

import domain.Kind;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class KindDao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/shoppingsystem?useSSL=false";
    private static String user = "wtc";
    private static String password = "52mq";
    private static ArrayList<Kind> arrayList=new ArrayList<>();
    private static HashMap<Integer, Kind> kindHashMap=new HashMap<>();
    public ArrayList<Kind> selectAllKindArrayList() {
        String sql = "SELECT BID,BNAME FROM KIND";
        Kind kind;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs =pstat.executeQuery();
            while (rs.next()) {
                kind = new Kind();
                kind.setBid(Integer.valueOf(rs.getString("bid")));
                kind.setBname(rs.getString("bname"));
                arrayList.add(kind);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }
    public HashMap<Integer, Kind> selectAllKindHashMap() {
        String sql = "SELECT BID,BNAME FROM KIND";
        Kind kind;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs =pstat.executeQuery();
            while (rs.next()) {
                kind = new Kind();
                kind.setBid(Integer.valueOf(rs.getString("bid")));
                kind.setBname(rs.getString("bname"));
                kindHashMap.put(kind.getBid(), kind);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kindHashMap;
    }

}
