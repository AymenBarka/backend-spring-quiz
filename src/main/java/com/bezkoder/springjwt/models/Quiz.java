package com.bezkoder.springjwt.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true,nullable = false)
	private int id;
	private String titre;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "quiz", cascade =  CascadeType.ALL)
	private List<Question> question = new ArrayList<>();
	public Quiz() {
		
		
	}
	public void addQuestion(Question question) {
		this.question.add(question);
		question.setQuiz(this);
		
	}
	public void removeQuestion(Question question) {
		this.question.remove(question);
		question.setQuiz(null);
	}
	
		
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}


	public List<Question> getQuestion() {
		return question;
	}


	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	


	@Override
	public String toString() {
		return "Quiz [id=" + id + ", titre=" + titre + ", question=" + question + "]";
	}
	

}

