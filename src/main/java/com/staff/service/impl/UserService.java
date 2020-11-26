package com.staff.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.mapper.UserMapper;
import com.staff.pojo.User;

@Service
public class UserService {
	@Autowired
    UserMapper userMapper;
    public User Sel(int id){
        return userMapper.Sel(id);
    }
    
    public List<User> getUsers(){
    	List<User> users = userMapper.getUsers();
    	return users;
    }
}
