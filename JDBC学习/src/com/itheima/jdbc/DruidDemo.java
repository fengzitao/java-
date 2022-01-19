package com.itheima.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author fengzitao
 * @date 2022/01/19
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3. 加载配置文件
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("JDBC学习/sources/druid.properties");
        prop.load(fis);

        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获得数据库连接
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        //6.继续后面的操作 。。。。。
        String sql = "select * from student where sid = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 1);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int sid = resultSet.getInt("sid");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            Date birth = resultSet.getDate("birth");
            String address = resultSet.getString("address");

            System.out.println(sid+" "+name+" "+gender+" "+age+" "+birth+" "+address);
        }
        resultSet.close();
        ps.close();

        //获得当前用户所在目录
        System.out.println(System.getProperty("user.dir"));  //Users/fzt/IdeaProjects/java学习
    }

    @Test
    public void testInputStreamLoadPath() throws Exception {
        FileInputStream fis = new FileInputStream("sources/druid.properties");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
        System.out.println(System.getProperty("user.dir"));
        fis.close();
    }
}
