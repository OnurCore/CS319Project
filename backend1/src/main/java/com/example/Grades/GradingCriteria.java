package com.example.Grades;
import javax.persistence.Embeddable;

@Embeddable // Don't have table but embeddable 
public class GradingCriteria{
	
		private String explanation;
		private Integer maximum;
		
		// getters setters
		
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