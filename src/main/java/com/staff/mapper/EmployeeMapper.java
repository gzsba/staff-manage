package com.staff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.staff.pojo.Employee;

@Repository
public interface EmployeeMapper {

	List<Employee> getEmployees();
}
