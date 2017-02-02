package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Group;
import java.text.ParseException;
import java.util.ArrayList;

import com.sun.javafx.scene.control.skin.ToolBarSkin;
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
		ArrayList<Repair> result = new ArrayList<>();
		
		this.connect();
		sql = "SELECT * FROM repairs WHERE idGroup='"
				+ group.getId() + "'";
		ResultSet rs = stmt.executeQuery(sql);
		
	}
	
	private Repair getRepairFromResultSet(boolean needsGroup) throws Exception{
		String id = rs.getString("id");
		Repair rRepair = null;
		while(rs.getString("id") == id && rs.next()){
		rRepair = new Repair(
				format.parse(rs.getDate("date").toString()),
				rs.getInt("failureLocalization"),
				rs.getFloat("time"),
				rs.getString("availabilityAfterRepair"),
				rs.getString("repairProcess"),
				rs.getBoolean("isRepaired"),
				rs.getString("replacements")
				);
		}
		return rRepair;
	}
}
