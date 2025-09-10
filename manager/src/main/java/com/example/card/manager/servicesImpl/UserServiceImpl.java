package com.example.card.manager.servicesImpl;

import com.example.card.manager.domain.RefreshToken;
import com.example.card.manager.domain.dto.UserDto;
import com.example.card.manager.repository.UserRepository;
import com.example.card.manager.security.jwt.JwtUtils;
import com.example.card.manager.security.jwt.payload.response.JwtResponseToken;
import com.example.card.manager.security.services.RefreshTokenService;
import com.example.card.manager.security.servicesImpl.UserDetailsSecurityImpl;
import com.example.card.manager.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder encoder;

    private final RefreshTokenService refreshTokenService;

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, JwtUtils jwtUtils, AuthenticationManager authenticationManager, PasswordEncoder encoder, RefreshTokenService refreshTokenService) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public ResponseEntity<?> authenticateUser(UserDto userDto) {
        log.info("Pokrećem auth usera");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.username(), userDto.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsSecurityImpl userDetails = (UserDetailsSecurityImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
        return ResponseEntity.ok(new JwtResponseToken(jwt,refreshToken.getToken(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getAuthorities()));
    }
}
