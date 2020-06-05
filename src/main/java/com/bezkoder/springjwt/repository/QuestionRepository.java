package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Question;


@Repository("QuestionRepository")
public interface QuestionRepository extends JpaRepository<Question , Integer> {

	
}
