package com.example.Form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "question")
public class Question extends QuestionBase{
	//@Column(name = "question_form_id")
	private Long questionFormId;
	
	public Long getQuestionFormId() {
		return questionFormId;
	}

	public void setQuestionFormId(Long questionFormId) {
		this.questionFormId = questionFormId;
	}
	
}