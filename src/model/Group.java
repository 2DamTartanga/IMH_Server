package model;

public class Group {
	
	private String name;
	private boolean isDirective;
	
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
	
}
