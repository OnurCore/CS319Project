package com.example.Course;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import com.example.People.People;
import com.example.People.People.PeopleType;
import com.example.Calendar.CourseCalendar;
import com.example.People.Group;
import java.util.List;
import javax.persistence.Entity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.People.GroupPeopleUnion;
import java.io.Serializable;

/*
 * 
 * 
 * 
 * 
 * */
 
@Entity
@Table
public class Course implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "course")
	@JsonBackReference(value = "with_groups") // To prevent recursion
	private List<Group> groups;
	
	@ManyToMany(mappedBy = "allCourses")
	@JsonBackReference(value = "with_people") // To prevent recursion
	private List<People> people;
	
	@JsonIgnore // Not needed to serialize
	public List<People> getUnassignedStudents(){
		List<People> newPeopleList = new ArrayList<People>();
		
		// newPeopleList are student members of the course
		for(People p: people) {
			if(p.getPeople() == PeopleType.Student) {
				newPeopleList.add(p);
			}
		}
		
		// remove if student have group
		for(Group group : groups) {
			for(People p : group.getAllPeople()) {
				newPeopleList.remove(p);
			}
		}
		
		if(newPeopleList.isEmpty()) {
			return null;
		}else {
			return newPeopleList;
		}
	}
	
	//getters and setters
	
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