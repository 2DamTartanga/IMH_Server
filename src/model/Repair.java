package model;

import java.util.ArrayList;
import java.util.Date;

import java.io.Serializable;
public class Repair implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private int failureLocalization;
	private float time;
	private String availabilityAfterRepair;
	private ArrayList<String> tools;
	private String repairProcess;
	private boolean isRepaired;
	private String replacements;
	private Group group;
	
	
	
	public Repair(Date date, int failureLocalization, float time, String availabilityAfterRepair, String repairProcess,
			boolean isRepaired, String replacements) {
		super();
		this.date = date;
		this.failureLocalization = failureLocalization;
		this.time = time;
		this.availabilityAfterRepair = availabilityAfterRepair;
		this.repairProcess = repairProcess;
		this.isRepaired = isRepaired;
		this.replacements = replacements;
	}
	public Date getDate() {
		return date;
	}
	public int getFailureLocalization() {
		return failureLocalization;
	}
	public float getTime() {
		return time;
	}
	public String getAvailabilityAfterRepair() {
		return availabilityAfterRepair;
	}
	public ArrayList<String> getTools() {
		return tools;
	}
	public String getRepairProcess() {
		return repairProcess;
	}
	public boolean isRepaired() {
		return isRepaired;
	}
	public String getReplacements() {
		return replacements;
	}
	
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setFailureLocalization(int failureLocalization) {
		this.failureLocalization = failureLocalization;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public void setAvailabilityAfterRepair(String availabilityAfterRepair) {
		this.availabilityAfterRepair = availabilityAfterRepair;
	}
	public void setTools(ArrayList<String> tools) {
		this.tools = tools;
	}
	public void setRepairProcess(String repairProcess) {
		this.repairProcess = repairProcess;
	}
	public void setRepaired(boolean isRepaired) {
		this.isRepaired = isRepaired;
	}
	public void setReplacements(String replacements) {
		this.replacements = replacements;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	
	
	
	
}
