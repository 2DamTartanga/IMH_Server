package clases;

public class User {

	private String userName;
	private String password;
	private String email;
	private String name;
	private String surName;
	private String course;
	private String cycle;
	private TechnicianGroup group;
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getSurName() {
		return surName;
	}
	public String getCourse() {
		return course;
	}
	public String getCycle() {
		return cycle;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public TechnicianGroup getGroup() {
		return group;
	}
	public void setGroup(TechnicianGroup group) {
		this.group = group;
	}
	
	
	  
}
