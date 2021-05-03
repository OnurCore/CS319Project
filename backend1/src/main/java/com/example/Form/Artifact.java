package com.example.Form;
import com.example.Grades.*;
import java.io.Serializable;
import javax.persistence.OneToMany;
import com.example.Course.Course;
import com.example.People.*;

import java.util.List;
import java.util.ArrayList;
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
/*
 * Artifact objects are generated for every student(or group, depends on type of homework)
 * after assignment have been created by the instructor. 
 * Artifacts can be thought as mirrors of assignment for students
 * All uploaded files by students are instances of artifacts
 */
@Entity
@Table
public class Artifact implements Serializable{
	public enum ArtifactStatus{
		NotSubmitted,
		Submitted,
		Graded
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// Explanation of homework
	private String explanation;
	
	private Date date;
	
	// Changes if submitted by student and if graded by instructor
	private ArtifactStatus status;
	
	// Grades are database entities due to make displaying statistics in GradeBook easier 
	@OneToMany
	private List<Grade> grades;
	
	// Empty if group artifact
	@ManyToOne
	private People student;
	
	@ManyToOne
	private Group group; // Empty if student assignment
	
	@ManyToOne
	private Course course;

	@ManyToOne
	private Assignment assignment;

	@Lob
	private byte[] file; // long blob file
	public Artifact() {super();}
	
	// Construct without student
	public Artifact(String explanation,
			Date date,
			ArtifactStatus status,
			Group group,
			Course course,
			Assignment assignment) {
		this.setDate(date);
		this.setStatus(status);
		this.setGroup(group);
		this.setCourse(course);
		this.setAssignment(assignment);
		this.setFile(null);
		
		List<Grade> grades = new ArrayList<Grade>();
		for(GradingCriteria crit : assignment.getCriterias()) {
			grades.add(new Grade(crit));
		}
		this.setGrades(grades);
	}
	
	// Construct without group
	public Artifact(
			String explanation,
			Date date,
			ArtifactStatus status,
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
	
	// Construct both with group and student
	public Artifact(
		String explanation,
		Date date,
		ArtifactStatus status,
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
	
	// sum of grades of criterias
	public Integer getOverAllGrade() {
		Integer sum = 0;
		for(Grade grade: this.getGrades()) {
			sum += grade.getGrade();
		}
		return sum;
	}
	
	// The value of Assignment in overall grade
	public Integer getOverAllMaxGrade() {
		Integer sum = 0;
		for(Grade grade: this.getGrades()) {
			sum += grade.getCriteria().getMaximum();
		}
		return sum;
	} 
	
	// getters and setters
	
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

	public ArtifactStatus getStatus() {
		return status;
	}

	public void setStatus(ArtifactStatus status) {
		this.status = status;
	}
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}