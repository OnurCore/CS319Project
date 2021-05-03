package com.example.Form;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import com.example.Course.Course;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.ManyToOne;
/*
 * Super class of Answerform and questionform
 * 
 */

@MappedSuperclass // This tells Hibernate to make a table out of this class
public class Formbase {
	enum FormType{
		GroupReview,
		ArtifactReview
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@JsonProperty("id")
	private Long id;
	
	private String name;

	private FormType type;
	
	@ManyToOne
	private Course course;
	
	private Date date;
	
	// getters setters
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
	
	public FormType getType() {
		return type;
	}

	public void setType(FormType name) {
		this.type = type;
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
	
}