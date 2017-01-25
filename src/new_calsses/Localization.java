package new_calsses;

public class Localization {

	private int id;
	private Machine[] machines;
	public Localization(int id, Machine[] machines) {
		this.id = id;
		this.machines = machines;
	}
	
	public int getId() {
		return id;
	}
	public Machine[] getMachines() {
		return machines;
	}
	
	
	
}
