package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ArtifactRepository extends CrudRepository<Artifact, Long> {
	List<Artifact> findByCourseIdAndStudentIdOrderByDateDesc(Long courseId, Long studentId);
	Artifact findTopByStudentIdOrderByIdDesc(Long studentId);
	Artifact findTopByGroupIdOrderByIdDesc(Long groupId);
	List<Artifact> findByCourseIdAndGroupIdOrderByDateDesc(Long groupId, Long studentId);
}