package com.example.Form;

import com.example.Grades.Grade;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
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
	
	// Wire all related repositories
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
	
	// Return students from people list
	List<People> getStudentsFromPeople(List<People> allPeople){
		
		List<People> students = new ArrayList<People>();
		
		for(int index = 0;index < allPeople.size();index++) {
			
			if(allPeople.get(index).getPeople() == People.PeopleType.Student) {
				students.add(allPeople.get(index));
			}
			
		}
		
		return students;
	}
	
	// Get AnswerForms for student and course
	@GetMapping("/{courseId}/{studentId}/AnswerForms")
	public List<AnswerForm> getAnswerForms(@PathVariable People studentId, @PathVariable Course courseId) {
		return answerFormRepo.findByStudentAndCourse(studentId, courseId);
	}
	
	// Display questions(answers) of AnswerForm
	@GetMapping("/{id}/{AnswerFormQuestions")
	public List<Answer> getAnswers(@PathVariable AnswerForm id) {
		return answerRepo.findByAnswerFormOrderByOrderInForm(id);
	}
	
	// Display questions of QuestionForm
	@GetMapping("/{id}/QuestionForms")
	public List<QuestionForm> getQuestionForms(@PathVariable Course id) {
		return questionFormRepo.findByCourseOrderByDate(id);
	}
	
	/*
	 * This is for old design
	@GetMapping("/{id}/QuestionFormQuestions")
	public List<Question> getQuestions(@PathVariable QuestionForm id) {
		return questionRepo.findByQuestionFormOrderByOrderInForm(id);
	}*/
	
	// Display assignments of a course
	@GetMapping("{id}/Assignments")
	public List<Assignment> getAssignments(@PathVariable Course id){
		return assignmentRepository.findByCourseOrderByDate(id);
	}
	
	// show an assignment
	@GetMapping("/{id}/showAssignment")
	public Assignment getAssignment(@PathVariable Long id) {
		return assignmentRepository.findById(id)
				.orElseThrow(()-> new AssignmentNotFoundException(id));
	}
	
	/*Create Assignment
	 * It creates an assignment 
	 * Then create Artifacts for students(or groups)
	 */
	@PostMapping("/{course}/createAssignment")
	public void createAssignment(@PathVariable Course course, @RequestBody Assignment assignment) {
		// Uploaded by instructor
		assignment.setStatus(AssignmentEnum.AssignmentStatus.Uploaded);
		
		// set course if course is not specified by frontend 
		assignment.setCourse(course);
		assignmentRepository.save(assignment); // save to database
		
		// find students
		List<People> people = course.getPeople();
		List<People> students = getStudentsFromPeople(people);
		
		//If group assignmment generate artifacts for groups
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
			//If stduent assignmment generate artifacts for groups
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
	
	// Create Question Form without questions
	@PostMapping("/{course}/CreateQuestionForm")
	public QuestionForm createQuestionForm(@PathVariable Course course,@RequestBody QuestionForm questionForm) {
		
		questionForm.setCourse(course); // utility
		questionFormRepo.save(questionForm);
		return questionForm;
	}
	
	// Add questions to question form
	@PostMapping("/{questionForm}/addQuestion")
	public Question addQuestion(@PathVariable QuestionForm questionForm, @RequestBody Question question) {
		
		question.setCourse(questionForm.getCourse()); // utility function
		questionForm.addQuestion(question); // utility function
		questionRepo.save(question);
		return question;
	}
	/* When Instructor publishes, it directly links to this link
	 * Create AnswerForms for students(it will be updated to students and groups)
	 * 
	 */
	@PostMapping("/{questionForm}/CreateAnswerForms")
	public void createAnswerForms(@PathVariable QuestionForm questionForm) {
		Course course = questionForm.getCourse();
		//questionFormRepo.save(questionForm);
		
		// Get Questions
		List<Question> questions = questionForm.getQuestions();
		
		// get students of the course
		List<People> allPeople = course.getPeople();
		List<People> students = getStudentsFromPeople(allPeople);
		
		for(int j = 0;j < students.size();j++) {	
			
			// generate answerform for every student
			AnswerForm answerForm = new AnswerForm(questionForm, students.get(j), null);
			answerFormRepo.save(answerForm);
			for(int i = 0;i < questions.size();i++) {
				
				// create answer for every question x student
				Answer answer = new Answer(students.get(i), answerForm, questions.get(i));//problematic
				questions.get(i).addAnswer(answer);
				answerForm.addAnswer(answer);
				answerRepo.save(answer);
			}
				
		}
			
	}
	
	// Update an aswer of answerform
	@PutMapping("/UpdateAnswerForm/{answerform}")
	public void updateAnswerForm(@PathVariable AnswerForm answerform,
								@RequestBody Answer answer,
								@RequestParam Integer order) {
		answerform.getAnswer().set(order, answer);
		answerRepo.save(answer);
	}

	// Upload file to artifact
	@PostMapping("/{artifact}/uploadFile")
	public void uploadFile(@PathVariable Artifact artifact, @RequestBody MultipartFile file) 
	throws IOException{
		artifact.setFile(file.getBytes());
		artifactRepository.save(artifact);
	}
	
	// Update artifact
	@PutMapping("/UploadAssignment/{artifact}")
	public void updateArtifact(@PathVariable Artifact artifact) {
		artifactRepository.save(artifact);
	}
	
	// Grade artifact
	@PutMapping("/GradeArtifact/{instructor}/artifact=/{artifact}")
	public void gradeArtifact(@PathVariable People instructor,
							  @PathVariable Artifact artifact,
							  @RequestBody List<Grade> grades) {
		artifact.setGrades(grades);
		artifactRepository.save(artifact);
	}
	
	// Delete QuestionForm(Deleteing anserform is not allowed)
	@DeleteMapping("/DeleteQuestionForm/{id}")
	public void deleteQuestionForm(@PathVariable Long id) {
		questionFormRepo.deleteById(id); // all child answerforms have been removed(orphan.removal = true)
	}
	
	// Delete assignments
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