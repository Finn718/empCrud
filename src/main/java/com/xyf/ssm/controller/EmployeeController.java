package com.xyf.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xyf.ssm.pojo.Employee;
import com.xyf.ssm.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program ：
 * 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1
 * 根据id查询员工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->employee-->post
 * 修改员工信息-->employee-->put
 * 删除员工信息-->/employee/1-->delete
 * @Author ：许逸帆
 * @Date ：2022/8/23 10:30
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/1";
    }


    /**
     * 根据id查询员工信息并跳转修改页面
     * @param eid
     * @param model
     * @return
     */
    @RequestMapping(value="/employeeUpdate/{eid}",method = RequestMethod.GET)
    public String getEmployeeByIdAndToUpdate(@PathVariable("eid") Integer eid,Model model){
        Employee employee = employeeService.getEmployeeById(eid);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    /**
     * 删除员工信息
     * @param eid
     * @return
     */
    @RequestMapping(value = "/employeeDelete/{eid}",method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("eid") Integer eid){
        employeeService.deleteEmployee(eid);
        return "redirect:/employee/page/1";
    }

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employee/page/1";
    }


    /**
     * 分页显示所有员工信息
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/page/{pageNum}" , method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //将分页数据共享在请求域中
        model.addAttribute("page",page);
        //跳转到employee_list.html
        return "employee_list";
    }

    /**
     * 查询所有员工信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list",list);
        //跳转到employee_list.html
        return "employee_list";
    }

}
