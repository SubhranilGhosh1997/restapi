package com.monocept.springdemo.service;

import java.util.List;

import com.monocept.springdemo.entity.Student;
import com.monocept.springdemo.exceptions.EmailIsNotValidException;
import com.monocept.springdemo.exceptions.NoStudentException;
import com.monocept.springdemo.exceptions.StudentNotFoundException;

public interface StudentService  {
	
	

	List<Student> getStudents() throws NoStudentException;

	Student getStudentById(int studentId) throws StudentNotFoundException;

	Student addStudent(Student student) throws EmailIsNotValidException;

	void removeStudent(int studentId);
}
