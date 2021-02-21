package com.alexandre.cursos.resources.exeption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alexandre.cursos.services.exeptions.DataIntegridyExeption;
import com.alexandre.cursos.services.exeptions.ObjectNotFoundExeption;
import com.alexandre.cursos.services.exeptions.StandartError;

@ControllerAdvice // nao sei o que faz
public class ResourceExeptionHandler {
	
	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<StandartError> objectNotFoundExeption(ObjectNotFoundExeption e, HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegridyExeption.class)
	public ResponseEntity<StandartError> DataIntegridyExeption(DataIntegridyExeption e, HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
