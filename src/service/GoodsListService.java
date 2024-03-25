package service;

import dao.GoodsDao;
import domain.Goods;
import domain.GoodsList;
import domain.Kind;
import util.MySpring;

import java.util.ArrayList;
import java.util.HashMap;


public class GoodsListService {
    private ArrayList<GoodsList> goodsListArrayList = new ArrayList<>();
    KindService kindService = MySpring.getBean("service.KindService");
    GoodsDao goodsDao = MySpring.getBean("dao.GoodsDao");
    //获取所有的商品种类
    HashMap<Integer, Kind> kindHashMap;
    //获取所有的Goods明细
    ArrayList<Goods> goodsArrayList ;
    public void addGoods(Integer cid,Integer quantity) {
        this.getKindHashMap();
        this.getGoodsListArrayList();
        this.getGoodsArrayList();
        for (Goods goods : goodsArrayList) {
            if (goods.getCid() == cid) {
                String cname = goods.getCname();
                Float cprice = goods.getCprice();
                Integer bid = goods.getBid();
                String bname = kindHashMap.get(bid).getBname();
                GoodsList goodsList = new GoodsList(bname, cname, cprice, quantity);
                goodsListArrayList.add(goodsList);
            }
        }

    }

    public void deleteGoodsList() {
        goodsListArrayList = new ArrayList<>();
    }
    public HashMap<Integer,Kind> getKindHashMap() {
        if (kindHashMap != null) {
            return kindHashMap;
        } else {
            kindHashMap = kindService.KindShowMap();
            return kindHashMap;
        }
    }
    public ArrayList<GoodsList> getGoodsListArrayList() {
        return goodsListArrayList;
    }

    public ArrayList<Goods> getGoodsArrayList() {
        if (goodsArrayList != null) {
            return goodsArrayList;
        } else {
            goodsArrayList = goodsDao.selectAllGoodsArrayList();
            return goodsArrayList;
        }
    }
    public Float howMoney(ArrayList<GoodsList> goodsLists) {
        Float money = 0f;
        for (GoodsList goodsList : goodsLists) {
            money=money+goodsList.getQuantity() * goodsList.getCprice();
        }
        System.out.println("houMoney:"+money);
        return money;
    }
}
