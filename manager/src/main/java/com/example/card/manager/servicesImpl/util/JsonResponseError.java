package com.example.card.manager.servicesImpl.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
public class JsonResponseError {
	
	private Integer code;
	
	private HttpStatus status;
	
	private String message;

	private Instant timestamp;

	private List<String> errors;

	public JsonResponseError(HttpStatus pStatus, String pMessage, List<String> pErrors) {
		super();
		status = pStatus;
		message = pMessage;
		errors = pErrors;
		code = pStatus.value();
		this.timestamp = Instant.now();
	}

	public JsonResponseError(HttpStatus pStatus, String pMessage, String pErrors) {
		super();
		status = pStatus;
		message = pMessage;
		errors = Arrays.asList(pErrors);
		code = pStatus.value();
		this.timestamp = Instant.now();
	}
	
	public JsonResponseError(HttpStatus pStatus, String pMessage) {
		super();
		status = pStatus;
		message = pMessage;		
		code = pStatus.value();
		this.timestamp = Instant.now();
	}

}