package model;

public class User {
	
	private String userName;
	private String name;
	private String surname;
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
	
	public User(String name, String surname, String userName, String password, String email, String course, String type){
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.course = course;
		this.type = type.charAt(0);
		
	}
	
	public void setGroup(Group group){
		this.group = group;
	}

	public String getUserName() {
		return userName;
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

	@Override
	public String toString() {
		return "User [\nuserName = " + userName + ", \nname = " + name + ", \nsurname = " + surname + ", \npassword = " + password
				 +  ", \nemail = " + email + ", \ncourse = " + course + ", \ntype = " + type + ", \ngroup = [" + group + "\n]\n]";
	}
	
	
	
	

}
