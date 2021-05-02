package com.example.Course;
import javax.persistence.ManyToMany;
import com.example.People.People;
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
	@ManyToMany(mappedBy = "allCourses")
	private List<People> people;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public List<People> getPeople() {
		return people;
	}
	public void setPeople(List<People> people) {
		this.people = people;
	}
	//private CourseCalendar courseCalendar;
	
}