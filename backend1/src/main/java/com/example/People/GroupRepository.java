package com.example.People;

import java.util.List;
import com.example.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

interface GroupRepository extends JpaRepository<Group, Long>{
	 List<Group> findByCourseOrderByName(Course course);
}
