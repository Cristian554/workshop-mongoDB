package com.cristianpinto.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristianpinto.workshopmongo.domain.Post;
import com.cristianpinto.workshopmongo.repository.PostRepository;
import com.cristianpinto.workshopmongo.resources.util.URL;
import com.cristianpinto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // Utilizado para conectar a etsrtutura que tem dependencia
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	public List<Post> fullSearch(String text,Date minDate,Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
