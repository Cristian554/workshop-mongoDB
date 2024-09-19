package com.cristianpinto.workshopmongo.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cristianpinto.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // Trata possiveis erros nas aquisições
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) // Padrão do sistema para ativar a excessão personalizada
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Não Encontrado",
				e.getMessage(), request.getRequestURI());// CurrentTime = Instante atual do Systema //Status.value =
		return ResponseEntity.status(status).body(err);											// converte em inteiro
		
	}

}
