package com.cristianpinto.workshopmongo.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cristianpinto.workshopmongo.domain.Post;
import com.cristianpinto.workshopmongo.domain.User;
import com.cristianpinto.workshopmongo.dto.AuthorDTO;
import com.cristianpinto.workshopmongo.repository.PostRepository;
import com.cristianpinto.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
			
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,"23/03/2018", "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null,"23/03/2018", "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));


	
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
