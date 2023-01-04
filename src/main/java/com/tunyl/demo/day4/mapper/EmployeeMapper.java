package com.tunyl.demo.day4.mapper;

import com.tunyl.demo.day4.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  Employee 接口类
 */

public interface EmployeeMapper {
    /**
     * 单个值查询,sql中可以使用#{id}或#{任意标}或取参数
     * @param id id
     * @return employee
     */
    Employee selectByEmp(int id);

    /**
     * 多参数查询,使用#{param1,param2 ... paramN}获取参数，或使用#{arg0,arg1 ... argN}获取参数，或使用@Param("id") #{id} @Param("lastName") #{lastName}获取参数
     * @param id id
     * @param lastName lastName
     * @return Employee employee
     */
    Employee selectByIdAndLastName(int id, String lastName);

    /**
     * 封装map参数查询 ,sql中使用#{key}获取map中的value
     * @param map map
     * @return Employee employee
     */
    Employee selectByMap(Map map);

    /**
     * list 参数查询 ,sql中使用#{list[0]}获取集合中的元素
     * @param ids ids
     * @return Employee employee
     */
    Employee selectByList(List<Integer> ids);

    /**
     * 数组 参数查询 ,sql中使用#{array[0]}获取数组中的元素
     * @param ids ids
     * @return Employee employee
     */
    Employee selectByArray(int[] ids);

    /**
     * list 参数查询 ，sql中使用 #{collection[0]} 获取集合中的元素
     * @param ids ids
     * @return Employee employee
     */
    Employee selectByLink(List<Integer> ids);

}
