package com.example.Grades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Embedded;
@Entity
@Table
public class Grade{
	public enum GradeType{
		ArtifactGrade,
		PeerGrade
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer grade;
	
	private String comment;
	
	// Associated criteria
	@Embedded
	private GradingCriteria criteria;

	private GradeType type;
	
	// Default constructor
	public Grade() {super();}
	
	// construct with criteria
	public Grade(GradingCriteria crit) {
		this.setCriteria(crit);
	}
	
	// getters setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GradeType getType() {
		return type;
	}

	public void setType(GradeType type) {
		this.type = type;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public GradingCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(GradingCriteria criteria) {
		this.criteria = criteria;
	}
	
	
}