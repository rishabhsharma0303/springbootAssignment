package com.bookapp.web.controller.exceptions;
import java.util.Date;
import java.util.List;

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

import com.bookapp.model.repo.BookNotFoundException;
@ControllerAdvice
@RestController
public class BookAppExceptionHandler extends ResponseEntityExceptionHandler{

	
	  @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			//how to deal 
			BindingResult bindingResult = ex.getBindingResult();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			//? expore some method inside this fieldErrors and then put
			
			StringBuilder builder=new StringBuilder("validation failed for : ");
			
			for(FieldError fe:fieldErrors ) {
				builder.append(fe.getField()).append(" ,");
				
			}
			
			ErrorDetails details=new ErrorDetails("raj@raj.com", builder.toString(),
					"server side validation failed");
			
			return new ResponseEntity<Object>(details, HttpStatus.BAD_REQUEST);
		}

	  

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		  ErrorDetails errorDetails = new ErrorDetails("raj@raj.com", "Validation Failed",
//			      ex.getBindingResult().toString());
//			  return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(Exception ex, WebRequest request){
		ErrorDetails details=new ErrorDetails();
		details.setEmailId("ravi.admin@ymsli.com");
		details.setMessage("book not found");
		details.setDetailMessage(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handle500(Exception ex, WebRequest request){
		ErrorDetails details=new ErrorDetails();
		details.setEmailId("ravi.admin@ymsli.com");
		details.setMessage("some server side error");
		details.setDetailMessage(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}
}