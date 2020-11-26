package com.staff.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{

	//private static final long serialVersionUID = 1L;
	private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0:女 1:男
    private Department department;
    private Date date;
    private Byte state;//0失效；1有效

}
