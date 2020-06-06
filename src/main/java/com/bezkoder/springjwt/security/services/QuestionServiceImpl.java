package com.bezkoder.springjwt.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Question;
import com.bezkoder.springjwt.repository.QuestionRepository;


@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	QuestionRepository questionrepository;
	
	@Override
	public List <Question> GetAll() { 
		// TODO Auto-generated method stub
		return questionrepository.findAll();
		
	}
	
	
	@Override
	public Question getId_Question(int id_Question) {
		// TODO Auto-generated method stub
		return questionrepository.getOne(id_Question);
	}

	
	@Override
	public void  AjoutlistQuestion(List<Question> Questions) {
		questionrepository.saveAll(Questions);
	}

	
	
	@Override
	public void deleteQR(Question Questions) { 
		// TODO Auto-generated method stub
		
	}


	@Override
	public void AjoutQR(Question Questions) {
		// TODO Auto-generated method stub
		
	}


	@Override
	 public  Question updateQuestion(Question quest, int id) {
		Question existquestion = questionrepository.findById(quest.getId()).orElse(null);
		existquestion.setQuestionName(quest.getQuestionName());
		existquestion.setOption1(quest.getOption1());
		existquestion.setOption2(quest.getOption2());
		existquestion.setOption3(quest.getOption3());
		existquestion.setOption4(quest.getOption4());
		existquestion.setReponse(quest.getReponse());
		return questionrepository.save(existquestion);
	}
}
