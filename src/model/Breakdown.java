package model;

import java.io.Serializable;
import java.util.Date;

public class Breakdown implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date date;
	private String failureType;
	private String description;
	private String equipmentAvailable;
	private String subject;
	private Machine machine;
	private User reporter;
	
	
	public Breakdown(int id) {
		this.id = id;
	}

	public Breakdown(int id, Date date, User reporter, String failureType, String subject, String description,
			Machine machine, String equipmentAvailable) {
		this.id = id;
		this.date = date;
		this.reporter = reporter;
		this.failureType = failureType;
		this.subject = subject;
		this.description = description;
		this.machine = machine;
		this.equipmentAvailable = equipmentAvailable;
	}

	public Breakdown() {
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

	public String getFailureType() {
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

	public String getEquipmentAvailable() {
		return equipmentAvailable;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setFailureType(String failureType) {
		this.failureType = failureType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEquipmentAvailable(String equipmentAvailable) {
		this.equipmentAvailable = equipmentAvailable;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public void setReporter(User reporter) {
		this.reporter = reporter;
	}

	@Override
	public String toString() {
		return "Breakdown [id=" + id + ", date=" + date + ", failureType=" + failureType + ", description="
				+ description + ", equipmentAvailable=" + equipmentAvailable + ", subject=" + subject + ", machine="
				+ machine + ", reporter=" + reporter + "]";
	}
	
	
	
}
