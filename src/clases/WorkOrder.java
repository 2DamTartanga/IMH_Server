package clases;

import java.util.ArrayList;

public class WorkOrder{
	private String id;
  private PDF instructions;
  private String typeOfMaintenance;
  private String annotations;
  private ArrayList<Repair> repair;

  
  public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public PDF getInstructions() {
	return instructions;
}
public void setInstructions(PDF instructions) {
	this.instructions = instructions;
}
public String getTypeOfMaintenance() {
	return typeOfMaintenance;
}
public void setTypeOfMaintenance(String typeOfMaintenance) {
	this.typeOfMaintenance = typeOfMaintenance;
}
public String getAnnotations() {
	return annotations;
}
public void setAnnotations(String annotations) {
	this.annotations = annotations;
}
public ArrayList<Repair> getRepair() {
	return repair;
}
public void setRepair(ArrayList<Repair> repair) {
	this.repair = repair;
}
  
  
  
}
