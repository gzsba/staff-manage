package com.staff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.staff.pojo.User;
@Repository
public interface UserMapper {
	User Sel(int id);
	
	List<User> getUsers();
}
