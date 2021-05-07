package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
	List<Assignment> findByCourseIdOrderByDateDesc(Long courseId);
	QuestionForm findTopByOrderByIdDesc();
	List<Assignment> findByCourseIdOrderByDate(Long courseId);
}