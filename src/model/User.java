package model;

public class User {
	
	private String name;
	private String surname;
	private String userName;
	private String password;
	private String email;
	private String course;
	private char type;
	private Group group;
	
	public User(String name, String surname, String userName, String password, String email, String course, char type, Group group){
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.course = course;
		this.type = type;
		this.group = group;
	}
	
	

}
