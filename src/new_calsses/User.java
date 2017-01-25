package new_calsses;

public class User {

	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String course;
	private char type;
	private Group group;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String name, String surname, String email, String course,
			char type) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.course = course;
		this.type = type;
	}

	public User(String username, String password, String name, String surname, String email, String course, char type,
			Group group) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.course = course;
		this.type = type;
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

	public char getType() {
		return type;
	}

	public Group getGroup() {
		return group;
	}
	
	
	
	
	
}
