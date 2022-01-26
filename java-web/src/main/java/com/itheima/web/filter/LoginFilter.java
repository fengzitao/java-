package com.itheima.web.filter;

/*
    过滤器实战之Filter用户登录访问个人页面拦截

 */


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author fengzitao
 * @date 2022/01/24
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/user/*"}, initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8"),
        @WebInitParam(name = "loginPage", value = "/login.jsp")
})
public class LoginFilter implements Filter {
    private String encoding;
    private String loginPage;
    private FilterConfig Config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.Config = filterConfig;
        this.encoding = Config.getInitParameter("encoding");
        this.loginPage = Config.getInitParameter("loginPage");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter开始工作～");
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        //session里面有用户信息
        if (session.getAttribute("loginUser") != null) {
            System.out.println("曾经登陆过");
            filterChain.doFilter(req, resp);
        } else {
            String requestURI = req.getRequestURI();
            if ("/java_web/user/LoginServlet".equals(requestURI)) {
                filterChain.doFilter(req, resp);
            } else {
                System.out.println("非法登陆，请登录");
                req.setAttribute("msg", "非法访问，请登录");
                //请求转发到登陆页面
                req.getRequestDispatcher(loginPage).forward(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
