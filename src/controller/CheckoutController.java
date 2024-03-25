package controller;

import domain.User;
import service.GoodsService;
import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class CheckoutController extends HttpServlet {
    UserService userService = MySpring.getBean("service.UserService");
    GoodsService goodsService = MySpring.getBean("service.GoodsService");
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = "";
        HttpSession session = request.getSession();
        Float money = (Float) session.getAttribute("money");
        String aname = (String) session.getAttribute("aname");
        HashMap<Integer, Integer> goodsMap = (HashMap<Integer, Integer>) session.getAttribute("goodsMap");
        Float abalance = userService.selectMoney(aname);
        if (money > abalance) {
            value = "欢迎你下次管理";
        } else {
            value="账户当前余额："+userService.updateUserMoney(aname, abalance - money)+"请及时充值";
        }
        goodsService.updateGoodsInventory(goodsMap);
        request.setAttribute("loginvalue", value);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
