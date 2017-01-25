package new_calsses;

public class Group {
	private int id;
	private char role;
	private User[] users;
	
	public Group(int id, char role) {
		this.id = id;
		this.role = role;
	}

	public Group(int id, char role, User[] users) {
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

	public User[] getUsers() {
		return users;
	}
	
	
	
}
