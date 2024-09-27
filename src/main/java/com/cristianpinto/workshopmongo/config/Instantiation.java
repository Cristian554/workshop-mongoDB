package com.cristianpinto.workshopmongo.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cristianpinto.workshopmongo.domain.Post;
import com.cristianpinto.workshopmongo.domain.User;
import com.cristianpinto.workshopmongo.dto.AuthorDTO;
import com.cristianpinto.workshopmongo.dto.CommentDTO;
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
		
		User maria = new User(null,"maria@gmail.com", "Maria Brown");
		User alex = new User(null, "alex@gmail.com","Alex Green");
		User bob = new User(null,"bob@gmail.com", "Bob Grey");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, "21/03/2018", "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, "23/03/2018", "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", "21/03/2018", new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", "22/03/2018", new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", "23/03/2018", new AuthorDTO(alex));
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
