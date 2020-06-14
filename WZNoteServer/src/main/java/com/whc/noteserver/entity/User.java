package com.whc.noteserver.entity;

import java.io.Serializable;

public class User implements Serializable {

	private String id;
	private String username; // �û���
	private String password;// ����
	private int age;// ����
	private String name;// ����


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ",  age=" + age + ", name=" + name + "]";
	}

}
