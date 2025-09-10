package com.example.card.manager.security.services;



import com.example.card.manager.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

	RefreshToken createRefreshToken(Long id);

	Optional<RefreshToken> findByToken(String requestRefreshToken);

	RefreshToken verifyExpiration(RefreshToken tok);

}
