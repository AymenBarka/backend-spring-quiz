package com.bezkoder.springjwt.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Question;
import com.bezkoder.springjwt.models.Quiz;
import com.bezkoder.springjwt.repository.QuestionRepository;
import com.bezkoder.springjwt.repository.QuizRepository;



@Service("QuizService")
public class QuizServiceImpl implements QuizService {
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	QuestionRepository questionRepo;

	@Override
	public void AjoutQuiz(Quiz quiz) {

		quizRepository.save(quiz);
		
	}

	@Override
	public void QuizCandidat(Quiz quiz) {

		quizRepository.save(quiz);

		
	}

	@Override
	public Quiz getQuizbyId(int id) {
		return quizRepository.findById(id).get();
	}

	@Override
	public List<Quiz> getAll() {
		return quizRepository.findAll();
	}

	@Override
	public void AjoutlistQuiz(List<Quiz> quiz) {
		quizRepository.saveAll(quiz);		
	}

	@Override
	public Quiz updateQuiz(Quiz quiz, int id) {
		Quiz existquiz = quizRepository.findById(quiz.getId()).orElse(null);
		existquiz.setTitre(quiz.getTitre());
		quiz.getQuestion().forEach(existquiz::addQuestion);
			
		return quizRepository.save(existquiz);
	}

	@Override
	public String deleteQuiz(int id) {
		Optional<Quiz>quiz = quizRepository.findById(id);
		if(quiz.isPresent()) {
			quizRepository.delete(quiz.get());
			return "quiz is delayted by id" + id;
		}
		throw new RuntimeException ("Not Found Quiz");

	}

}
