package com.shahinkhalajestani.banktask.base.advice;

import com.shahinkhalajestani.banktask.base.exception.BankTaskException;
import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import com.shahinkhalajestani.banktask.base.model.ResultStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class BankTaskExceptionControllerAdvise extends ResponseEntityExceptionHandler {

	private final Environment environment;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		var uri = ((ServletWebRequest) request).getRequest().getRequestURI();
		log.error("invalid request for uri : {}", uri);
		var response = new ResponseModel(ResultStatus.INVALID_PARAMETER);
		response.setMessage(environment.getProperty(ResultStatus.INVALID_PARAMETER.getDescription()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
		var response = new ResponseModel(ResultStatus.FAILURE);
		response.setMessage(environment.getProperty(ResultStatus.FAILURE.getDescription()));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

	@ExceptionHandler(BankTaskException.class)
	public final ResponseEntity<Object> handleBankTaskException(BankTaskException ex, WebRequest request) {
		var response = new ResponseModel(ex.getStatus());
		response.setMessage(environment.getProperty(ex.getStatus().getDescription()));
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
	}



}
