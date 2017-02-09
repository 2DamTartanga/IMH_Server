
package com.tartanga.dam.imhandroid.model;

import java.io.Serializable;
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
	private Repair repair;
	private Breakdown breakdown;
	
	public WorkOrder(Breakdown breakdown, int severity, Date date, String others, String typeOfMaintenance) {
		this.breakdown = breakdown;
		this.severity = severity;
		this.creationDate = date;
		this.others = others;
		this.typeOfMaintenance = typeOfMaintenance;
	}
	public WorkOrder(Breakdown breakdown, int severity, Date date, String others, String typeOfMaintenance,
			Repair repair) {
		this.breakdown = breakdown;
		this.severity = severity;
		this.creationDate = date;
		this.others = others;
		this.typeOfMaintenance = typeOfMaintenance;
		this.repair = repair;
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
	public Repair getRepair() {
		return repair;
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
	public void setRepair(Repair repairsToAdd) {
		this.repair = repairsToAdd;
	}
	public void setBreakdown(Breakdown breakdown) {
		this.breakdown = breakdown;
	}
	@Override
	public String toString() {
		return "WorkOrder [\nseverity=" + severity + ",\n\t others=" + others + ",\n\t typeOfMaintenance=" + typeOfMaintenance
				+ ",\n\t creationDate=" + creationDate + ",\n\t repair=" + repair + ",\n\t breakdown=" + breakdown + "\n]";
	}
	
	
}
