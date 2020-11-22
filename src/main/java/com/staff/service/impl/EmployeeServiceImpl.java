package com.staff.service.impl;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.staff.dao.EmployeeDao;
import com.staff.pojo.Employee;
import com.staff.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeDao employeeDao;
	
	@Override
	@Cacheable(value="getAllEmployees")
	public Map<Integer, Employee> getAllEmployees() {
		Map<Integer, Employee> employees = (Map<Integer, Employee>) employeeDao.getAllEmployees();
        System.out.println(employees.size());
		return employees;
	}

	
}
