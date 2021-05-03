package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.example.People.*;
import com.example.Course.Course;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ArtifactRepository extends CrudRepository<Artifact, Long> {
	
	List<Artifact> findByCourseAndStudentOrderByDateDesc(Course courseId,People studentId);
	Artifact findTopByStudentOrderByIdDesc(People studentId);
	Artifact findTopByGroupOrderByIdDesc(Group groupId);
	List<Artifact> findByAssignmentAndGroupOrderByDateDesc(Assignment assignmentId, People studentId);
}