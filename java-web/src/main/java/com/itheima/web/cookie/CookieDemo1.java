package com.itheima.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
/*
 会话:用户打开浏览器，访问web服务器的资源，会话建立，直到有一方断开连接，会话结束。在一次会话中可以包含 多次 请求和响应。
 从浏览器发出请求到服务端响应数据给前端之后，一次会话(在浏览器和服务器之间)就被建立了，会话被建立后，如果浏览器或服务端都没有被关闭，则会话就会持续建立着
 浏览器和服务器就可以继续使用该会话进行请求发送和响应，上述的整个过程就被称之为==会话==
 (1)客户端会话跟踪技术：==Cookie==
 (2)服务端会话跟踪技术：==Session==
 它们之间最大的区别:==Cookie是存储在浏览器端而Session是存储在服务器端==


 默认情况下，Cookie存储在浏览器内存中，当浏览器关闭，内存释放，则Cookie被销毁
   * Cookie其实已经为我们提供好了对应的API来完成这件事，这个API就是 void setMaxAge(int seconds)
   * seconds 值为:
      1.正数：将Cookie写入浏览器所在电脑的硬盘，持久化存储。到时间自动删除
      2.负数：默认值，Cookie在当前浏览器内存中，当浏览器关闭，则Cookie被销毁
      3.零：删除对应Cookie


 Cookie存储中文
   Cookie不能直接存储中文, 这个时候，我们可以使用之前学过的一个知识点叫`URL编码`，所以如果需要存储中文，就需要进行转码，具体的实现思路为:
      1.在AServlet中对中文进行URL编码，采用URLEncoder.encode()，将编码后的值存入Cookie中
      2.在BServlet中获取Cookie中的值,获取的值为URL编码后的值
      3.将获取的值在进行URL解码,采用URLDecoder.decode()，就可以获取到对应的中文值

 */


/**
 * @author fengzitao
 * @date 2022/01/24
 */
@WebServlet(urlPatterns = {"/CookieDemo1"})
public class CookieDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //创建Cookie对象，并设置数据, Cookie不能直接存储中文 所以必须先转码
        Cookie cookie = new Cookie("username", URLEncoder.encode("冯子滔", "UTF-8"));
        //设置Cookie存活时间 7天
        cookie.setMaxAge(60 * 60 * 24 * 7);
        //发送Cookie到客户端：使用==response==对象
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
