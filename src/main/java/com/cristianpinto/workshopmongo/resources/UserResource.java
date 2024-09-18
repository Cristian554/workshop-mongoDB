package com.cristianpinto.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristianpinto.workshopmongo.domain.User;
import com.cristianpinto.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	@Autowired
	private UserService service;
	
	@GetMapping// end point para dados estarem inseridos no caminho certo
	public ResponseEntity<List<User>> findAll(){ // responseEntity encapsula cabeçalho possiveis erros e retornos
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);//ok responde em http e o body o corpo da resposta 
	}
	
	
	
}
