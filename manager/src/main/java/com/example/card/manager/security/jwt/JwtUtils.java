package com.example.card.manager.security.jwt;

import com.example.card.manager.security.servicesImpl.UserDetailsSecurityImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
	
	@Value("${manager.jwtSecret}")
	private String jwtSecret;

	@Value("${manager.jwtExpiration}")
	private int jwtExpirationMs;

	private Logger log = LoggerFactory.getLogger(JwtUtils.class);

	public String generateJwtToken(UserDetailsSecurityImpl userPrincipal) {
	    return generateJwtToken(userPrincipal.getUsername());
	  }

	private Key getSigningKey() {
		byte[] keyBytes = this.jwtSecret.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	String generateJwtToken(String username) {
		return Jwts.builder().setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(getSigningKey())
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();

		return claims.getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			log.info("Token: "+authToken);
			Jwts.parserBuilder()
					.setSigningKey(getSigningKey())
					.build()
					.parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			log.error("Invalid JWT token: {}", e.getMessage());
			return false;
		}
	}

}
