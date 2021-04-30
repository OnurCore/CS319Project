package com.example.Form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
@MappedSuperclass 
public class QuestionBase{
	enum QuestionType{
		Evaluation,
		MultipleChoice,
		Comment
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private QuestionType type;
	
	private String name;
	
	private String question;
	
	private Long orderInForm;
	
	private Long maxEval;
	@Lob
	private String[] multiplechoices;
	
	private Long courseId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType name) {
		this.type = type;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String name) {
		this.question = name;
	}
	
	public Long getOrderInForm() {
		return orderInForm;
	}

	
	public void setOrderInForm(Long order) {
		this.orderInForm = order;
	}
	

	public Long getMaxEvaluation() {
		return maxEval;
	}

	public void setMaxEvaluation(Long maxEval) {
		this.maxEval = maxEval;
	}
	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
}