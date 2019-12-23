package com.qf.testdemo;

import com.qf.dao.BeforeIndexCourseDao;
import com.qf.pojo.Subject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 炜哥哥
 * @date 2019/12/18 16:23
 */
public class testdemo {
    @Test
    public void test() {


        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory sessionFactory = (SqlSessionFactory) classPathXmlApplicationContext.getBean("sessionFactory");
        SqlSession sqlSession = sessionFactory.openSession(true);

    }
}