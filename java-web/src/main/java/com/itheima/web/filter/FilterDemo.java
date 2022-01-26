package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/*
    Servlet里面的过滤器作用
    * 动态地拦截请求和响应，变换或使用包含在请求或响应中的信息
    * 在客户端的请求访问后端资源之前，拦截这些请求。
    * 在服务器的响应发送回客户端之前，处理这些响应。

    Filter的生命周期
    * init(FilterConfig filterConfig) //只容器初始化的时候调用一次，即应用启动的时候加载一次
    * doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 只要命中过滤规则就触发，可以在filter中根据条件决定是否调用chain.doFilter(request, response)方法， 即是否让目标资源执行
    * destroy() //只容器销毁的时候调用一次，即应用停止的时候调用一次

    元注解： @WebFilter
    * 该Filter是否支持异步操作模式: 'asyncSupported'
    * 指定Filter对哪种dispatcher模式进行过滤：'dispatcherType'，该属性支持:
        request：默认值，浏览器直接请求的资源会被过滤器拦截
        Forward：转发访问资源会被过滤器拦截
        include：包含访问资源
        Error：错误跳转资源
        Async：异步访问资源
    * Filter 显示的名称: 'displayName'
    * Filter的名称: 'filterName'
    * Filter的配置参数: 'initParams'
    * 过滤的Servlet可以指定多个,表示对这几个特定的的servlet 进行过滤: 'servletNames'
    * 指定 Filter拦截的 URL，和上面的servletNames配置一样，用*可以表示通配符，但是不用字母后加*，应该按照模块划分，比如/user/*: 'urlPatterns/value'

    FilterConfig类：
    过滤器配置类，可以通过这个获取过滤器基本信息
 */


/**
 * @author fengzitao
 * @date 2022/01/24
 */
@WebFilter(filterName = "FilterDemo", urlPatterns = {"/order/*"}, initParams = {
        @WebInitParam(name = "encoding",value = "utf-8"),
        @WebInitParam(name = "loginPage",value = "/login.jsp")
}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FilterDemo implements Filter {
    private FilterConfig filterConfig;
    private String encoding;
    private String loginPage;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomFilter init ");

        this.filterConfig = filterConfig;
        String filterName = filterConfig.getFilterName();
        System.out.println("filterName:"+filterName);
        this.encoding = filterConfig.getInitParameter("encoding");
        this.loginPage = filterConfig.getInitParameter("loginPage");
        System.out.println("encoding:" + encoding + ", loginPage:" + loginPage);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter ");
        //解决中文乱码问题
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=utf-8");

        //让请求继续往下走
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy ");
    }
}
