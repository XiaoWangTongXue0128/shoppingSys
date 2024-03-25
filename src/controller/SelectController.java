package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectController extends HttpServlet {
    UserService userService = MySpring.getBean("service.UserService");
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aname =(String) request.getSession().getAttribute("aname");

        Float abalance = userService.selectMoney(aname);
        System.out.println(aname+"--"+abalance);
        request.setAttribute("abalance",abalance);
        request.getRequestDispatcher("showMoney.jsp").forward(request, response);
    }
}
