package controller;

import domain.Kind;
import service.KindService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ShowKindController extends HttpServlet {
    KindService kindService = MySpring.getBean("service.KindService");
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Kind> kindArrayList = kindService.KindShow();
        request.getSession().setAttribute("kindArrayList", kindArrayList);
        System.out.println("3-ShowKindController展示商品种类");
        request.getRequestDispatcher("kindShow.jsp").forward(request,response);
    }
}
