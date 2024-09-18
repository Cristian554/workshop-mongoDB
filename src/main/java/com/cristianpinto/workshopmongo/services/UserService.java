package com.cristianpinto.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristianpinto.workshopmongo.domain.User;
import com.cristianpinto.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // Utilizado para conectar a etsrtutura que tem dependencia 
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();	

       }
}