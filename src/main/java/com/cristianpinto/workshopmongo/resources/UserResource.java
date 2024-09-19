package com.cristianpinto.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristianpinto.workshopmongo.domain.User;
import com.cristianpinto.workshopmongo.dto.UserDTO;
import com.cristianpinto.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	@Autowired
	private UserService service;
	
	@GetMapping// end point para dados estarem inseridos no caminho certo
	public ResponseEntity<List<UserDTO>> findAll(){ // responseEntity encapsula cabeçalho possiveis erros e retornos
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Conversão list para ListDto expressão Lambda
		return ResponseEntity.ok().body(listDto);//ok responde em http e o body o corpo da resposta 
	}
	@GetMapping(value="/{id}")
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	
	}
}
