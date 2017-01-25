package new_classes;

import java.util.ArrayList;

public class Localization {

	private int id;
	private ArrayList<Machine> machines;
	public Localization(int id, ArrayList<Machine> machines) {
		this.id = id;
		this.machines = machines;
	}
	
	public int getId() {
		return id;
	}
	public ArrayList<Machine> getMachines() {
		return machines;
	}
	
	
	
}
