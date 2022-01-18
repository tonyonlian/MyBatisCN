package com.tunyl.demo.day3.mapper;

import com.tunyl.demo.day3.entity.Employee;

/**
 *  Employee 接口类
 */

public interface EmployeeMapper {
    /**
     * 查询
     * @param id id
     * @return employee
     */
    Employee selectByEmp(int id);

    // 知识补充： 增、删、改 mybatis 允许直接返回下面类型值： int Integer long Long boolean Boolean,只需要修改接口类的方法返回值，不需要修改mapper.xml

    /**
     * 增加
     * @param employee employee
     */

    void addEmp(Employee employee);

    /**
     * 更新
     * @param employee employee
     */
    boolean updateEmp(Employee employee);

    /**
     * 删除
     * @param id id
     */
    void deleteByEmp(int id);


}
