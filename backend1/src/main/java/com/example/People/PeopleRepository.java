package com.example.People;

import java.util.List;
import com.example.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.People.People;
public interface PeopleRepository extends JpaRepository<People, Long>{
	List<People> findByAllCoursesAndPeople(Course course, People.PeopleType type);
	List<People> findByName(String name);
	
}