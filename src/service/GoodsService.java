package service;

import dao.GoodsDao;
import domain.Goods;
import util.MySpring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GoodsService {
    GoodsDao goodsDao = MySpring.getBean("dao.GoodsDao");
    private HashMap<Integer, ArrayList<Goods>> hashMap = new HashMap<>();
    public HashMap<Integer, ArrayList<Goods>> goodsShow() {
        return goodsDao.selectAllGoods();
    }

    public void updateGoodsInventory(HashMap<Integer, Integer> goodsMap) {
        Iterator iterator = goodsMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer goodsCid = (Integer) iterator.next();
            Integer quantity = goodsMap.get(goodsCid);
            goodsDao.update(goodsCid, quantity);
        }
    }


}
