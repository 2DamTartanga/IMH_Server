package new_classes;

import java.util.ArrayList;

public class Localization {

	private int id;
	private String name;
	private ArrayList<Machine> machines;
	
	public Localization(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Localization(int id, String name, ArrayList<Machine> machines) {
		this(id, name);
		this.machines = machines;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName(){
		return this.name;
	}
	public ArrayList<Machine> getMachines() {
		return machines;
	}
	
	public void setMachines(ArrayList<Machine> machines){
		this.machines = machines;
	}
	
	
	
}
