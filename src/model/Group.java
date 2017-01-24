package model;

import java.util.Arrays;

public class Group {
	
	private String name;//TODO yo pondria esto en int --Dani
	private boolean isDirective;
	private User[] users;
	
	public Group(String name, boolean isDirective){
		this.name = name;
		this.isDirective = isDirective;
	}
	
	public int getId(){
		String id = name.substring(2, name.length());
		return Integer.parseInt(id);
	}
	
	public char getRole(){
		char role = name.charAt(0);
		role = Character.toUpperCase(role);
		return role;
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

	
	public void setUsers(User[] users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [\nname = " + name + ", \nisDirective = " + isDirective + ", \nusers = " + Arrays.toString(users) + "\n]";
	}
	
}
