package com.example.mybatis.test;

import com.example.mybatis.bean.Person;
import com.example.mybatis.bean.User;
import com.example.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-06- 10:07:00
 */
public class Demo1 {

    public static SqlSession getSqlSession() throws IOException {
        String file  = "mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(file);

//        Properties properties = new Properties();
//        Reader reader = Resources.getResourceAsReader(file);
//        properties.setProperty("driver","com.mysql.jdbc.Driver");
//        properties.setProperty("url","jdbc:mysql://127.0.0.1:3306/my_test?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
//        properties.setProperty("username","root");
//        properties.setProperty("password","root");

        //构建SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build( reader, "development",properties);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession提供了在数据库执行SQL命令所需要的所有方法
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    public void test1() throws IOException {
        SqlSession sqlSession = getSqlSession();
        //获取指定mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser("2134161564");
//        User user = sqlSession.selectOne("com.example.mybatis.mapper.UserMapper.selectUser","2134161564");
        System.out.println(user.toString());
    }

    public void test2() throws IOException {
        SqlSession sqlSession = getSqlSession();
        //获取指定mapper
        Person person = sqlSession.selectOne("com.example.mybatis.mapper.PersonMapper.selectPerson",1);
        System.out.println(person.toString());
    }
    public static void main(String[] args) throws IOException {
        new Demo1().test1();
//        new Demo1().test2();
    }
}
