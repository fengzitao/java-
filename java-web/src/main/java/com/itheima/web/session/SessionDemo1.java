package com.itheima.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
 Session:
  概念: Session,服务端会话跟踪技术,将数据保存到服务端。
    * Session是存储在服务端而Cookie是存储在客户端
    * 存储在客户端的数据容易被窃取和截获，存在很多不安全的因素
    * 存储在服务端的数据相比于客户端来说就更安全

  Session的工作流程
    * 在服务端的AServlet获取一个Session对象，把数据存入其中
    * 在服务端的BServlet获取到相同的Session对象，从中取出数据
    * 就可以实现一次会话中多次请求之间的数据共享了
    * 现在最大的问题是如何保证AServlet和BServlet使用的是同一个Session对象(在原理分析会讲解)?


  Session的基本使用
    在JavaEE中提供了HttpSession接口，来实现一次会话的多次请求之间数据共享功能。
    具体的使用步骤为:
      * 获取Session对象,使用的是request对象
         HttpSession session = request.getSession();
      * Session对象提供的功能:
         存储数据到 session 域中：void setAttribute(String name, Object o)
         根据 key，获取值：Object getAttribute(String name)
         根据 key，删除该键值对：void removeAttribute(String name)


  Session是基于Cookie来实现的
    (1)demo1在第一次获取session对象的时候，session对象会有一个唯一的标识，假如是`id:10`
    (2)demo1在session中存入其他数据并处理完成所有业务后，需要通过Tomcat服务器响应结果给浏览器
    (3)Tomcat服务器发现业务处理中使用了session对象，就会把session的唯一标识`id:10`当做一个cookie，添加`Set-Cookie:JESSIONID=10`到响应头中，并响应给浏览器
    (4)浏览器接收到响应结果后，会把响应头中的coookie数据存储到浏览器的内存中
    (5)浏览器在同一会话中访问demo2的时候，会把cookie中的数据按照`cookie: JESSIONID=10`的格式添加到请求头中并发送给服务器Tomcat
    (6)demo2获取到请求后，从请求头中就读取cookie中的JSESSIONID值为10，然后就会到服务器内存中寻找`id:10`的session对象，如果找到了，就直接返回该对象，如果没有则新创建一个session对象
    (7)关闭再重新打开浏览器后，因为浏览器的cookie已被销毁，所以就没有JESSIONID的数据，服务端获取到的session就是一个全新的session对象


  Session钝化与活化
    服务器重启后，Session中的数据是否还在? 经过测试，会发现只要服务器是正常关闭和启动，session中的数据是可以被保存下来的。
    那么Tomcat服务器到底是如何做到的呢? 具体的原因就是: Session的钝化和活化
      * 钝化：在服务器正常关闭后，Tomcat会自动将Session数据写入硬盘的文件中
          钝化的数据路径为:`项目目录\target\tomcat\work\Tomcat\localhost\项目名称\SESSIONS.ser`
      * 活化：再次启动服务器后，从文件中加载数据到Session中
          数据加载到Session中后，路径中的`SESSIONS.ser`文件会被删除掉
    对于上述的整个过程，大家只需要了解下即可。因为所有的过程都是Tomcat自己完成的，不需要我们参与。


   Session销毁
   两种方式：
     * 默认情况下，无操作，30分钟自动销毁
        对于这个失效时间，是可以通过配置进行修改的，在项目的web.xml中配置
          <session-config>
             <session-timeout>100</session-timeout>
          </session-config>
        如果没有配置，默认是30分钟，默认值是在Tomcat的web.xml配置文件中写死的

     * 调用Session对象的 invalidate() 进行销毁
*/


/**
 * @author fengzitao
 * @date 2022/01/24
 */
@WebServlet(urlPatterns = {"/SessionDemo1"})
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session对象、存储数据
        HttpSession session = req.getSession();
        session.setAttribute("username", "fzt");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
