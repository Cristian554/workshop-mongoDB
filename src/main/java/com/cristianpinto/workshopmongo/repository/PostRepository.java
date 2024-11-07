package com.cristianpinto.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cristianpinto.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{// Conectar banco de dados do Mongo
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") // Ignorar a verificação do case, Query endPoint de consulta
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text); // Ignore case para ignorar o formato das letras
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")// Utiliza-se and pois seria entre a data max. E a data Min. 
	List<Post> fullSearch(String text, Date minDate,Date maxDate);

}
