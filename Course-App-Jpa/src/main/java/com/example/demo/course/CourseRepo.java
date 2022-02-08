package com.example.demo.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// CrudRepository <Entity, Id>
public interface CourseRepo extends CrudRepository<Course, String>{
	
	// all courses that have a specific name - findBy{Property} - camelcase
	public List<Course> findByName(String name);
	
	// use topic id since Topic is a user defined class
	public List<Course> findByTopicId(String topicId);
	
}
