package model;

public class Group {
	
	private String name;
	private boolean isDirective;
	private User[] users;
	
	public Group(String name, boolean isDirective){
		this.name = name;
		this.isDirective = isDirective;
	}

	public String getName() {
		return name;
	}

	public boolean isDirective() {
		return isDirective;
	}
	
	public User[] getUsers() {
		return users;
	}
	
}
