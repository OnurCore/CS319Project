package com.example.People;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class People{
	public enum PeopleType{
		Administrator,
		Instructor,
		Student
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long peopleId;
	
	private String name;
	
	private String contactInfo;
	
	private Long[] courseId;
	
	private PeopleType people;
	
	public Long getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Long[] getCourseId() {
		return courseId;
	}

	public void setCourseId(Long[] courseId) {
		this.courseId = courseId;
	}

	public PeopleType getPeople() {
		return people;
	}

	public void setPeople(PeopleType people) {
		this.people = people;
	}
}