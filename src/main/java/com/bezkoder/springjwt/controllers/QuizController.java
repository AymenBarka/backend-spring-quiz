package com.bezkoder.springjwt.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Quiz;
import com.bezkoder.springjwt.models.Resultat;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.ResultatRepository;
import com.bezkoder.springjwt.security.services.QuizService;
import com.bezkoder.springjwt.security.services.ResultatServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	@Autowired
	ResultatServiceImpl resultatservice;
	int score;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	@PreAuthorize(" hasRole('COACH') or hasRole('ADMIN')")
	public void addQuiz(@RequestBody Quiz quiz){
		quiz.getQuestion().forEach(question -> {
			question.setQuiz(quiz);
		});
		quizService.AjoutlistQuiz(Collections.singletonList(quiz));
	}
	@PutMapping("/getReponses")
	@ResponseBody
	ResponseEntity<?> editCoach(@RequestBody Quiz newQuiz) {
		quizService.QuizCandidat(newQuiz);
		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/ListQuiz")
	public List<Quiz> getAll() {
		return quizService.getAll();
	}
	
	@PutMapping("UpdateQuiz/{id}")
	@PreAuthorize(" hasRole('COACH') or hasRole('ADMIN')")
	public Quiz updateQuiz(@RequestBody Quiz quiz, @PathVariable (value="id")int id) {
		return quizService.updateQuiz(quiz, id);
	}
	@RequestMapping(path = "/deleteQuiz/{id}", method = RequestMethod.DELETE)
	@PreAuthorize(" hasRole('COACH') or hasRole('ADMIN')")
	public String deleteQuiz(@PathVariable(value ="id")int id) {
		return quizService.deleteQuiz(id);
	}
	
	@GetMapping("quizbyId/{id}")
	@PreAuthorize("hasRole('CANDIDAT') or hasRole('COACH') or hasRole('ADMIN')")
	public Quiz getQuizbyId(@PathVariable(value="id")int id) {
		return quizService.getQuizbyId(id);
	}
	
	@RequestMapping(path = "/calculQuiz" , method = RequestMethod.POST)
	public void AddResultat(@RequestBody Resultat resultats) {
               Resultat resultat = new Resultat();
               resultat.setScore(resultats.getScore());
               
               resultatservice.AddResultat(resultats);
		
	}
	
}
