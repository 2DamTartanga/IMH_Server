package clases;

import java.util.ArrayList;

public class MachineAndroid{
	private String id;
  private int state;
  private int importance;
  private WorkZone workZone;
  private ArrayList<Issue> issues;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public int getImportance() {
	return importance;
}
public void setImportance(int importance) {
	this.importance = importance;
}
public WorkZone getWorkZone() {
	return workZone;
}
public void setWorkZone(WorkZone workZone) {
	this.workZone = workZone;
}
public ArrayList<Issue> getIssues() {
	return issues;
}
public void setIssues(ArrayList<Issue> issues) {
	this.issues = issues;
}
  
  
  
}
