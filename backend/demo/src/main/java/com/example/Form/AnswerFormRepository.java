package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AnswerFormRepository extends CrudRepository<AnswerForm, Long> {
	List<AnswerForm> findByStudentId(Long studentId);
	List<AnswerForm> findByArtifactId(Long artifactId);
	List<AnswerForm> findByStudentIdAndCourseId(Long studentId, Long courseId);
	List<AnswerForm> findByArtifactIdAndCourseId(Long artifactId, Long courseId);
}