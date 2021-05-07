package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.Course.Course;
import com.example.People.People;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AnswerFormRepository extends CrudRepository<AnswerForm, Long> {
	
	// Answerform of student
	List<AnswerForm> findByStudent(People studentId);
	
	// Find answerform associated to artifact
	List<AnswerForm> findByArtifact(Artifact artifactId);
	
	List<AnswerForm> findByStudentAndCourse(People studentId, Course course);
	List<AnswerForm> findByArtifactAndCourse(Artifact artifact, Course course);
	
	// Get last uploaded answerform
	AnswerForm findTopByOrderByIdDesc();
}