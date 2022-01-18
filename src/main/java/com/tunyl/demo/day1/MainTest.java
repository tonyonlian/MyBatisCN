package com.tunyl.demo.day1;

import com.tunyl.demo.day1.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *  简单的使用mybatis
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        // 加载配置
        String resource = "com/tunyl/demo/day1/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            /**
             *   selectOne(String statement,Objet parameter) 方法参数说明：
             *   @param statement  执行的stament的唯一key : ${映射文件namespace}.${标签id}
             *   @param parameter 传递给statment的参数
             */
           Employee employee =  session.selectOne("com.tunyl.demo.day1.mapper.EmployeeMapper.selectEmp",1);
           // 打印结果
           System.out.println(employee);
        }
    }
}
