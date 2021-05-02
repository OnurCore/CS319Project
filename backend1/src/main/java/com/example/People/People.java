package com.example.People;

import com.example.Course.Course;

import java.util.List;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
@Entity
@Table
public class People{
	public enum PeopleType{
		Administrator,
		Instructor,
		Student
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String people_name;
	
	private String contactInfo;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "courseID_peopleID",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "Id"),
	inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "Id"))
	private List<Course> allCourses;
	
	private PeopleType people;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getName() {
		return people_name;
	}

	public void setName(String people_name) {
		this.people_name = people_name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Course> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(List<Course> allCourses) {
		this.allCourses = allCourses;
	}

	public PeopleType getPeople() {
		return people;
	}

	public void setPeople(PeopleType people) {
		this.people = people;
	}
}