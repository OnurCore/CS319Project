package com.example.Form;

import com.example.People.*;
import java.io.Serializable;

import java.util.List;
import java.lang.Override;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "Answer")
public class Answer extends QuestionBase implements Serializable{
	// student which answerform is assigned
	@ManyToOne
	private People student;
	
	// Answerform which this answer is assigned
	@ManyToOne
	private AnswerForm answerForm;
	
	// question to be answered
	@ManyToOne
	private Question correspondingQuestion;
	
	// Default constructor
	public Answer() {super();}
	
	// Construct with student answerform and question
	public Answer(People student,AnswerForm answerForm, Question question) {
		
		this.setStudent(student);
		this.setAnswerForm(answerForm);
		
		this.setType(question.getType());
		this.setName(question.getName());
		this.setQuestion(getQuestion());
		this.setOrderInForm(question.getOrderInForm());
		this.setMaxEvaluation(getMaxEvaluation());
		this.setCourse(question.getCourse());
		
		this.setCorrespondingQuestion(question);
	}
	
	// getters and setters
	
	public People getStudent() {
		return student;
	}

	public void setStudent(People student) {
		this.student = student;
	}
	
	
	public AnswerForm getAnswerForm() {
		return answerForm;
	}

	public void setAnswerForm(AnswerForm answerForm) {
		this.answerForm = answerForm;
	}
	
	public Question getCorrespondingQuestion() {
		return correspondingQuestion;
	}

	public void setCorrespondingQuestion(Question question) {
		this.correspondingQuestion = question;
	}
}