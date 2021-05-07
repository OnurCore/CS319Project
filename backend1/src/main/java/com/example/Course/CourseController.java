package com.example.Form;

import com.example.Course.*;
import com.example.Course.CourseNotFoundException;
import com.example.People.People;
import com.example.People.People.PeopleType;
import com.example.People.PeopleRepository;
import java.util.ArrayList;
import java.util.List;
import com.example.Course.Course;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
@RestController
public class CourseController {
	private final CourseRepository courseRepository;
	CourseController(CourseRepository courseRepository){
		this.courseRepository = courseRepository;
	}
	// Gets all courses
	@GetMapping("/allCourses/{id}")
	public List<Course> getCourses(@PathVariable People id){
		return courseRepository.findByPeopleOrderByName(id);
	}
	@GetMapping("/getCourses")
	public List<Course> getCourses() {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(courses :: add);
		return courses;
	}
	// Get information of one course
	@GetMapping("/getCourse/{id}")
	public Course getCourse(@PathVariable Long id) {
		return courseRepository.findById(id)
				.orElseThrow(() -> new CourseNotFoundException(id));
	}
	@GetMapping("/MembersofCourse/{course}")
	public List<People> getMembersOfCourse(@PathVariable Course course){
		return course.getPeople();
	}
	
	
	// Create Course by information coming from frontend
	@PostMapping("/createCourse")
	public void createCourse(@RequestBody Course course) {
		courseRepository.save(course);
	}
	
	//Delete Course
	@DeleteMapping("/deleteCourse/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseRepository.deleteById(id);
	}
	
}