package com.itheima.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*Cookie和Session的区别是什么?
  Cookie和Session的应用场景分别是什么?
    区别:
    * 存储位置：Cookie 是将数据存储在客户端，Session 将数据存储在服务端
    * 安全性：Cookie不安全，Session安全
    * 数据大小：Cookie最大3KB，Session无大小限制
    * 存储时间：Cookie可以通过setMaxAge()长期存储，Session默认30分钟
    * 服务器性能：Cookie不占服务器资源，Session占用服务器资源

    应用场景:
    * 购物车:使用Cookie来存储
    * 以登录用户的名称展示:使用Session来存储
    * 记住我功能:使用Cookie来存储
    * 验证码:使用session来存储

    * 结论
    * Cookie是用来保证用户在未登录情况下的身份识别
    * Session是用来保存用户登录后的数据
*/


/**
 * @author fengzitao
 * @date 2022/01/24
 */
@WebServlet(urlPatterns = {"/SessionDemo2"})
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session对象、获取数据
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        System.out.println(username);

        //Session的销毁
        //session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
