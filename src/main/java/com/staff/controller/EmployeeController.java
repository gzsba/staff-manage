package com.staff.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staff.dao.DepartmentDao;
import com.staff.dao.EmployeeDao;
import com.staff.pojo.Department;
import com.staff.pojo.Employee;
import com.staff.pojo.User;
import com.staff.service.impl.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
    	List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";//返回到添加员工页面
    }

    @PostMapping("/add")
    public String addEmp(Employee employee) {
        employeeDao.addEmployee(employee);//添加一个员工
        return "redirect:/emps";//重定向到/emps,刷新列表,返回到list页面
    }

    //restful风格接收参数
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        //查询指定id的员工,添加到empByID中,用于前端接收
        Employee employeeByID = employeeDao.getEmployeeByID(id);
        model.addAttribute("empByID", employeeByID);
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "/emp/edit";//返回到编辑员工页面
    }

    @PostMapping("/edit")
    public String editEmp(Employee employee) {
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployeeByID(id);
        return "redirect:/emps";
    }

}
