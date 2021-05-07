package com.example.Form;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Column;
/*
 * A question of form
 * There are 3 types evaluation, multiple choice and comment question(at questionbase)
 * 
 */
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "question")
public class Question extends QuestionBase implements Serializable{
	
	// Associated questionform
	@ManyToOne
	private QuestionForm questionForm;
	
	//Associated answers
	@OneToMany(cascade = {CascadeType.ALL},orphanRemoval = true)
	@JoinColumn(name = "answer_id", referencedColumnName = "Id")
	private List<Answer> answers;
	
	// getters setters
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void addAnswer(Answer answer) {
		answer.setCorrespondingQuestion(this);
		this.getAnswers().add(answer);
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public QuestionForm getQuestionForm() {
		return questionForm;
	}

	public void setQuestionForm(QuestionForm questionForm) {
		this.questionForm = questionForm;
	}
	
}