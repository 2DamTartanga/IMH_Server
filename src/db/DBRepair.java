package db;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.sun.javafx.scene.control.skin.ToolBarSkin;

import model.Repair;
import model.WorkOrder;

public class DBRepair extends NewDBManager {
	
	public ArrayList<Repair> getRepairs(WorkOrder workOrder) throws Exception{
		ArrayList<Repair> rRepairs = new ArrayList<>();
		Repair r = null;
		int id = workOrder.getId();
		this.connect();
		sql = "SELECT * FROM repairs WHERE id = "+id+";";
		while(rs.next()){
			r = getRepairFromResultSet();
			r.setTools(new DBTools().getToolsFromRepair(rs.getString("tools")));
		}
		this.close();
		return rRepairs;
	}
	
	public WorkOrder addRepair(WorkOrder workOrder){
		
	}
	
	private Repair getRepairFromResultSet() throws Exception{
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
