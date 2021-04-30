package com.example.Form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class AssignmentReviewController {
	
	private final AnswerFormRepository answerFormRepo;
	
	private final AnswerRepository answerRepo;
	
	private final QuestionFormRepository questionFormRepo;
	
	private final QuestionRepository questionRepo;
	
	private final AssignmentRepository assignmentRepository;
	
	private final ArtifactRepository artifactRepository;
	public AssignmentReviewController(AnswerFormRepository answerFormRepo,
			AnswerRepository answerRepo,
			QuestionFormRepository questionFormRepo,
			QuestionRepository questionRepo,
			AssignmentRepository assignmentRepository,
			ArtifactRepository artifactRepository) {
		this.answerFormRepo = answerFormRepo;
		this.answerRepo = answerRepo;
		this.questionFormRepo = questionFormRepo;
		this.questionRepo = questionRepo;
		this.assignmentRepository = assignmentRepository;
		this.artifactRepository = artifactRepository;
	}
	
	@GetMapping("/AnswerForms")
	public List<AnswerForm> getAnswerForms(@RequestParam Long studentId, @RequestParam Long courseId) {
		return answerFormRepo.findByStudentIdAndCourseId(studentId, courseId);
	}
	@GetMapping("/AnswerFormQuestions")
	public List<Answer> getAnswers(@RequestParam Long answerFormId) {
		return answerRepo.findByAnswerFormIdOrderByOrderInForm(answerFormId);
	}
	@GetMapping("/QuestionForms")
	public List<QuestionForm> getQuestionForms(@RequestParam Long courseId) {
		return questionFormRepo.findByCourseIdOrderByDate(courseId);
	}
	@GetMapping("/QuestionFormQuestions")
	public List<Question> getQuestions(@RequestParam Long questionFormId) {
		return questionRepo.findByQuestionFormIdOrderByOrderInForm(questionFormId);
	}
	
	@PostMapping("/CreateQuestionForm")
	public void createQuestionForm(@RequestBody QuestionFormWithQuestions formWithQuestions) {
		QuestionForm questionForm = formWithQuestions.getQuestionForm();
		Long courseId = questionForm.getCourseId();
		Long lastId = questionFormRepo.findTopByOrderByIdDesc().getId();
		lastId++;
		questionForm.setId(lastId);
		questionFormRepo.save(questionForm);
		ArrayList<Question> questions = formWithQuestions.getQuestions();
		Long questionLastId = questionRepo.findTopByOrderByIdDesc().getId();
		for(int i = 0;i  < questions.size();i++) {
			questionLastId++;
			Question question = questions.get(i);
			question.setOrderInForm(new Long(i + 1));
			question.setQuestionFormId(lastId);
			question.setId(questionLastId);
			questionRepo.save(question);
		}
		
	}
	@PutMapping("/UpdateAnswerForm")
	public void updateAnswerForm(@RequestBody Answer answer) {
		answerRepo.save(answer);
	}
}