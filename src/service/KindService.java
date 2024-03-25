package service;

import dao.KindDao;
import domain.Kind;
import util.MySpring;

import java.util.ArrayList;
import java.util.HashMap;

public class KindService {
    private HashMap<Integer, Kind> hashMap = new HashMap<>();
    KindDao kindDao = MySpring.getBean("dao.KindDao");
    ArrayList<Kind> kindArrayList;
    HashMap<Integer, Kind> kindHashMap;
    public ArrayList<Kind> KindShow() {

        if (kindArrayList != null) {
            return kindArrayList;
        } else {
            kindArrayList=kindDao.selectAllKindArrayList();
            return kindArrayList;
        }
    }
    public HashMap<Integer, Kind> KindShowMap() {
        if (kindHashMap != null) {
            return kindHashMap;
        } else {
            kindHashMap=kindDao.selectAllKindHashMap();
            return kindHashMap;
        }
    }
}
