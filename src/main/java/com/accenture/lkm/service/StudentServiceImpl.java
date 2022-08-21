package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.Student;
import com.accenture.lkm.dao.StudentDAO;
import com.accenture.lkm.entity.StudentEntity;
@Service
public class StudentServiceImpl {

	@Autowired
	private StudentDAO studentDAO;

	public int addStudent(Student student) {

		StudentEntity studentEntity = new StudentEntity();
		BeanUtils.copyProperties(student, studentEntity);
		StudentEntity studentEntity2= studentDAO.save(studentEntity);
		return studentEntity2.getStudentId();
	}

	public Collection<Student> getStudentDetails(){
		Collection<StudentEntity> collec =studentDAO.findAll();	
		List<Student> listStudent = new ArrayList<Student> ();
		for (StudentEntity studentEntity : collec) {
			Student student=new Student();
			BeanUtils.copyProperties(studentEntity, student);
			listStudent.add(student);
		}
		return listStudent;
	}
	
	public Student getStudentDetailByStudentId(int studentId){
		Student student =null;
		StudentEntity studentEntity= studentDAO.findOne(studentId);
		if(studentEntity!=null){
			student= new Student();
			BeanUtils.copyProperties(studentEntity, student);
		}
		return student;
	}
	
	public Student deleteStudent(int studentId){
		Student student =null;
		StudentEntity studentEntity= studentDAO.findOne(studentId);
		if(studentEntity!=null){
			studentDAO.delete(studentEntity);
			student= new Student();
			BeanUtils.copyProperties(studentEntity, student);
		}
		return student;
	}
	
	public Student updateStudent(Student student){
		Student student2 =null;
		StudentEntity studentEntity= studentDAO.findOne(student.getStudentId());
		if(studentEntity!=null){
			BeanUtils.copyProperties(student, studentEntity);
			studentDAO.save(studentEntity);
			student2= new Student();
			BeanUtils.copyProperties(studentEntity, student2);
		}
		return student2;
	}
}
