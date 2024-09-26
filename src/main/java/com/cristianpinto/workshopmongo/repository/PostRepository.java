package com.cristianpinto.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cristianpinto.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{// Conectar banco de dados do Mongo

	

}