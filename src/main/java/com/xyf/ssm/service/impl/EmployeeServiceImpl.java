package com.xyf.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyf.ssm.mapper.EmployeeMapper;
import com.xyf.ssm.pojo.Employee;
import com.xyf.ssm.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program ：
 * @Author ：许逸帆
 * @Date ：2022/8/23 11:01
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,20);
        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list, 3);
        return page;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer eid) {
        employeeMapper.deleteEmployee(eid);
    }

    @Override
    public Employee getEmployeeById(Integer eid) {
        Employee employee = employeeMapper.getEmployeeById(eid);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }


}
