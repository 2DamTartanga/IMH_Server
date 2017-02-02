package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Group;
import model.Repair;
import model.WorkOrder;

public class DBRepair extends NewDBManager {
	
	public ArrayList<Repair> getRepairs(WorkOrder workOrder, boolean needsGroup) throws Exception{
		ArrayList<Repair> rRepairs = new ArrayList<>();
		Repair r = null;
		int id = workOrder.getId();
		this.connect();
		sql = "SELECT * FROM repairs WHERE id = "+id+";";
		while(rs.next()){
			r = getRepairFromResultSet(needsGroup);
			r.setTools(new DBTools().getToolsFromRepair(rs.getString("tools")));
		}
		this.close();
		return rRepairs;
	}
	
	public ArrayList<Repair> getRepairs(WorkOrder workOrder) throws Exception{
		return this.getRepairs(workOrder,true);
	}
	
	public int addRepair(WorkOrder workOrder) throws SQLException{//TODO acabar
		int result;
		
		this.connect();
		Repair r = workOrder.getRepairs().get(workOrder.getRepairs().size() - 1);
		
		
		sql = "UPDATE repairs SET("
				+ "repairDate = '"+format.format(r.getDate())+"' "
				+ "time = "+r.getTime()+" "
				+ "availablilityAfter = '"+r.getAvailabilityAfterRepair()+"' "
				+ "tools "//TODO esto es trabajo de Ismael Trueba
				+ "repairProcess = '"+r.getRepairProcess()+"' "
				+ "idLocalization = "+r.getFailureLocalization()+" "
				+ "isRepaired = "+r.isRepaired()+" "
				+ "replacements = '"+r.getReplacements()+"' "
				+ ") "
				+ "WHERE codBreakdown = "+workOrder.getId()+" "
				+ "AND idGroup = "+r.getGroup().getId()+" ;";
		result = stmt.executeUpdate(sql);
		
		this.close();
		
		return result;
	}
	
	public ArrayList<Repair> getRepairsFromGroup(Group group) throws Exception{
		ArrayList<Repair> rRepairs = new ArrayList<>();
		
		this.connect();
		sql = "SELECT * FROM repairs WHERE idGroup='"
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
		String id = String.valueOf(rs.getInt("codBreakdown"));
		System.out.println("post");
		Repair rRepair = null;
		boolean next = true;
		while(rs.getString("codBreakdown") == id && next){
		try{
		rRepair = new Repair(
				rs.getDate("repairDate"),
				rs.getInt("idLocalization"),
				rs.getFloat("time"),
				rs.getString("availabilityAfter"),
				rs.getString("repairProcess"),
				rs.getBoolean("isRepaired"),
				rs.getString("replacements")
				);
		}catch(SQLException e){
		}
		next = rs.next();
		}
		//rs.previous();
		return rRepair;
	}
}
