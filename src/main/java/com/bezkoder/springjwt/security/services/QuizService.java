package com.bezkoder.springjwt.security.services;

import java.util.List;

import com.bezkoder.springjwt.models.Quiz;


public interface QuizService {
	public void AjoutQuiz(Quiz quiz);
	public void QuizCandidat(Quiz quiz);
	public Quiz getQuizbyId(int id);
	List <Quiz> getAll() ;
	 void AjoutlistQuiz(List<Quiz> quiz);
	 public  Quiz updateQuiz(Quiz quiz, int id);
	 public String deleteQuiz(int id_quiz);

}