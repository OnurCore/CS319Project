package com.example.Form;

import com.example.Grades.Grade;
import com.example.Course.Course;
import com.example.Form.Artifact.ArtifactStatus;

import com.example.Form.AssignmentEnum;
import com.example.People.*;
import com.example.People.People.PeopleType;
import com.example.People.PeopleRepository;
import java.util.ArrayList;
import java.util.List;
import com.example.Course.Course;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class AssignmentReviewController {
	
	private final AnswerFormRepository answerFormRepo;
	
	private final AnswerRepository answerRepo;
	
	private final QuestionFormRepository questionFormRepo;
	
	private final QuestionRepository questionRepo;
	
	private final AssignmentRepository assignmentRepository;
	
	private final ArtifactRepository artifactRepository;
	
	//private final PeopleRepository peopleRepo;
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
		//this.peopleRepo = peopleRepo;
	}
	List<People> getStudentsFromPeople(List<People> allPeople){
		List<People> students = new ArrayList<People>();
		for(int index = 0;index < allPeople.size();index++) {
			if(allPeople.get(index).getPeople() == People.PeopleType.Student) {
				students.add(allPeople.get(index));
			}
		}
		return students;
	}
	@GetMapping("/{courseId}/{studentId}/AnswerForms")
	public List<AnswerForm> getAnswerForms(@PathVariable People studentId, @PathVariable Course courseId) {
		return answerFormRepo.findByStudentAndCourse(studentId, courseId);
	}
	@GetMapping("/{id}/{AnswerFormQuestions")
	public List<Answer> getAnswers(@PathVariable AnswerForm id) {
		return answerRepo.findByAnswerFormOrderByOrderInForm(id);
	}
	@GetMapping("/{id}/QuestionForms")
	public List<QuestionForm> getQuestionForms(@PathVariable Course id) {
		return questionFormRepo.findByCourseOrderByDate(id);
	}
	@GetMapping("/{id}/QuestionFormQuestions")
	public List<Question> getQuestions(@PathVariable QuestionForm id) {
		return questionRepo.findByQuestionFormOrderByOrderInForm(id);
	}
	@GetMapping("{id}/Assignments")
	public List<Assignment> getAssignments(@PathVariable Course id){
		return assignmentRepository.findByCourseOrderByDate(id);
	}
	@GetMapping("/{id}/showAssignment")
	public Assignment getAssignment(@PathVariable Long id) {
		return assignmentRepository.findById(id)
				.orElseThrow(()-> new AssignmentNotFoundException(id));
	}
	@PostMapping("/createAssignment")
	public void createAssignment(@RequestBody Assignment assignment) {
		assignment.setStatus(AssignmentEnum.AssignmentStatus.Uploaded);
		assignmentRepository.save(assignment);
		List<People> people = assignment.getCourse().getPeople();
		List<People> students = getStudentsFromPeople(people);
		if(assignment.getType() == AssignmentEnum.AssignmentType.GroupAssignment) {
			for(Group group : assignment.getCourse().getGroups()) {
				Artifact artifact = new Artifact(assignment.getExplanation(),
												assignment.getDate(),
												ArtifactStatus.NotSubmitted,
												group,
												assignment.getCourse(),
												assignment);
				artifactRepository.save(artifact);
			}
		}else {
			for(People student : students) {
				Artifact artifact = new Artifact(assignment.getExplanation(),
						assignment.getDate(),
						ArtifactStatus.NotSubmitted,
						student,
						assignment.getCourse(),
						assignment);
				artifactRepository.save(artifact);
			}
		}
	}
	@PostMapping("/{questionForm}/CreateAnswerForms")
	public void createQuestionForm(@PathVariable QuestionForm questionForm) {
		Course course = questionForm.getCourse();
		questionFormRepo.save(questionForm);
		
		List<Question> questions = questionForm.getQuestions();
		
		for(int i = 0;i  < questions.size();i++) {
			Question question = questions.get(i);
			question.setCourse(course);
			question.setQuestionForm(questionForm);
			questionRepo.save(question);
		}	
			List<People> allPeople = course.getPeople();
			List<People> students = getStudentsFromPeople(allPeople);
			for(int j = 0;j < students.size();j++) {

						
				AnswerForm answerForm = AnswerForm.correctedAnswerForm(new AnswerForm(questionForm, students.get(j), null));
				answerFormRepo.save(answerForm);
				for(int i = 0;i < questions.size();i++) {
					answerRepo.save(answerForm.getAnswer().get(i));
				}
			}
			
	}
	@PutMapping("/UpdateAnswerForm")
	public void updateAnswerForm(@RequestBody Answer answer) {
		answerRepo.save(answer);
	}
	@PutMapping("/UploadAssignment/{artifact}")
	public void updateArtifact(@PathVariable Artifact artifact) {
		artifactRepository.save(artifact);
	}
	@PutMapping("/GradeArtifact/{instructor}/artifact=/{artifact}")
	public void gradeArtifact(@PathVariable People instructor,
							  @PathVariable Artifact artifact,
							  @RequestBody List<Grade> grades) {
		artifact.setGrades(grades);
		artifactRepository.save(artifact);
	}
	@DeleteMapping("/DeleteQuestionForm/{id}")
	public void deleteQuestionForm(@PathVariable Long id) {
		questionFormRepo.deleteById(id);
	}
	@DeleteMapping("/DeleteAssignment/{id}")
	public void deleteAssignment(@PathVariable Long id) {
		Assignment assignment = assignmentRepository.findById(id)
				.orElseThrow(() -> new AssignmentNotFoundException(id));
		List<Artifact> artifacts = assignment.getArtifacts();
		for(Artifact artifact : artifacts) {
			artifactRepository.deleteById(artifact.getId());
		}
		assignmentRepository.deleteById(id);
	}
	
}