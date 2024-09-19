package com.cristianpinto.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cristianpinto.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{// Conectar banco de dados do Mongo

	

}
