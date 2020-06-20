package com.bezkoder.springjwt.security.services;

import java.util.List;

import com.bezkoder.springjwt.models.Resultat;



public interface IServiceResultat {

	public void AddResultat( Resultat resultat);
	public Resultat getResultatbyId(int id);
	List <Resultat> getAll() ;
	 public  Resultat updateResultat(Resultat resultat,int id);
	 public String deleteResultat(int id);

}
