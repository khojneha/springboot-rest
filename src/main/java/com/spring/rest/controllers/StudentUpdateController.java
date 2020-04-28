package com.spring.rest.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.bean.Student;
import com.spring.rest.bean.StudentRegistration;

@RestController
public class StudentUpdateController {


@RequestMapping(method = RequestMethod.PUT, value="/update/student")
	public String updateStudent(@RequestBody Student student){
		System.out.println("Inside update");
		return StudentRegistration.getInstance().upDateStudent(student);
	}
}
