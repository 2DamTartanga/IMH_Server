package db;

import java.util.ArrayList;

import model.Group;
import model.Repair;
import model.WorkOrder;

public class DBRepair extends DBConn {
	
	public WorkOrder getRepairs(WorkOrder workOrder, boolean needsGroup) throws Exception{
		Repair rRepair = null;
		Repair r = null;
		int id = workOrder.getId();
		int idGroup = workOrder.getRepair().getGroup().getId();
		this.connect();
		sql = "SELECT * FROM repairs "
			+ "WHERE id = "+id+" "
			+ "AND idGroup LIKE "+idGroup+";";
		if(rs.next()){
			r = getRepairFromResultSet(needsGroup);
			r.setTools(new DBTools().getToolsFromRepair(rs.getString("tools")));
		}
		workOrder.setRepairs(rRepair);
		this.close();
		return workOrder;
	}
	
	public WorkOrder getRepairs(WorkOrder workOrder) throws Exception{
		return this.getRepairs(workOrder,true);
	}
	
	public int addRepair(WorkOrder workOrder) throws Exception{//TODO acabar
		int result;
		
		this.connect();
		Repair r = workOrder.getRepair();
		
		
		sql = "UPDATE repairs SET("
				+ "repairDate = '"+format.format(r.getDate())+"' "
				+ "time = "+r.getTime()+" "
				+ "availablilityAfter = '"+r.getAvailabilityAfterRepair()+"' "
				+ "repairProcess = '"+r.getRepairProcess()+"' "
				+ "idLocalization = "+r.getFailureLocalization()+" "
				+ "isRepaired = "+r.isRepaired()+" "
				+ "replacements = '"+r.getReplacements()+"' "
				+ ") "
				+ "WHERE codBreakdown = "+workOrder.getId()+" "
				+ "AND idGroup = "+r.getGroup().getId()+" ;";
		result = stmt.executeUpdate(sql);
		new DBTools().insertTootls(workOrder);
		
		this.close();
		
		return result;
	}
	
	public ArrayList<Repair> getRepairsFromGroup(Group group) throws Exception{
		ArrayList<Repair> rRepairs = new ArrayList<>();
		
		this.connect();
		sql = "SELECT * FROM repairs "
				+ "WHERE idGroup='"
				+ group.getId() + "';";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rRepairs.add(getRepairFromResultSet(false));
		}
		System.out.println("size = " + rRepairs.size());
		return rRepairs;
	}
	
	private Repair getRepairFromResultSet(boolean needsGroup) throws Exception{
		Repair rRepair = null;
		rRepair = new Repair(
				rs.getDate("repairDate"),
				rs.getInt("idLocalization"),
				rs.getFloat("time"),
				rs.getString("availabilityAfter"),
				rs.getString("repairProcess"),
				rs.getBoolean("isRepaired"),
				rs.getString("replacements")
		);
		rRepair.setTools(new DBTools().getToolsFromRepair(
				rs.getInt("codBreakdown"), 
				rs.getString("idGroup"), 
				rs.getDate("repairDate")));
		return rRepair;
	}
}
