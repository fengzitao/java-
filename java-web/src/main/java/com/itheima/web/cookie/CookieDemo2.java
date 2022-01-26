package com.itheima.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/* 前面的案例中已经能够实现，AServlet给前端发送Cookie,BServlet从request中获取Cookie的功能
        * 对于AServlet响应数据的时候，Tomcat服务器都是基于HTTP协议来响应数据
        * 当Tomcat发现后端要返回的是一个Cookie对象之后，Tomcat就会在响应头中添加一行数据==`Set-Cookie:username=zs`==
        * 浏览器获取到响应结果后，从响应头中就可以获取到`Set-Cookie`对应值`username=zs`,并将数据存储在浏览器的内存中
        * 浏览器再次发送请求给BServlet的时候，浏览器会自动在请求头中添加==`Cookie: username=zs`==发送给服务端BServlet
        * Request对象会把请求头中cookie对应的值封装成一个个Cookie对象，最终形成一个数组
        * BServlet通过Request对象获取到Cookie[]后，就可以从中获取自己需要的数据

*/

/**
 * @author fengzitao
 * @date 2022/01/24
 */
@WebServlet(urlPatterns = {"/CookieDemo2"})
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //获取cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length != 0) {
            //遍历一下
            for (Cookie cookie : cookies) {
                String username = cookie.getName();
                if ("username".equals(username)) {
                    //解码
                    String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    System.out.println("username:" + value);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
