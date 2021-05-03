package com.example.Form;
import java.util.ArrayList;

// This is an old design
public class QuestionFormWithQuestions{
		private QuestionForm questionForm;
		private ArrayList<Question> questions;
		
		public QuestionForm getQuestionForm() {
			return this.questionForm;
		}
		
		public ArrayList<Question> getQuestions() {
			return this.questions;
		}
		
		public void setQuestions(ArrayList<Question> q) {
			this.questions = q;
		}
	}