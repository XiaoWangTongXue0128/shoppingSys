package dao;

import domain.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GoodsDao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/shoppingsystem?useSSL=false";
    private static String user = "wtc";
    private static String password = "52mq";
    private static HashMap<Integer, ArrayList<Goods>> hashMap = new HashMap<>();
    private static ArrayList<Goods> arrayList = new ArrayList<>();
    public HashMap<Integer, ArrayList<Goods>> selectAllGoods() {
        String sql = "SELECT CID,CNAME,CPRICE,INVENTORY,BID FROM goods";
        Goods goods = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs =pstat.executeQuery();
            while (rs.next()) {
                goods = new Goods();
                Integer cid = Integer.valueOf(rs.getString("CID"));
                goods.setCid(cid);
                goods.setCname(rs.getString("CNAME"));
                goods.setCprice(Float.parseFloat(rs.getString("CPRICE")));
                goods.setInventory(Integer.valueOf(rs.getString("inventory")));
                Integer bid = Integer.valueOf(rs.getString("BID"));
                goods.setBid(bid);
                ArrayList<Goods> arrayList = hashMap.get(bid);
                if (arrayList != null) {
                    arrayList.add(goods);
                }else {
                    arrayList = new ArrayList<>();
                    arrayList.add(goods);
                }
                hashMap.put(bid, arrayList);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hashMap;
    }


    public ArrayList<Goods> selectAllGoodsArrayList() {
        String sql = "SELECT CID,CNAME,CPRICE,INVENTORY,BID FROM goods";
        Goods goods = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs =pstat.executeQuery();
            while (rs.next()) {
                goods = new Goods();
                Integer cid = Integer.valueOf(rs.getString("CID"));
                goods.setCid(cid);
                goods.setCname(rs.getString("CNAME"));
                goods.setCprice(Float.parseFloat(rs.getString("CPRICE")));
                goods.setInventory(Integer.valueOf(rs.getString("inventory")));
                Integer bid = Integer.valueOf(rs.getString("BID"));
                goods.setBid(bid);
                arrayList.add(goods);
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
    public void update(Integer cid, Integer quantity) {

        String sql = "UPDATE GOODS SET INVENTORY = ? WHERE CID = ?";
        Goods goods = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, quantity);
            pstat.setInt(2, cid);
            pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
