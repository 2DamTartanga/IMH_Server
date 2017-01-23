package model;

import java.util.Date;

public class Issue {
	
	private String failureType;
	private Date date;
	private String subject;
	private String description;
	private String severity;
	
	public Issue(String failureType, Date date, String subject, String description, String severity){
		this.failureType = failureType;
		this.date = date;
		this.subject = subject;
		this.description = description;
		this.severity = severity;
	}

}
