package com.example.Form;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import com.example.People.*;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "question_form")
public class QuestionForm extends Formbase implements Serializable{
	
	@OneToMany(cascade = {CascadeType.ALL},orphanRemoval = true)
	@JoinColumn(name = "question_id")
	@JsonBackReference
	private List<Question> questions = new ArrayList<Question>();
	
	// Utility function
	public void addQuestion(Question question) {
		question.setQuestionForm(this);
		this.getQuestions().add(question);
	}
	
	// Getters setters
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}