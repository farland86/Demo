package org.domain.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> exceptionHandler(HttpServletRequest request, Exception e) {
		return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
