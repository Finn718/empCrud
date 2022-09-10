package com.xyf.ssm.service;

import com.github.pagehelper.PageInfo;
import com.xyf.ssm.pojo.Employee;

import java.util.List;

/**
 * @program ：
 * @Author ：许逸帆
 * @Date ：2022/8/23 11:00
 */
public interface EmployeeService {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);

    void addEmployee(Employee employee);

    void deleteEmployee(Integer eid);

    Employee getEmployeeById(Integer eid);

    void updateEmployee(Employee employee);
}
