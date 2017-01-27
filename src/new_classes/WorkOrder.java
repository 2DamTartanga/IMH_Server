package new_classes;

import java.util.ArrayList;
import java.util.Date;

public class WorkOrder {

	private Breakdown breakdown;
	private int severity; //Lo mismo que equipmentAvailable?? entonces sobra, sino no
	private Date date;
	private String others;
	private int typeOfMaintenance;
	private ArrayList<Repair> repairs;
	
	public WorkOrder(Breakdown breakdown, Date date, String others, int typeOfMaintenance) {
		this.breakdown = breakdown;
		this.date = date;
		this.others = others;
		this.typeOfMaintenance = typeOfMaintenance;
	}
	public WorkOrder(Breakdown breakdown, Date date, String others, int typeOfMaintenance,
			ArrayList<Repair> repairs) {
		this.breakdown = breakdown;
		this.date = date;
		this.others = others;
		this.typeOfMaintenance = typeOfMaintenance;
		this.repairs = repairs;
	}
	
	public Breakdown getBreakdown() {
		return breakdown;
	}
	public int getSeverity() {
		return severity;
	}
	public Date getDate() {
		return date;
	}
	public String getOthers() {
		return others;
	}
	public int getTypeOfMaintenance() {
		return typeOfMaintenance;
	}
	public ArrayList<Repair> getRepairs() {
		return repairs;
	}
	public int getId(){
		return breakdown.getId();
	}
	public void setRepair(Repair repair) {
		repairs = new ArrayList<>();
		repairs.add(repair);
	}
	
	
	
}