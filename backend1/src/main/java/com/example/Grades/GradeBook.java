package com.example.Grades;

import java.util.List;
import java.util.ArrayList;
import com.example.Form.Artifact;
import com.example.Form.Assignment;
import com.example.Form.AssignmentEnum;
import com.example.People.People.PeopleType;
import com.example.People.People; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
/*
 * Controller class for gradebook
 * collects grades from artifacts and answers form answerforms
 */

@RestController
public class GradeBook{
	
	// Show all grades for a criteria of an assignment
	@GetMapping("/instructor={instructor}/Assignment={assignment}/criteria={criteria}")
	public List<Grade> getGradingsOfAssignmentCriterias(@PathVariable People instructor,
											   Assignment assignment,
											   GradingCriteria criteria){
		
		if(instructor.getPeople() == PeopleType.Student) {
			throw new StudentNotAuthorizedException();
		}else {
			
		List<Grade> grades = new ArrayList<Grade>();
		List<Artifact> artifacts = assignment.getArtifacts();
		
		for(Artifact artifact : artifacts){
			
			for(Grade grade : artifact.getGrades()) {
				
				if(grade.getCriteria() == criteria) {
					grades.add(grade);
				}
				
			}
			
		}
		return grades;
	}
	}
	
	// Student access of overall grade of an artifact
	@GetMapping("people={people}/Artifact={artifact}")
	public OverAllGrade getGradingOfArtifact(@PathVariable People people, Artifact artifact) {
		Integer sumGrade = artifact.getOverAllGrade();
		Integer sumMaxGrade = artifact.getOverAllMaxGrade();
		OverAllGrade overAllGrade = new OverAllGrade(sumGrade, sumMaxGrade);
		return overAllGrade;
	}
	
	// Partial(By criterias) grades of an artifact
 	@GetMapping("/people={people}/artifact={artifact}grades")
	public List<Grade> getGradesOfAnArtifact(@PathVariable People people,
											Artifact artifact){
		if(people.getPeople() == PeopleType.Student) {
			if(artifact.getAssignment().getType() == AssignmentEnum.AssignmentType.StudentAssignment) {
				
				if(artifact.getStudent() == people) {
					
					return artifact.getGrades();
					
				}else {
					
					throw new StudentNotAuthorizedException();
					
					}
			}else {
				if(artifact.getGroup().getAllPeople().contains(people)){
					
					return artifact.getGrades();
					
				}else { 
					
					throw new StudentNotAuthorizedException();
					
				}
				
			}
			
		}else {
			
			return artifact.getGrades();
		}
	}

	//It will be coded later
	@GetMapping("/instructor={id}/questionForm={questionForm}/displayStatistcs={type}")
	public void getStatistics(){
		
	}
	
}