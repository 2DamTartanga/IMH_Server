package model;

public class User {
	
	private String name;
	private String surname;
	private String userName;
	private String password;
	private boolean isSuperUser;
	
	public User(String name, String surname, String userName, String password, boolean isSuperUser){
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
		this.isSuperUser = isSuperUser;
	}
	
	

}
