package com.example.People;
import java.io.Serializable;
import com.example.Course.Course;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
public class People implements Serializable{
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
	
	// Many to many for course
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "courseID_peopleID",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "Id"),
	inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "Id"))
	private List<Course> allCourses = new ArrayList<Course>();
	
	// MAny to many for group
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "groupID_and_peopleID",
			joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "Id"),
	inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "Id"))
	private List<Group> allGroups = new ArrayList<Group>();
	private PeopleType people;
	
	// Old design
	/*@OneToMany(
	        mappedBy = "people",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<GroupPeopleUnion> allGroups = new ArrayList<GroupPeopleUnion>();*/
	
	// Utility functions
	public void addGroup(Group group) {
		allGroups.add(group);
		group.getAllPeople().add(this);
	}
	public void removeGroup(Group group) {
		group.getAllPeople().remove(this);
		allGroups.remove(group);
	}
	
	// getter setters
	
	public String getPeople_name() {
		return people_name;
	}
	
	public void setPeople_name(String people_name) {
		this.people_name = people_name;
	}

	public List<Group> getAllGroups() {
		return allGroups;
	}

	public void setAllGroups(List<Group> allGroups) {
		this.allGroups = allGroups;
	}

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