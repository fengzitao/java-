package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author fengzitao
 * @date 2022/01/23
 */
/*loadOnstartup的取值有两类情况
        （1）负整数:第一次访问时创建Servlet对象
        （2）0或正整数:服务器启动时创建Servlet对象，数字越小优先级越高 */
@WebServlet(urlPatterns = {"/servletdemo1"}, loadOnStartup = 1)
public class ServletDemo1 implements Servlet {
    private ServletConfig servletConfig;
    //每次请求Servlet时，Servlet容器都会调用Servlet的service()方法对请求进行处理
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("我被访问了");
    }


    //在Servlet实例化之后，容器将调用Servlet的==init()==方法初始化这个对象，
    //完成一些如加载配置文件、创建连接等初始化的工作。该方法只调用一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //该方法用来返回Servlet的相关信息，没有什么太大的用处，一般我们返回一个空字符串即可
    @Override
    public String getServletInfo() {
        return null;
    }

    //服务终止：当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法完成资源的释放。
    //在destroy()方法调用之后，容器会释放这个Servlet实例，该实例随后会被Java的垃圾收集器所回收
    @Override
    public void destroy() {


    }
}
