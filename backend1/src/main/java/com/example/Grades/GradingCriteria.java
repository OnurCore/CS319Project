package com.example.Grades;
import javax.persistence.Embeddable;
@Embeddable
public class GradingCriteria{
		private String explanation;
		private Integer maximum;
		public String getExplanation() {
			return explanation;
		}
		public void setExplanation(String explanation) {
			this.explanation = explanation;
		}
		public Integer getMaximum() {
			return maximum;
		}
		public void setMaximum(Integer maximum) {
			this.maximum = maximum;
		}
	
	}