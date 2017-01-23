package model;

import java.util.Date;

public class WorkOrder {
	
	private String workOrderId;
	private int requiresTool;
	
	// FIXME
	private String instructionsUrl;
	private boolean isValidated;
	private Date date;
	
	public WorkOrder(String workOrderId, int requiresTool, String instructionsUrl, boolean isValidated, Date date){
		this.workOrderId = workOrderId;
		this.requiresTool = requiresTool;
		this.instructionsUrl = instructionsUrl;
		this.isValidated = isValidated;
		this.date = date;
	}

}
