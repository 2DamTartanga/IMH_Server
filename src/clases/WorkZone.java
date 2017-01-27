package clases;

import java.util.ArrayList;

public class WorkZone {

	private String id;
	private String name;
	private ArrayList<MachineAndroid> machines;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public ArrayList<MachineAndroid> getMachines() {
		return machines;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMachines(ArrayList<MachineAndroid> machines) {
		this.machines = machines;
	}
	
	
}
