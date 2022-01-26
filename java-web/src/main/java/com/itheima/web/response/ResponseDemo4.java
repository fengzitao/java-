package com.itheima.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/*
  1.Response设置响应数据功能介绍
    HTTP响应数据总共分为三部分内容，分别是 响应行、响应头、响应体，对于这三部分内容的数据，response对象都提供了哪些方法来进行设置?
    1.响应行:  HTTP/1.1 2OO OK
        void setStatus(int sc);
    2.响应头:  Content-type：text/html
        设置响应头键值对 void setHeader(String name,String value);
    3.响应体:  <html><head><head/><body><body/><html/>
        对于响应体，是通过字符、字节输出流的方式往浏览器写，
        获取字符输出流: PrintWriter getWriter();
        获取字节输出流: ServletOutputStream getOutputStream();

  2.Respones请求重定向
    Response重定向(redirect):一种资源跳转方式
    (1)浏览器发送请求给服务器，服务器中对应的资源A接收到请求
    (2)资源A现在无法处理该请求，就会给浏览器响应一个302的状态码+location的一个访问资源B的路径
    (3)浏览器接收到响应状态码为302就会重新发送请求到location对应的访问地址去访问资源B
    (4)资源B接收到请求后进行处理并最终给浏览器响应结果，这整个过程就叫==重定向==
    (5)重定向后，浏览器的地址会改变为资源B的地址

    resp.setStatus(302);
    resp.setHeader("location","资源B的访问路径");

    重定向的特点
    (1)浏览器地址栏路径发送变化
    (2)可以重定向到任何位置的资源(服务内容、外部均可)
    (3)两次请求，不能在多个资源间使用request共享数据


  3.Response响应字符数据
    要想将字符数据写回到浏览器，我们需要两个步骤:
    (1)通过Response对象获取字符输出流： PrintWriter writer = resp.getWriter();
    (2)通过字符输出流写数据: writer.write("aaa");

  4.Response响应字节数据
    要想将字节数据写回到浏览器，我们需要两个步骤:
    (1)通过Response对象获取字节输出流：ServletOutputStream outputStream = resp.getOutputStream();
    (2)通过字节输出流写数据: outputStream.write(字节数据);
*/



/**
 * @author fengzitao
 * @date 2022/01/23
 */
@WebServlet(urlPatterns = "/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo4~");
        //获取上下文路径  /java_web
        String contextPath = req.getContextPath();

        //==重定向==
        //方式一:
        //设置响应状态码 302
        //resp.setStatus(302);
        //设置响应头 Location
        //resp.setHeader("Location",contextPath + "/ResponseDemo5");

        //方式二：
        //resp.sendRedirect(contextPath + "/ResponseDemo5");




        //==Response响应字符数据==
        // 1.向浏览器返回一个简单的字符串`aaa`
        //PrintWriter writer = resp.getWriter();
        //writer.write("aaa");

        // 2.向浏览器返回一串html字符串，并且能被浏览器解析
        //resp.setHeader("content-type", "text/html");
        //PrintWriter writer = resp.getWriter();
        //writer.write("<h1>aaa</h1>");

        // 3.返回一个中文的字符串"你好"，需要注意设置响应数据的编码为utf-8
        //resp.setContentType("text/html;charset=utf-8");
        //PrintWriter writer = resp.getWriter();
        //writer.write("你好");


        //==Response响应字节数据==
        //返回一个图片文件到浏览器
        FileInputStream fis = new FileInputStream("/Users/fzt/IdeaProjects/java学习/java-web/src/main/webapp/a.jpg");
        ServletOutputStream os = resp.getOutputStream();

        //普通写法---比较复杂
        /*byte[] arr = new byte[1024];
        int len;
        while ((len = fis.read(arr)) != -1) {
            os.write(arr,0,len);
        }
        fis.close();*/

        //优化写法---比较简单 一行搞定
        //完成流的copy  IOUtils类是pom依赖中的commons-io包提供的工具类
        IOUtils.copy(fis,os);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
