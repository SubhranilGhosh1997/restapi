package com.monocept.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.springdemo.entity.Student;
import com.monocept.springdemo.exceptions.EmailIsNotValidException;
import com.monocept.springdemo.exceptions.NoStudentException;
import com.monocept.springdemo.exceptions.StudentNotFoundException;
import com.monocept.springdemo.service.StudentService;

@RestController
@RequestMapping("/app")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<?> getStudents() {
		try {
			return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
		} catch (NoStudentException e) {
			return new ResponseEntity<String>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<?> getStudentById(@PathVariable int studentId) {
		try {
			return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			return new ResponseEntity<StudentNotFoundException>(e, HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("/students")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		student.setId(0);
		try {
			return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
		} catch (EmailIsNotValidException e) {
			return new ResponseEntity<String>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {
		try {
			return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
		} catch (EmailIsNotValidException e) {
			return new ResponseEntity<String>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<Void> removeStudent(@PathVariable int studentId) {
		studentService.removeStudent(studentId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
