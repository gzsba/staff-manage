package com.staff.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.staff.mapper.EmployeeMapper;
import com.staff.pojo.Employee;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeMapper employeeMapper;

	@Cacheable(value="getAllEmployees")
	public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeMapper.getEmployees();
		return employees;
	}
}
