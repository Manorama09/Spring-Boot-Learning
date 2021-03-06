package com.example.demo.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//A business service - singleton
@Service
public class CourseService {
	
	@Autowired
	private CourseRepo repo;
	
	// GET - All Courses		
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		repo.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	// GET - A particular Course's details
	public Optional<Course> getCourse(String courseId) {
		return repo.findById(courseId);
	}
	
	// POST - Add a new Course
	public void addCourse(Course course) {
		repo.save(course);
	}
	
	// PUT - Update an existing Course - given id
	public void updateCourse(Course course) {
		repo.save(course);
	}
	
	// DELETE - Remove an existing Course - given id
	public void deleteCourse(String courseId) {
		repo.deleteById(courseId);
	}
}
