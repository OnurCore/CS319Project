package com.example.Grades;
public class Grade{
	public enum GradeType{
		ArtifactGrade,
		PeerGrade
	}
	public Integer grade;
	
	public String comment;
	
	public Integer maxGrade;
	
	public GradeType type;
	public GradeType getType() {
		return type;
	}

	public void setType(GradeType type) {
		this.type = type;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getMaxGrade() {
		return maxGrade;
	}

	public void setMaxGrade(Integer maxGrade) {
		this.maxGrade = maxGrade;
	}

	
	
}