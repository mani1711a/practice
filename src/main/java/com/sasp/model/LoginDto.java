package com.sasp.model;

public class LoginDto {

	private int id;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [id=" + id + ", password=" + password + "]";
	}
	public LoginDto(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
