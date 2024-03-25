package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistController extends HttpServlet {
    UserService userService = MySpring.getBean("service.UserService");
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        Float abalance = Float.parseFloat(request.getParameter("abalance"));
        String value = userService.regist(aname, apassword, abalance);
        request.setAttribute("registvalue",value);
        request.getRequestDispatcher("regist.jsp").forward(request,response);

    }


}
