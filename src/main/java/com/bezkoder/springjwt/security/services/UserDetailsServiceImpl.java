package com.bezkoder.springjwt.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, IServiceUser {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public String deleteUser(Long id) {
		Optional<User> user =userRepository.findById(id);
		if(user.isPresent()) {
		userRepository.delete(user.get());
		return "user is delayted by id" +user;
	}
		throw new RuntimeException("Not found User");
	}

}
