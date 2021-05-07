package com.example.Form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name = "Answer")
public class Answer extends QuestionBase{
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "answer_form_id")
	private Long answerFormId;
	
	@Column(name = "question_id")
	private Long questionId;
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	
	public Long getAnswerFormId() {
		return answerFormId;
	}

	public void setAnswerFormId(Long answerFormId) {
		this.answerFormId = answerFormId;
	}
	
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
}