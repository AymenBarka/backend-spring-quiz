package com.bezkoder.springjwt.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Quiz;
import com.bezkoder.springjwt.models.Resultat;
import com.bezkoder.springjwt.repository.ResultatRepository;

@Service("ResultatService")
public class ResultatServiceImpl implements IServiceResultat {
	 @Autowired
     ResultatRepository resultatrepository;
	@Override
	public void AddResultat(Resultat resultat) {
      resultatrepository.save(resultat);		
	}
	@Override
	public Resultat getResultatbyId(int id) {
		// TODO Auto-generated method stub
		return resultatrepository.findById(id).get();
	}
	@Override
	public List<Resultat> getAll() {
		// TODO Auto-generated method stub
		return resultatrepository.findAll();
	}
	@Override
	public Resultat updateResultat(Resultat resultat, int id) {
		Resultat existresult = resultatrepository.findById(resultat.getId()).orElse(null);
		existresult.setScore(resultat.getScore());
		return resultatrepository.save(existresult);
	}
	@Override
	public String deleteResultat(int id) {
		Optional<Resultat>resultat = resultatrepository.findById(id);
		if(resultat.isPresent()) {
			resultatrepository.delete(resultat.get());
			return "result is delayted by id" + id;
		}
		throw new RuntimeException ("Not Found result");

	}
}
