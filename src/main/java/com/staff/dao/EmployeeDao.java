package com.staff.dao;

import com.staff.pojo.Department;
import com.staff.pojo.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Repository
public class EmployeeDao {

	// 自增主键
	private static Integer initialID = 0;
	private static Map<Integer, Employee> employees = null;
	@Autowired
	private DepartmentDao departmentDao;

	static {
		employees = new HashMap<Integer, Employee>();
		for (int i = 1; i <= 10; i++) {
			// 也可用雪花算法
			String id = UUID.randomUUID().toString();
			switch (i % 5) {
			case 1:
				employees.put(i, new Employee(i, "gzsba" + i, i + "lovelive@qq.com", 1, new Department(1, "技术部"),
						new Date(), (byte) 1));
				break;
			case 2:
				employees.put(i, new Employee(i, "gzsba" + i, i + "lovelive@qq.com", 1, new Department(2, "市场部"),
						new Date(), (byte) 1));
				break;
			case 3:
				employees.put(i, new Employee(i, "gzsba" + i, i + "lovelive@qq.com", 1, new Department(3, "调研部"),
						new Date(), (byte) 1));
				break;
			case 4:
				employees.put(i, new Employee(i, "gzsba" + i, i + "lovelive@qq.com", 1, new Department(4, "后勤部"),
						new Date(), (byte) 1));
				break;
			case 0:
				employees.put(i, new Employee(i, "gzsba" + i, i + "lovelive@qq.com", 1, new Department(5, "运营部"),
						new Date(), (byte) 1));
				break;
			}
		}
	}

	//判断id是否已存在,并返回一个最新的id。该获取id的方式不可取，纯属娱乐
	public Integer getId() {
		Set<Integer> ids= employees.keySet();
		boolean flag = ids.contains(initialID);
		if(flag) {
			initialID = initialID + 1;
			getId();
		}
		return initialID;
	}
	// 新增员工
	public void addEmployee(Employee employee) {
		if (employee.getId() == null) {
			initialID = getId();
			employee.setId(initialID);
			initialID = initialID + 1;
		}
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
		System.out.println("员工总数是"+employees.size()+"时间是"+new Date());
		System.out.println(new Date());
	}

	// 查询全部员工(包括已失效的员工）
	public Map<Integer, Employee> getAllEmployees() {
		System.out.println("员工总数是"+employees.size());
		return employees;
	}

	// 通过id查询员工
	public Employee getEmployeeById(int id) {
		return employees.get(id);
	}

	// 通过id删除员工（软删除）
	public void unableEmployeeById(int id) {
		Employee employee = employees.get(id);
		employee.setState((byte) 0);
	}

	public Employee getEmployeeByID(Integer id) {
		Employee employee = employees.get(id);
		return employee;
	}

	// 通过id删除员工
	public void deleteEmployeeByID(Integer id) {
		employees.remove(id);
	}

}
