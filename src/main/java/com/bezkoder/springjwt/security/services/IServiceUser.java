package com.bezkoder.springjwt.security.services;

import java.util.List;

import com.bezkoder.springjwt.models.User;


public interface IServiceUser {
	public List<User> getAll();
	public String deleteUser(Long id);

}
