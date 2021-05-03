package com.example.People;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.ManyToMany;
import com.example.Calendar.GroupCalendar;
import com.example.Calendar.Task;
import com.example.Grades.Grade;
import com.example.Course.Course;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
@Entity
@Table(name = "group_table")
public class Group implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	private Integer groupNo;
	
	@ManyToOne
	private Course course;
	
	@ManyToMany(mappedBy = "allGroups")
	private List<People> allPeople = new ArrayList<People>();
	
	
	// getters setters
	
	public List<People> getAllPeople() {
		
		return allPeople;
	}

	public void setAllPeople(List<People> allPeople) {
		this.allPeople = allPeople;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

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

	public Integer getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}

	/*public Grade getGroupGrade() {
		return groupGrade;
	}

	public void setGroupGrade(Grade groupGrade) {
		this.groupGrade = groupGrade;
	}

	public People[] getAllPeople() {
		return allPeople;
	}

	public void setAllPeople(People[] allPeople) {
		this.allPeople = allPeople;
	}*/

	/*public List<Task> getGroupTasks() {
		return groupTasks;
	}

	public void setGroupTasks(List<Task> groupTasks) {
		this.groupTasks = groupTasks;
	}*/

	/*public GroupCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(GroupCalendar calendar) {
		this.calendar = calendar;
	}*/
	
}