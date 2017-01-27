package new_classes;

import java.util.Date;

public class Breakdown {

	private int id;
	private Date date;
	private User reporter;
	private FailureType failureType;
	private String subject;
	private String description;
	private Machine machine;
	private int equipmentAvailable;
	
	public Breakdown(int id){
		this.id = id;
	}
	
	
	public Breakdown(int id, Date date, FailureType failureType, String subject, String description,
			Machine machine, int equipmentAvailable) {
		this.id = id;
		this.date = date;
		this.failureType = failureType;
		this.subject = subject;
		this.description = description;
		this.machine = machine;
		this.equipmentAvailable = equipmentAvailable;
	}
	
	public Breakdown(int id, Date date, User reporter, FailureType failureType, String subject, String description,
			Machine machine, int equipmentAvailable) {
		this(id, date, failureType, subject, description, machine, equipmentAvailable);
		this.reporter = reporter;
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

	public FailureType getFailureType() {
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
	
	public void setReporter(User reporter){
		this.reporter = reporter;
	}
	
	
	
	
}