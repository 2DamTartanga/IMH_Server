package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
public class Repair implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private int failureLocalization;
	private float time;
	private String availabilityAfterRepair;
	private HashMap<Integer, String> tools;
	private String repairProcess;
	private boolean isRepaired;
	private String replacements;
	private Group group;
	
	public Repair(){};
	public Repair(Date date, int failureLocalization, float time, String availabilityAfterRepair, String repairProcess,
			boolean isRepaired, String replacements) {
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
	public HashMap<Integer,String> getTools() {
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
	public void setTools(HashMap<Integer, String> tools) {
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
	@Override
	public String toString() {
		return "Repair [date=" + date + ", failureLocalization=" + failureLocalization + ", time=" + time
				+ ", availabilityAfterRepair=" + availabilityAfterRepair + ", tools=" + tools + ", repairProcess="
				+ repairProcess + ", isRepaired=" + isRepaired + ", replacements=" + replacements + ", group=" + group
				+ "]";
	}	
	
}
