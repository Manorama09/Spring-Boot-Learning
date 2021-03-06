package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	// POST - Adding a student record
	@PostMapping(path="/students", consumes = {"application/json"})
	public Student addStudent(@RequestBody Student student) {
		repo.save(student);
		return student;
	}
	
	// GET - Getting a list of all students
	@RequestMapping(path="/students")
	@ResponseBody
	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	// GET - Get details of a particular student
	@GetMapping("/students/{sid}")
	@ResponseBody
	public Optional<Student> getStudent(@PathVariable("sid") int sid ) {
		return repo.findById(sid);
	}
	
	// DELETE - Delete a particular student's record
	@DeleteMapping("/students/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		Student s = repo.getById(sid);
		repo.delete(s);
		return "Record Deleted";
	}
	
	// UPDATE - Update a particular student's record
	@PutMapping(path="/students/{sid}", consumes= {"application/json"})
	public Student saveOrUpdateStudent(@RequestBody Student student) {
		repo.save(student);
		return student;
	}
}
//@RequestMapping("/")
//public String home(){
//	return("home.jsp");
//}

//Using Model and View to Get student details
//@RequestMapping("/getStudent")
//public ModelAndView getStudent(@RequestParam int sid) {
//	ModelAndView mv = new ModelAndView("showStudent.jsp");
//	Student student =  repo.findById(sid).orElse(new Student());
//	
//	System.out.println(repo.findByTech("Java"));
//	System.out.println(repo.findBySidGreaterThan(101));
//	System.out.println(repo.findByTechSorted("Java"));
//	mv.addObject(student);
//	return mv;
//}