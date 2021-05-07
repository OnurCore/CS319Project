package com.example.Form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "answer_form")
public class AnswerForm extends Formbase{
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "artifact_id")
	private Long artifactId;
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public Long getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(Long artifactId) {
		this.artifactId = artifactId;
	}
	
}