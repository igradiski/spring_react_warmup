package com.example.card.manager.security.jwt.payload.response;

public class TokenRefreshResponse {
	
	private String accessToken;
	private String refreshToken;
	private String tokenType = "Bearer";
	
	public TokenRefreshResponse(String token, String refToken) {
		this.accessToken  = token;
		this.refreshToken = refToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
}
