package com.example.Form;
import com.example.Course.Course;
import com.example.People.*;

import java.util.List;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Lob;
import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
@Entity
@Table
public class Artifact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String explanation;
	
	private Date date;
	
	private String status;
	
	@ManyToOne
	private People student;
	
	@ManyToOne
	private Group group;
	
	@ManyToOne
	private Course course;

	@ManyToOne
	private Assignment assignment;

	@Lob
	private byte[] file;
	public Artifact() {super();}
	public Artifact(String explanation,
			Date date,
			String status,
			Group group,
			Course course,
			Assignment assignment) {
		this.setDate(date);
		this.setStatus(status);
		this.setGroup(group);
		this.setCourse(course);
		this.setAssignment(assignment);
		this.setFile(null);
	}
	public Artifact(
			String explanation,
			Date date,
			String status,
			People student,
			Course course,
			Assignment assignment){
			this.setDate(date);
			this.setStatus(status);
			this.setStudent(student);
			this.setCourse(course);
			this.setAssignment(assignment);
			this.setFile(null);
		}
	public Artifact(
		String explanation,
		Date date,
		String status,
		People student,
		Group group,
		Course course,
		Assignment assignment){
		this.setDate(date);
		this.setStatus(status);
		this.setStudent(student);
		this.setGroup(group);
		this.setCourse(course);
		this.setAssignment(assignment);
		this.setFile(null);
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	
	public People getStudent() {
		return student;
	}

	public void setStudent(People student) {
		this.student = student;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}