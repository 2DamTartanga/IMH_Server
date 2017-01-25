package new_calsses;

import java.util.ArrayList;

public class Group {
	private int id;
	private char role;
	private ArrayList<User> users;
	
	public Group(int id, char role) {
		this.id = id;
		this.role = role;
	}

	public Group(int id, char role, ArrayList<User> users) {
		this.id = id;
		this.role = role;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public char getRole() {
		return role;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
	
	
	
}
