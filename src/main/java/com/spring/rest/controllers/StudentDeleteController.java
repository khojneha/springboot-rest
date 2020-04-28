package com.spring.rest.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.bean.StudentRegistration;

@RestController
public class StudentDeleteController {

	@RequestMapping( method=RequestMethod.DELETE, value="/delete/student/{registrationnumber}")
	 public String deleteStudentRecord(@PathVariable("registrationnumber") String regdNum) {
		System.out.println("In deleteStudentRecord");   
	    return StudentRegistration.getInstance().deleteStudent(regdNum);
		}
}
