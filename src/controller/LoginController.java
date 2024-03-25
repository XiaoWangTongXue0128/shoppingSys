package controller;


import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    UserService userService = MySpring.getBean("service.UserService");
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        String value = userService.confirm(aname, apassword);

        //-Dfile.encoding=UTF-8
        if (value.equals("登录成功")) {
            //跳转购物页面
            request.getSession().setAttribute("aname",aname);
            System.out.println("2-LoginController登录成功");
            request.getRequestDispatcher("choose.jsp").forward(request,response);
        } else if (value.equals("账号或密码错误")){
            request.setAttribute("loginvalue", value);
            System.out.println("2-LoginController账号或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}

