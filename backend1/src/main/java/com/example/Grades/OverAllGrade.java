package com.example.Grades;
/*
 * OverAll grade of student
 */
public class OverAllGrade{
	private Integer grade;
	private Integer maxgrade;
	public OverAllGrade(Integer grade, Integer maxGrade) {
		this.setGrade(grade);
		this.setMaxgrade(maxGrade);
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getMaxgrade() {
		return maxgrade;
	}
	public void setMaxgrade(Integer maxgrade) {
		this.maxgrade = maxgrade;
	}
	
}