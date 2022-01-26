package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author fengzitao
 * @date 2022/01/23
 */
@WebServlet(urlPatterns = "/httpservletdemo1")
public class HttpServletDemo1 extends HttpServlet {
    /*POST请求解决方案
      分析出现中文乱码的原因：
         1.POST的请求参数是通过request的getReader()来获取流中的数据
         2.TOMCAT在获取流的时候采用的编码是ISO-8859-1
         3.ISO-8859-1编码是不支持中文的，所以会出现乱码
     解决方案：
         1.页面设置的编码格式为UTF-8
         2.把TOMCAT在获取流数据之前的编码设置为UTF-8
         3.通过request.setCharacterEncoding("UTF-8")设置编码,UTF-8也可以写成小写
    */

    /*
     分析GET请求出现乱码的原因:
        (1)浏览器通过HTTP协议发送请求和数据给后台服务器（Tomcat)
        (2)浏览器在发送HTTP的过程中会对中文数据进行URL==编码==
        (3)在进行URL编码的时候会采用页面`<meta>`标签指定的UTF-8的方式进行编码，`张三`编码后的结果为`%E5%BC%A0%E4%B8%89`
        (4)后台服务器(Tomcat)接收到`%E5%BC%A0%E4%B8%89`后会默认按照`ISO-8859-1`进行URL==解码==
        (5)由于前后编码与解码采用的格式不一样，就会导致后台获取到的数据为乱码。
     思考: 如果把`req.html`页面的`<meta>`标签的charset属性改成`ISO-8859-1`,后台不做操作，能解决中文乱码问题么?
          答案是否定的，因为`ISO-8859-1`本身是不支持中文展示的，所以改了<meta>标签的charset属性后，会导致页面上的中文内容都无法正常展示。
          分析完上面的问题后，我们会发现，其中有两个我们不熟悉的内容就是URL编码和URL解码。
     get请求出现乱码的原因总结：
    * 浏览器把 URL 中的中文参数按照`UTF-8`进行URL编码
    * Tomcat对获取到的内容进行了`ISO-8859-1`的URL解码
    * 在控制台就会出现类上`å¼ ä¸`的乱码，最后一位是个空格

    解决方案：
        1.按照ISO-8859-1编码获取乱码`å¼ ä¸`对应的字节数组
        2.按照UTF-8编码获取字节数组对应的字符串
        java中提供了编码以及解码的工具：
            String encode = URLEncoder.encode(username, "utf-8");
            String decode = URLDecoder.decode(encode, "uft-8");
            String s = new String(username,"UTF-8");

      !!!! Tomcat8.0之后，已将GET请求乱码问题解决，设置默认的解码方式为UTF-8
    */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.解决中文乱码问题 此处是为了解决post请求的乱码
        req.setCharacterEncoding("utf-8");

        //2.HTTP请求数据总共分为三部分内容，分别是 请求行、请求头、请求体

        //2.1 请求行 包含三块内容，分别是请求方式、请求资源路径、HTTP协议及版本
        //获得请求方法
        String method = req.getMethod();
        //获取虚拟目录（项目访问路径）/java_web
        String contextPath = req.getContextPath();
        //获取URL(统一资源定位符):  http://localhost:8080/java_web/httpservletdemo1
        StringBuffer requestURL = req.getRequestURL();
        //获取URI(统一资源标识符)   /java_web/httpservletdemo1
        String requestURI = req.getRequestURI();
        //获取请求参数(GET方式):  username=fengzitao  如果后面还有其他参数会加上&
        //例如 username=fengzitao&password=123&xxx=yyyy
        String queryString = req.getQueryString();

        System.out.println("获取请求行的内容：");
        System.out.println("method:" + method + ",contextPath：" + contextPath + ",requestURL：" +
                requestURL + ",requestURI:" + requestURI + ",queryString:" + queryString);


        //2.2 获取请求头数据
        //对于请求头的数据，格式为key: value如下
        String agent = req.getHeader("user-agent");
        System.out.println("获取请求头的内容：");
        System.out.println("user-agent：" + agent);


        //2.3 获取请求体数据
        //方式一：getParameter()方法
        Object username = req.getParameter("userName");
        Object password = req.getParameter("password");
        System.out.println(username + " " + password);
        System.out.println("============");
        //方式二：getParamterMap()
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.print(key + ":");
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println("============");
        //方式三：getParameterValues()
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.print(hobby + " ");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //3.获取请求体数据
        //BufferedReader reader = req.getReader();
        //String line = reader.readLine();
        //System.out.println(line);
        //BufferedReader流是通过request对象来获取的，当请求完成后request对象就会被销毁，
        //request对象被销毁后，BufferedReader流就会自动关闭，所以此处就不需要手动关闭流了

        doGet(req, resp);
    }
}
