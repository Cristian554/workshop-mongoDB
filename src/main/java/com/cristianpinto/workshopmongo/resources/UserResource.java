package com.cristianpinto.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@GetMapping(value="{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
}
	@DeleteMapping(value="/{id}") // Deletar
	public ResponseEntity<Void> delete(@PathVariable String id){ // 
	service.delete(id);
		return ResponseEntity.noContent().build();// resposta 204 é no content
	}
    @PutMapping(value="/{id}") // Atualizar
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		
    }	
}