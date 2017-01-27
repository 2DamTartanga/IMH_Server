package clases;

import java.util.ArrayList;

public class TechnicianGroup {

	private String id;
	private ArrayList<User> technicians;
	private ArrayList<WorkOrder> workOrders;
	
	public String getId() {
		return id;
	}
	public ArrayList<User> getTechnicians() {
		return technicians;
	}
	public ArrayList<WorkOrder> getWorkOrders() {
		return workOrders;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTechnicians(ArrayList<User> technicians) {
		this.technicians = technicians;
	}
	public void setWorkOrders(ArrayList<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}
	
	
}
