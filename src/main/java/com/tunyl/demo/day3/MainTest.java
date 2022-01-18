package com.tunyl.demo.day3;

import com.tunyl.demo.day3.entity.Employee;
import com.tunyl.demo.day3.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MainTest {
    public static void main(String[] args) throws IOException {
        String config = "com/tunyl/demo/day3/config/mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 获取自动提交状态为false的SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            // 查询
            Employee employee = mapper.selectByEmp(1);
            System.out.println(employee);

            // 查入
            Employee employee1 = new Employee();
            employee1.setEmail("xxx@qq.com");
            employee1.setLastName("xxx");
            employee1.setGender('1');
            mapper.addEmp(employee1);
            System.out.println(employee1.getId());

            // 更新

            Employee employee2 = new Employee();
            employee2.setId(2);
            employee2.setGender('2');
            employee2.setEmail("yyy@qq.com");
            employee2.setLastName("yyyy");
            boolean b = mapper.updateEmp(employee2);
            System.out.println(b);
            // 删除
            mapper.deleteByEmp(3);

            // 提交
            session.commit();

        }

    }
}
