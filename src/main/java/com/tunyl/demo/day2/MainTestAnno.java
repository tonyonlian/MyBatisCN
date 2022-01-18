package com.tunyl.demo.day2;

import com.tunyl.demo.day2.entity.Employee;
import com.tunyl.demo.day2.mapper.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 演示：接口绑定注解，注册时使用  <mapper class="com.tunyl.demo.day2.mapper.EmployeeMapperAnnotation"/>
 *
 */
public class MainTestAnno {
    public static void main(String[] args) throws IOException {
        // 创建SqlSessionFactory
        String config = "com/tunyl/demo/day2/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取接口的代理对象
            EmployeeMapperAnnotation mapper = session.getMapper(EmployeeMapperAnnotation.class);
            // 执行接口方法
            Employee employee = mapper.getEmpById(1);
            // 打印结果
            System.out.println(employee);
        }
    }
}
