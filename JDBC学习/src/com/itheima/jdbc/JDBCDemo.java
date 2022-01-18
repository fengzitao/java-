package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fengzitao
 * @date 2022/01/18
 */
public class JDBCDemo {

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        //方式一：
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "123456bb";
        Connection conn = DriverManager.getConnection(url, user, password);
        //方式二：用户名和密码可以写进url中
        //String url = "jdbc:mysql://127.0.0.1:3306/student?user=root&&password=123456bb&&useSSL=false";
        //Connection conn = DriverManager.getConnection(url);

        //3. 定义sql
        String sql1 = "update student set age = 20 where sid = 1";
        //4. 获取statement对象
        Statement statement = conn.createStatement();
        //5. 执行sql
        int i = statement.executeUpdate(sql1);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("无修改内容");
        }

        //6.释放资源
        statement.close();
        conn.close();
    }


    @Test
    public void testResultSet() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        //方式一：
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "123456bb";
        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "select * from student";
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        while (resultSet.next()) {
            int sid = resultSet.getInt("sid");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            Date birth = resultSet.getDate("birth");
            String address = resultSet.getString("address");
            System.out.println(sid+" "+name+" "+gender+" "+age+" "+birth+" "+address);
        }

        //7.释放资源
        resultSet.close();
        stat.close();
        conn.close();
    }

    @Test
    public void testResultSet2() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456bb";
        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "select * from student";
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int sid = resultSet.getInt("sid");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            Date birth = resultSet.getDate("birth");
            String address = resultSet.getString("address");
            Student student = new Student();
            student.setAddress(address);
            student.setAge(age);
            student.setBirth(birth);
            student.setGender(gender);
            student.setName(name);
            student.setSid(sid);
            students.add(student);
        }
        System.out.println(students);
        //7.释放资源
        resultSet.close();
        stat.close();
        conn.close();
    }

    //PrepareStatement 防止sql注入
    @Test
    public void testPrepareStatement() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456bb";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 定义sql  问号？用于替代真实查询值
        String sql = "select * from student where sid = ? and name = ?";
        //获得prepareStatement对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2,"李四");

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int sid = resultSet.getInt("sid");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            Date birth = resultSet.getDate("birth");
            String address = resultSet.getString("address");

            System.out.println(sid+" "+name+" "+gender+" "+age+" "+birth+" "+address);
        }

        //7.释放资源
        resultSet.close();
        preparedStatement.close();
        conn.close();
    }
}
