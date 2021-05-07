package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface QuestionFormRepository extends CrudRepository<QuestionForm, Long> {
	List<QuestionForm> findByCourseIdOrderByDateDesc(Long courseId);
	QuestionForm findTopByOrderByIdDesc();
	List<QuestionForm> findByCourseIdOrderByDate(Long courseId);
}