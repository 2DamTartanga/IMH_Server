package clases;

import java.util.Date;

public class Repair{

	private float timeSpent;
  private Date finishDate;
  private boolean isSolved;
  private String failureLocalization;
  private String replacements;
  private String tools;
  private String repairProcess;
  private WorkOrder workOreder;
public float getTimeSpent() {
	return timeSpent;
}
public void setTimeSpent(float timeSpent) {
	this.timeSpent = timeSpent;
}
public Date getFinishDate() {
	return finishDate;
}
public void setFinishDate(Date finishDate) {
	this.finishDate = finishDate;
}
public boolean isSolved() {
	return isSolved;
}
public void setSolved(boolean isSolved) {
	this.isSolved = isSolved;
}
public String getFailureLocalization() {
	return failureLocalization;
}
public void setFailureLocalization(String failureLocalization) {
	this.failureLocalization = failureLocalization;
}
public String getReplacements() {
	return replacements;
}
public void setReplacements(String replacements) {
	this.replacements = replacements;
}
public String getTools() {
	return tools;
}
public void setTools(String tools) {
	this.tools = tools;
}
public String getRepairProcess() {
	return repairProcess;
}
public void setRepairProcess(String repairProcess) {
	this.repairProcess = repairProcess;
}
public WorkOrder getWorkOreder() {
	return workOreder;
}
public void setWorkOreder(WorkOrder workOreder) {
	this.workOreder = workOreder;
}
  
  

}
