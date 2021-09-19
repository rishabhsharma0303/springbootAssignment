package com.productapp.web.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productapp.web.exceptions.ErrorDetails;
import com.productapp.web.exceptions.*;
import java.util.*;
@RestController
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

//	****************Handling 404********************
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(Exception ex) {
		ErrorDetails errorDetail = new ErrorDetails();
		errorDetail.setEmail("jhimanshu9922@gmail.com");
		errorDetail.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetail);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		//? expore some method inside this fieldErrors and then put
		
		StringBuilder builder=new StringBuilder("validation failed for : ");
		
		for(FieldError fe:fieldErrors ) {
			builder.append(fe.getField()).append(" ,");
			
		}
		
		ErrorDetails errorMessage = new ErrorDetails();
		errorMessage.setEmail("jhimanshu9922@gmail.com");
		errorMessage.setMessage(builder.toString());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}

//	***************Handling 500*****************************
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorDetails> handle500(Exception ex) {
//		ErrorDetails errorDetail = new ErrorDetails();
//		errorDetail.setEmail("jhimanshu9922@gmail.com");
//		errorDetail.setMessage(ex.toString());
//		return ResponseEntity.status(500).body(errorDetail);
//	}

	

}