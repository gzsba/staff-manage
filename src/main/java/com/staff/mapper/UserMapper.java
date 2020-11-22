package com.staff.mapper;

import org.springframework.stereotype.Repository;

import com.staff.pojo.User;
@Repository
public interface UserMapper {
	User Sel(int id);
}
