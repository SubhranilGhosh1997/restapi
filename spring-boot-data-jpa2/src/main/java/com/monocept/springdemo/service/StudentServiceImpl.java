package com.monocept.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.springdemo.dao.StudentDao;
import com.monocept.springdemo.entity.Student;
import com.monocept.springdemo.exceptions.EmailIsNotValidException;
import com.monocept.springdemo.exceptions.NoStudentException;
import com.monocept.springdemo.exceptions.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<Student> getStudents() throws NoStudentException {
		List<Student> students = studentDao.findAll();
		if(students.isEmpty())
		{
			throw new NoStudentException();
		}
		else 
			return students;
	}

	@Override
	public Student getStudentById(int studentId) throws StudentNotFoundException {
		Optional<Student> students = studentDao.findById(studentId);
		if(!students.isPresent()) {
			throw new StudentNotFoundException(); 
		}
		return students.get();
	}

	@Override
	public Student addStudent(Student student) throws EmailIsNotValidException {
		if (student.getEmail().isEmpty()||student.getEmail().length()==0) {
			throw new EmailIsNotValidException();  
		}
		return studentDao.save(student);
	}

	@Override
	public void removeStudent(int studentId) {
		studentDao.deleteById(studentId);;
	}

}
