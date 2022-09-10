package com.xyf.ssm.mapper;

import com.xyf.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program ：
 * @Author ：许逸帆
 * @Date ：2022/8/28 8:25
 */
public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    Integer addEmployee(Employee employee);

    void deleteEmployee(@Param("eid") Integer eid);

    Employee getEmployeeById(@Param("eid")Integer eid);

    void updateEmployee(Employee employee);
}
