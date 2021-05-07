package com.example.Course;

import com.example.Calendar.CourseCalendar;
import com.example.People.Group;
import java.util.List;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
@Entity
@Table
public class Course{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	@OneToMany(mappedBy = "course")
	private List<Group> groups;
	
	//private CourseCalendar courseCalendar;
	
}