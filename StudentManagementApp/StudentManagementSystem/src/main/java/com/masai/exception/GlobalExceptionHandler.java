package com.masai.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> myExceptionHandler(Exception ex,WebRequest req){
		
		MyErrorDetail error = new MyErrorDetail(ex.getMessage(), LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetail> customerExceptionHandler(StudentException ex,WebRequest req){
		
		MyErrorDetail error = new MyErrorDetail();
		
		error.setMessage(ex.getMessage());
		
		error.setErrorDateTime(LocalDateTime.now());
		
		error.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(error, HttpStatus.BAD_REQUEST);
	}
	
}
