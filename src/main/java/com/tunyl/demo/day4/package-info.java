package com.tunyl.demo.day4;

/**
 * 参数的处理
 *
 * 1.单个参数：mybatis为做任务处理
 * #{参数名}，取出参数
 *
 * 2.多个参数：mybatis会特殊处理
 * 多个参数会封闭成map
 *   key:param1 param2 ... paramN 或者参数索引也可以
 *   value:为传入的参数
 *   #{key}就是从map中获取指定key的值
 *
 * Employee selectByIdAndLastName(int id, String lastName);
 * select * from employee where id = #{id} and last_name=#{lastName}
 * Error: Parameter 'id' not found. Available parameters are [arg1, arg0, param1, param2]
 * 正确写法 （不会报错,可正常查询）
 * select * from employee where id = #{arg0} and last_name=#{arg1}
 * select * from employee where id = #{param1} and last_name=#{param2}
 *
 * 命名参数：明确指定封闭参数时map的key,@Param("id")
 *  多个参数会封装成一个map
 *  key:使用@Param注解指定的值
 *  value:为传入的值
 *  命名参数的写法如下，使用@Param注解
 * Employee selectByIdAndLastName(@Param("id") int id, @Param("lastName") String lastName);
 * select * from employee where id = #{id} and last_name=#{lastName}
 *
 * 封闭pojo
 * 如果为多个参数，封装pojo,可使用#{属性名}获取pojo的属性值
 * 封装map
 * 事果为多个参数，封装成map 可使用#{key}获取map对应key的值
 * 封装TO
 * 如果经常使用多个参数值查询，可封装一个TO(transfer object) 数据传输对象
 *
 * 3.集合类参数：如果Collection(list,set)类型或数组，mybatis也会做特殊处理
 *  会将传入的list或数组封装在map中
 *  key:为集合key为collection ，List的key为list，数组的key为 array
 *  value:为集合
 *  取出集合中的一个值 #{collection[0]}, #{list[0]} ,#{array[0]}
 *
 *
 *  -----------------
 *  sql 中的两中取值方式：
 *  #{} 获取值是预编译的方式，将参数设置到sql语句中 PreparedStatement,防sql注入 eg where id=?
 *  ${} 获取的值直接拼装到sql语句中 eg: where id=1
 *     原生jdbc不支持占位符的地方就可以使用${}进行取值
 *     比如分表，按年分折表
 *      select * from ${year}_salary where xxx;
 *      排序字段的获取 xxx order by ${createTime} ${order} ;//order= desc|asc
 *   #{} 的其他丰富的用法
 *
 *
 */