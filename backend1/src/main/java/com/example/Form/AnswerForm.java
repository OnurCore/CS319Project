package com.example.Form;
import javax.persistence.CascadeType;
import com.example.People.*;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "answer_form")
public class AnswerForm extends Formbase{
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "Id")
	private People student;
	
	@OneToOne
	private Artifact artifact;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "artifact_id", referencedColumnName = "Id")
	private List<Answer> answer;
	public AnswerForm() {super();}
	public AnswerForm(QuestionForm questionForm, People student, Artifact artifact) {
		this.setName(questionForm.getName());
		this.setType(questionForm.getType());
		this.setCourse(questionForm.getCourse());
		this.setDate(questionForm.getDate());
		this.setStudent(student);
		this.setArtifact(artifact);
		List<Question> questions = questionForm.getQuestions();
		List<Answer> answers = new ArrayList<Answer>();
		for(int i = 0;i < questions.size();i++) {
			//lastIndexForAnswer++;
			Answer answer = new Answer(student, null, questions.get(i));//problematic
			answers.add(answer);
		}
		this.answer = answers;
	}
	public static AnswerForm correctedAnswerForm(AnswerForm answerForm) {
		for (Answer answer : answerForm.getAnswer()) {
			answer.setAnswerForm(answerForm);
		}
		return answerForm;
	}
	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public People getStudent() {
		return student;
	}

	public void setStudent(People student) {
		this.student = student;
	}
	
	public Artifact getArtifact() {
		return artifact;
	}

	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}
	
}