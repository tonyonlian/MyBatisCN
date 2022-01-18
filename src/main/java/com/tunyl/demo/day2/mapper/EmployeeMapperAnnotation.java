package com.tunyl.demo.day2.mapper;

import com.tunyl.demo.day2.entity.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {
    @Select("select * from employee where id=#{id}")
    Employee getEmpById(int id);
}
