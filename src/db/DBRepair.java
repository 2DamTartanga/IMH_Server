package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Group;
import model.Repair;
import model.WorkOrder;

public class DBRepair extends NewDBManager {
	
	public WorkOrder getRepairs(WorkOrder workOrder){
		
	}
	
	public boolean addRepair(WorkOrder workOrder) throws SQLException{
		boolean result = false;
		
		this.connect();
		Repair r = workOrder.getRepairs().get(workOrder.getRepairs().size() - 1);
		sql = "INSERT INTO repairs (codBreakdonw, idGroup, "
				+ "repairDate, time, availabilityAfter, tools, repairProcess, "
				+ "idLocalization, isRepaired, replacements) "
				+ "VALUES ('" + workOrder.getBreakdown().getId() + "', '"
				+ r.getGroup().getId() + "', '"
				+ r.getDate() + "', '"
				+ r.getTime() + "', '"
				+ r.getRepairProcess() + "', '"
				+ r.getFailureLocalization() + "', '"
				+ r.isRepaired() + "', '"
				+ r.getReplacements() + "', '"
				+ "')";
				
		result = stmt.execute(sql);
		
		this.close();
		
		return result;
	}
	
	public ArrayList<Repair> getRepairsFromGroup(Group group){
		
	}
}
