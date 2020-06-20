package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Question {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	    private String questionName;
	    private String option1;
	    private String option2;
	    private String option3;
	    private String option4;
	    private String reponse;
	    @ManyToOne( optional=false)
	    @JoinColumn(name= "quiz_id",referencedColumnName = "id")
	    @JsonIgnore
	    private Quiz quiz;
		public Question() {
			
		}
		

		
	
		
		public Question(int id, String questionName, String option1, String option2, String option3, String option4,
				String reponse, Quiz quiz) {
			super();
			this.id = id;
			this.questionName = questionName;
			this.option1 = option1;
			this.option2 = option2;
			this.option3 = option3;
			this.option4 = option4;
			this.reponse = reponse;
			this.quiz = quiz;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getQuestionName() {
			return questionName;
		}
		public void setQuestionName(String questionName) {
			this.questionName = questionName;
		}
		public String getOption1() {
			return option1;
		}
		public void setOption1(String option1) {
			this.option1 = option1;
		}
		public String getOption2() {
			return option2;
		}
		public void setOption2(String option2) {
			this.option2 = option2;
		}
		public String getOption3() {
			return option3;
		}
		public void setOption3(String option3) {
			this.option3 = option3;
		}
		public String getOption4() {
			return option4;
		}
		public void setOption4(String option4) {
			this.option4 = option4;
		}
		public String getReponse() {
			return reponse;
		}
		public void setReponse(String reponse) {
			this.reponse = reponse;
		}
		public Quiz getQuiz() {
			return quiz;
		}
		public void setQuiz(Quiz quiz) {
			this.quiz = quiz;
		}
		@Override
		public String toString() {
			return "Question [id=" + id + ", questionName=" + questionName + ", option1=" + option1 + ", option2="
					+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", reponse=" + reponse + ", quiz="
					+ quiz + "]";
		}





		

}