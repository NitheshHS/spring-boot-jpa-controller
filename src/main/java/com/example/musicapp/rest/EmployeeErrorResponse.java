package com.example.musicapp.rest;

public class EmployeeErrorResponse {
	
	private int statusCode;
	
	private String message;
	
	private Long timestamp;

	public EmployeeErrorResponse(int statusCode, String message, Long timestamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = timestamp;
	}
	
	public EmployeeErrorResponse() {}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
