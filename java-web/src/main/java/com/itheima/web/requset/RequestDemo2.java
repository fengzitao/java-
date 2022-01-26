package com.itheima.web.requset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fengzitao
 * @date 2022/01/23
 */
@WebServlet(urlPatterns = {"/RequestDemo2"})
public class RequestDemo2 extends HttpServlet {
    /*
      Request请求转发
        (1)浏览器发送请求给服务器，服务器中对应的资源A接收到请求
        (2)资源A处理完请求后将请求发给资源B
        (3)资源B处理完后将结果响应给浏览器
        (4)请求从资源A到资源B的过程就叫==请求转发==
       req.getRequestDispatcher("资源B路径").forward(req,resp);

       虽然后台从 /RequestDemo2 转发到 /RequestDemo3 ,但是浏览器的地址一直是 /RequestDemo2 ,未发生变化。
       ！！！请求转发只能转发到当前服务器的内部资源,不能从一个服务器通过转发访问另一台服务器
       ！！！一次请求：可以在转发资源间使用request共享数据, 虽然后台从`/RequestDemo2`转发到`/RequestDemo3`，但是这个只有一次请求
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServletDemo2: 我先来处理");
        // 此处主要解决的问题是把请求从/RequestDemo2 转发到/RequestDemo3 的时候，如何传递数据给/RequestDemo3。
        // * 存储数据到request域(request对象中)  void setAttribute(String name,Object o)；
        // * 根据key获取值  Object getAttribute(String name);
        // * 根据key删除该键值对  void removeAttribute(String name);
        req.setAttribute("msg","hello");

        // 请求调度到/RequestDemo3
        req.getRequestDispatcher("/RequestDemo3").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
