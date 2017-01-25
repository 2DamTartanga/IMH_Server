package new_classes;

import java.sql.Date;

public class Breakdown {

	private int id;
	private Date date;
	private User reporter;
	private int failureType;
	private String subject;
	private String description;
	private Machine machine;
	private int equipmentAvailable;
	
	public Breakdown(int id, Date date, User reporter, int failureType, String subject, String description,
			Machine machine, int equipmentAvailable) {
		this.id = id;
		this.date = date;
		this.reporter = reporter;
		this.failureType = failureType;
		this.subject = subject;
		this.description = description;
		this.machine = machine;
		this.equipmentAvailable = equipmentAvailable;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public User getReporter() {
		return reporter;
	}

	public int getFailureType() {
		return failureType;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	public Machine getMachine() {
		return machine;
	}

	public int getEquipmentAvailable() {
		return equipmentAvailable;
	}
	
	
	
	
}
