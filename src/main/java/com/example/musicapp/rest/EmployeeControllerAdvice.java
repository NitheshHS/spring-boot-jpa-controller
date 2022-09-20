package com.example.musicapp.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {

	//add exception handler
		@ExceptionHandler
		public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
			//create employee error response object
			EmployeeErrorResponse error = new EmployeeErrorResponse();
			//set the pojo's 
			error.setStatusCode(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(new Date().getTime());
			//return response entity
			return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.NOT_FOUND);
		}

		//Handle any type of exception
		@ExceptionHandler
		public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
			//create employee error response object
			EmployeeErrorResponse error = new EmployeeErrorResponse();
			//set the pojo's 
			error.setStatusCode(HttpStatus.BAD_REQUEST.value());
			error.setMessage("Invalid input : "+exc.getMessage());
			error.setTimestamp(new Date().getTime());
			//return response entity
			return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.BAD_GATEWAY);

		}
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<EmployeeErrorResponse> handleException(
				MethodArgumentNotValidException exc){
			
			EmployeeErrorResponse error = new EmployeeErrorResponse();
			error.setStatusCode(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(new Date().getTime());
			
			return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.BAD_REQUEST);
		}

}
