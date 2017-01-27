package clases;

public class Issue {

	private String failureType;
	private String severity;
	private String description;
	private String date;
	private User reporter;
	private Machine machine;
	  
	public String getFailureType() {
		return failureType;
	}
	public String getSeverity() {
		return severity;
	}
	public String getDescription() {
		return description;
	}
	public String getDate() {
		return date;
	}
	public User getReporter() {
		return reporter;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setFailureType(String failureType) {
		this.failureType = failureType;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setReporter(User reporter) {
		this.reporter = reporter;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	  
	  
}
