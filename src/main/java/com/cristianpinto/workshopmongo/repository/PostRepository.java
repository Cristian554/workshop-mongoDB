package com.cristianpinto.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cristianpinto.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{// Conectar banco de dados do Mongo
	
	@Query("{'title: { $regex: ?0, $options: 'i' } }") // Ignorar a verificação do case
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text); // Ignore case para ignorar o formato das letras

}
