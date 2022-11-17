package com.apigateway.model;

public class JwtResponse {
	private Integer id;
	private String username;
	private String email;
	private String token;

	public JwtResponse(String token, Integer id, String username, String email) {
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
