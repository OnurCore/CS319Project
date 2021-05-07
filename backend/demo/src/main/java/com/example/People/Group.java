package com.example.People;

import com.example.Calendar.GroupCalendar;
import com.example.Calendar.Task;
import com.example.Grades.Grade;
import com.example.Course.Course;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
@Entity
public class Group{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Integer groupNo;
	
	//private Grade groupGrade;
	
	//private People[] allPeople;
	@OneToMany
	private List<Task> groupTasks;
	//@OneToOne
	//private GroupCalendar calendar;
	@ManyToOne
	private Course course;
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

	public List<Task> getGroupTasks() {
		return groupTasks;
	}

	public void setGroupTasks(List<Task> groupTasks) {
		this.groupTasks = groupTasks;
	}

	/*public GroupCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(GroupCalendar calendar) {
		this.calendar = calendar;
	}*/
	
}