package model;

public class WorkZone {
	
	private String workZoneId;
	private Machine[] machines;
	

	public WorkZone(String workZoneId, Machine[] machines){
		this.workZoneId = workZoneId;
		this.machines = machines;
	}

	public String getWorkZoneId() {
		return workZoneId;
	}
	
	public Machine[] getMachines() {
		return machines;
	}
	
}
