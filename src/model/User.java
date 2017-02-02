package model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private String course;
	private Group group;
	
	public User(){}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String name, String surname, String email, String course) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.course = course;
	}

	public User(String username, String password, String name, String surname, String email, String course,
			Group group) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.course = course;
		this.group = group;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getCourse() {
		return course;
	}


	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
		
	}
<<<<<<< HEAD
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setCourse(String course) {
		this.course = course;
=======

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", surname=" + surname + ", course=" + course + ", group=" + group + "]";
>>>>>>> 97edb6d5dc7fdf440418682705ea137cec09271a
	}
	
	
	
	
	
}
