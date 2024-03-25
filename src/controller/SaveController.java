package controller;

import domain.GoodsList;
import service.GoodsListService;
import util.MySpring;

import javax.crypto.spec.PSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SaveController extends HttpServlet {
    GoodsListService goodsListService= MySpring.getBean("service.GoodsListService");
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String hidden=request.getParameter("hidden");
        HttpSession session = request.getSession();
        //获取之前的购物清单
        HashMap<Integer, Integer> goodsMap = (HashMap<Integer, Integer>) session.getAttribute("goodsMap");
        if (goodsMap == null) {
            goodsMap = new HashMap<>();

        }

        String[] cids = request.getParameterValues("cid");
        String[] cidQuantitys = request.getParameterValues("cidQuantity");

        if (cids != null && cidQuantitys != null) {
            for (int i = 0; i < cids.length; i++) {
                String cid = cids[i];
                for (int j = 0; j < cidQuantitys.length; j++) {
                    String cidQuantity = cidQuantitys[j];
                    int left = cidQuantity.indexOf("-");
                    int right=cidQuantity.indexOf(":");
                    String value =cidQuantity.substring(left+1, right);
                    String qantity = cidQuantity.substring(right + 1);
                    System.out.println(value + "---" + qantity);
                    if (value.equals(cid)) {
                        Integer oldQantity=goodsMap.get(Integer.parseInt(cid));
                        if (oldQantity != null) {
                            goodsMap.put(Integer.parseInt(cid), oldQantity + Integer.parseInt(qantity));
                        } else {
                            goodsMap.put(Integer.parseInt(cid), Integer.parseInt(qantity));
                        }
                        break;
                    }
                }
            }

        }
        session.removeAttribute("goodsMap");
        session.setAttribute("goodsMap", goodsMap);
        goodsListService.deleteGoodsList();

        if (hidden.equals("继续购物")) {
            request.getRequestDispatcher("kindShow.jsp").forward(request, response);
        } else {
            Iterator iterator = goodsMap.keySet().iterator();
            while (iterator.hasNext()) {
                Integer key = (Integer) iterator.next();
                Integer value = goodsMap.get(key);
                goodsListService.addGoods(key,value);
            }
            ArrayList<GoodsList> goodsLists = goodsListService.getGoodsListArrayList();
            Float money = goodsListService.howMoney(goodsLists);
            session.setAttribute("goodsLists", goodsLists);
            session.setAttribute("money",money);
            request.getRequestDispatcher("goodsListShow.jsp").forward(request, response);
        }
    }
}
