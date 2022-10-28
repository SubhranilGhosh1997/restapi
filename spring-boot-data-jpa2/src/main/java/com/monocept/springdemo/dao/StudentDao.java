package com.monocept.springdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.springdemo.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
