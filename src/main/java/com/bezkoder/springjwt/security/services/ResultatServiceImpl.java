package com.bezkoder.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Resultat;
import com.bezkoder.springjwt.repository.ResultatRepository;

@Service("ResultatService")
public class ResultatServiceImpl implements IServiceResultat {
	 @Autowired
     ResultatRepository resultatrepository;
	@Override
	public void AddResultat(Resultat resultats) {
     resultatrepository.save(resultats);		
	}

}
