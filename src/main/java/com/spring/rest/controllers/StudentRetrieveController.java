package com.spring.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.bean.Student;
import com.spring.rest.bean.StudentRegistration;

@RestController
public class StudentRetrieveController {
	@RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	  public List<Student> getAllStudents() {
	  return StudentRegistration.getInstance().getStudentRecords();
	  }


}
