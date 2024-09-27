package com.cristianpinto.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristianpinto.workshopmongo.domain.Post;
import com.cristianpinto.workshopmongo.repository.PostRepository;
import com.cristianpinto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // Utilizado para conectar a etsrtutura que tem dependencia
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}