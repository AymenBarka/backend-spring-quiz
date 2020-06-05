package com.bezkoder.springjwt.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Quiz;
import com.bezkoder.springjwt.repository.QuizRepository;



@Service("QuizService")
public class QuizServiceImpl implements QuizService {
	@Autowired
	QuizRepository quizRepository;

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
		existquiz.setQuestion(quiz.getQuestion());
		return quizRepository.save(existquiz);
	}

	@Override
	public String deleteQuiz(int id_quiz) {
		Optional<Quiz>quiz = quizRepository.findById(id_quiz);
		if(quiz.isPresent()) {
			quizRepository.delete(quiz.get());
			return "quiz is delayted by id" + id_quiz;
		}
		throw new RuntimeException ("Not Found Quiz");

	}

}
