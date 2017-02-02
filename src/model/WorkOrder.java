package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class WorkOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int severity;
	private String others;
	private String typeOfMaintenance;
	private Date creationDate;
	private ArrayList<Repair> repairs;
	private Breakdown breakdown;
	
	public WorkOrder(Breakdown breakdown, int severity, Date date, String others, String typeOfMaintenance) {
		this.breakdown = breakdown;
		this.severity = severity;
		this.creationDate = date;
		this.others = others;
		this.typeOfMaintenance = typeOfMaintenance;
	}
	public WorkOrder(Breakdown breakdown, int severity, Date date, String others, String typeOfMaintenance,
			ArrayList<Repair> repairs) {
		this.breakdown = breakdown;
		this.severity = severity;
		this.creationDate = date;
		this.others = others;
		this.typeOfMaintenance = typeOfMaintenance;
		this.repairs = repairs;
	}
	
	public WorkOrder() {
	}
	public Breakdown getBreakdown() {
		return breakdown;
	}
	public int getSeverity() {
		return severity;
	}
	public Date getDate() {
		return creationDate;
	}
	public String getOthers() {
		return others;
	}
	public String getTypeOfMaintenance() {
		return typeOfMaintenance;
	}
	public ArrayList<Repair> getRepairs() {
		return repairs;
	}
	
	public int getId(){
		return this.getBreakdown().getId();
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public void setTypeOfMaintenance(String typeOfMaintenance) {
		this.typeOfMaintenance = typeOfMaintenance;
	}
	public void setRepairs(ArrayList<Repair> repairs) {
		this.repairs = repairs;
	}
	public void setBreakdown(Breakdown breakdown) {
		this.breakdown = breakdown;
	}
}
