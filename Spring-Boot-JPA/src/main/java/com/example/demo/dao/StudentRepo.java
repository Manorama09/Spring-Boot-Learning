package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	List<Student> findByTech(String tech); 
	List<Student> findBySidGreaterThan(int sid); 
	
	//List of students under a particular tech, ordered alphabetically
	@Query("from Student where tech=?1 order by name")
	List<Student> findByTechSorted(String tech);
	
}
