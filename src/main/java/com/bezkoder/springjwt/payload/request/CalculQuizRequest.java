package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.Quiz;
import com.bezkoder.springjwt.models.User;

public class CalculQuizRequest {

	private int score;
	private User user; 
	private Quiz quiz;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	@Override
	public String toString() {
		return "CalcuQuizRequest [score=" + score + ", user=" + user + ", quiz=" + quiz + "]";
	}
	
}
