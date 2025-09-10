package com.example.card.manager.security.jwt.payload.request;


import jakarta.validation.constraints.NotBlank;

public class TokenRefreshRequest {

	public TokenRefreshRequest() {
	}

	@NotBlank
	private String refreshToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
