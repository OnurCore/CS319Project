package com.example.People;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.People.People;
public interface PeopleRepository extends JpaRepository<People, Long>{
	//List<People> findByCourseAndPeopletype(Long course, People.PeopleType type);
	
}