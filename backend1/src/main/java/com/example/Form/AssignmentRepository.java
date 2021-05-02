package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.example.Course.Course;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
	List<Assignment> findByCourseOrderByDateDesc(Course id);
	QuestionForm findTopByOrderByIdDesc();
	//@Query("SELECT a FROM Assignment a WHERE a.course = ?1")
	List<Assignment> findByCourseOrderByDate(Course course);
	//Assignment findById(Assignment id);
}