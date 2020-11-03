package com.rental.car.model;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private String email;
	private Collection<? extends GrantedAuthority> auth;

	public JwtResponse(String jwttoken, String email, Collection<? extends GrantedAuthority> auth) {
		this.jwttoken = jwttoken;
		this.email = email;
		this.auth = auth;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getEmail() {
		return email;
	}

	public Collection<? extends GrantedAuthority> getAuth() {
		return auth;
	}
}