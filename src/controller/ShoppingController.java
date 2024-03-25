package controller;

import domain.Goods;
import service.GoodsService;
import util.MySpring;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingController extends HttpServlet {
    GoodsService goodsService = MySpring.getBean("service.GoodsService");
    HashMap<Integer, ArrayList<Goods>> goodHashMap;
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bid=request.getParameter("bid");
        if (goodHashMap == null) {
            goodHashMap = goodsService.goodsShow();
        }
        ArrayList<Goods> goodsArrayList = goodHashMap.get(Integer.parseInt(bid));
        request.setAttribute("goodsArrayList",goodsArrayList);
        System.out.println("4-ShoppingController展示对应商品");
        request.getRequestDispatcher("shopping.jsp").forward(request, response);
    }
}
