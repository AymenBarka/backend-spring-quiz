package com.bezkoder.springjwt.security.services;

import java.util.List;

import com.bezkoder.springjwt.models.Question;
import com.bezkoder.springjwt.models.Quiz;


public interface QuestionService {
	public void AjoutQR(Question Questions);
	public void deleteQR(Question Questions);
	public Question getId_Question(int id_Question);
	public List<Question> GetAll();
	void AjoutlistQuestion(List<Question> Questions);
	 public  Question updateQuestion(Question quest, int id);

}
