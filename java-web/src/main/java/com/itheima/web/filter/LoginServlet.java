package com.itheima.web.filter;

import com.itheima.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fengzitao
 * @date 2022/01/24
 */
@WebServlet(urlPatterns = {"/user/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        if("fzt".equals(name) && "123".equals(pwd)){
            User user = new User();
            user.setId(1);
            user.setName(name);
            user.setHost("xdclass.net");
            req.getSession().setAttribute("loginUser", user);
            req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req,resp);
        }else{
            System.out.println("账号密码错误");
            req.setAttribute("msg","账号密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
