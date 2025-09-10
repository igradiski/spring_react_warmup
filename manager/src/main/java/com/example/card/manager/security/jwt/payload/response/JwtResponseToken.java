package com.example.card.manager.security.jwt.payload.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponseToken {

	private String accessToken;
	private String type = "Bearer";
	private String refreshToken;
	private String username;
	private String email;
	private Collection<? extends GrantedAuthority> role;
	
	public JwtResponseToken(String jwt, String refTok, String userName, String email,Collection<? extends GrantedAuthority> role) {
		this.accessToken= jwt;
		this.refreshToken = refTok;
		this.username = userName;
		this.email = email;
		this.role = role;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<? extends GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<? extends GrantedAuthority> role) {
		this.role = role;
	}
}
