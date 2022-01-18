package com.tunyl.demo.day1;

import com.tunyl.demo.day1.entity.Employee;
import com.tunyl.demo.day1.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MainTest2 {
    public static void main(String[] args) throws IOException {
        // 创建SqlSessionFactory
        String config = "com/tunyl/demo/day1/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取接口的代理对象
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            // 执行接口方法
            Employee employee = mapper.selectByEmp(1);
            // 打印结果
            System.out.println(employee);
        }
    }
}
