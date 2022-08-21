package com.accenture.lkm.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.Student;
import com.accenture.lkm.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@RequestMapping(value="student/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Student>> getStudentDetails(){
		Collection<Student> listStudent = studentService.getStudentDetails();
		return new ResponseEntity<Collection<Student>>(listStudent, HttpStatus.OK);
	}
	
	@RequestMapping(value="student/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudentDetailByStudentId(@PathVariable("id") int myId){
		Student student = studentService.getStudentDetailByStudentId(myId);
		if(student!=null){
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/student/controller/addStudent",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		int id= studentService.addStudent(student);
		return new ResponseEntity<String>("Student added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/student/controller/updateStudent",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		Student student2= studentService.updateStudent(student);
		if(student2==null){
			return new ResponseEntity<Student>(student2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Student>(student2,HttpStatus.OK);
	}
	@RequestMapping(value="/student/controller/deleteStudent/{id}",
			method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int myId){
		Student student= studentService.deleteStudent(myId);
		if(student==null){
			return new ResponseEntity<Student>(student,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
