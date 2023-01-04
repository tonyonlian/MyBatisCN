package com.tunyl.demo.day4;

import com.tunyl.demo.day4.entity.Employee;
import com.tunyl.demo.day4.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MainTest {
    public static void main(String[] args) throws IOException {
        String config = "com/tunyl/demo/day4/config/mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 获取自动提交状态为false的SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            // 单参数查询
            Employee employee = mapper.selectByEmp(1);
            System.out.println(employee);


            Employee employee1 = mapper.selectByIdAndLastName(1, "tom");
            System.out.println(employee1);

            Map map = new HashMap();
            map.put("id", 1);
            map.put("lastName", "tom");
            // 动态设置表名，sql中使用${tableName}获取参数值
            map.put("tableName","employee");
            Employee employee2 = mapper.selectByMap(map);
            System.out.println(employee2);


            List<Integer> list = new ArrayList<>();
            list.add(1);
            Employee employee3 = mapper.selectByList(list);
            System.out.println(employee3);

            int[] arr = {1,2,3};
            Employee employee4 = mapper.selectByArray(arr);
            System.out.println(employee4);

            List<Integer> lis = new LinkedList<>();
            lis.add(1);
            lis.add(3);

            Employee employee5 = mapper.selectByLink(lis);
            System.out.println(employee5);


            // 提交
            session.commit();

        }

    }
}
