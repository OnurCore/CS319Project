package com.example.Form;
import com.example.Course.Course;
import javax.persistence.ManyToOne;
import com.example.People.*;
import com.example.Grades.GradingCriteria;
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
import javax.persistence.JoinColumn;
import javax.persistence.Embedded;
import javax.persistence.CollectionTable;
@Entity
@Table(name = "Assignment")
public class Assignment {
	public enum AssignmentType{
		GroupAssignment,
		StudentAssignment
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String explanation;
	@ManyToOne
	private Course course;
	
	private Date date;
	
	private String status;
	@ElementCollection
	private List<String> comments;
	@OneToMany
	@JoinColumn(name = "artifact_id")
	private List<Artifact> artifacts;
	@Embedded
	@ElementCollection
	@CollectionTable(name="criterias", joinColumns=@JoinColumn(name="ID"))
	private List<GradingCriteria> criterias;
	
	private AssignmentType type;
	public AssignmentType getType() {
		return type;
	}
	public void setType(AssignmentType type) {
		this.type = type;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
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
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	public List<GradingCriteria> getCriterias() {
		return criterias;
	}
	public void setCriterias(List<GradingCriteria> criterias) {
		this.criterias = criterias;
	}

}