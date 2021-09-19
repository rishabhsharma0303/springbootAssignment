package com.productapp.web.exceptions;
public class ErrorDetails {

	private String email;
	private String message;

	public ErrorDetails() {
	}

	public ErrorDetails(String email, String message) {
		this.email = email;
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorDetails [email=");
		builder.append(email);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

}