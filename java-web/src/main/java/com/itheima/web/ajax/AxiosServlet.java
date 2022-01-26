package com.itheima.web.ajax;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fengzitao
 * @date 2022/01/25
 */
@WebServlet(urlPatterns = {"/axiosServlet"})
public class AxiosServlet extends HttpServlet {

/*  获取请求参数
    由于前端提交的是 json 格式的数据，所以我们不能使用 `request.getParameter()` 方法获取请求参数
      * 如果提交的数据格式是 `username=zhangsan&age=23&xxx=yyy` ，后端就可以使用 `request.getParameter()` 方法获取
      * 如果提交的数据格式是 json，后端就需要通过 request 对象获取输入流，再通过输入流读取数据
      * 将获取到的请求参数（json格式的数据）转换为 java 对象
*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
        //1. 接收请求参数(非json格式)
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(name + ", " + age);

        System.out.println("=======================");
        //1. 接收请求参数(Json格式)
        //获取包含请求参数的json字符串
        String jsonStr = req.getReader().readLine();
        //使用fastjson提供的工具类，把json字符串转换成java类
        User user = JSON.parseObject(jsonStr, User.class);
        System.out.println(user);

        //2. 响应数据
        resp.getWriter().write("hello Axios~");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
