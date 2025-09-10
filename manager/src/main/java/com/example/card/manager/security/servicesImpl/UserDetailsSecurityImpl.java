package com.example.card.manager.security.servicesImpl;

import com.example.card.manager.domain.ERole;
import com.example.card.manager.domain.User;
import com.example.card.manager.domain.UserRole;
import com.example.card.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsSecurityImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Autowired
	UserRepository userRepository;

	private Long id;

	private String username;

	private String email;

	private String password;

	private Collection<? extends GrantedAuthority> authorities;


	public UserDetailsSecurityImpl(Long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsSecurityImpl build(User user) {
		List<GrantedAuthority> authorities = user.getUserRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole().getRoleName().name()))
				.collect(Collectors.toList());
		Set<ERole> roles = user.getUserRoles().stream()
				.map(role -> role.getRole().getRoleName())
				.collect(Collectors.toSet());

		return new UserDetailsSecurityImpl(
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				authorities);
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsSecurityImpl user = (UserDetailsSecurityImpl) o;
		return Objects.equals(id, user.id);
	}
}
