package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Breakdown;
import model.Group;
import model.Machine;
import model.Repair;
import model.WorkOrder;

public class DBWorkOrder extends DBConn {

	public WorkOrder getWorkOrder(WorkOrder workOrder) throws Exception{
		WorkOrder workOrderFromDatabase = new WorkOrder();
		
		this.connect();
		sql = "SELECT * FROM workorder w" +
				"INNER JOIN breakdowns " + 
				"ON " + workOrder.getId() + "=breakdowns.codBreakdown";
		
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			
			Breakdown breakdownToAdd = new Breakdown();
			breakdownToAdd.setDate(rs.getDate(""));
			breakdownToAdd.setDescription(rs.getString(""));
			breakdownToAdd.setEquipmentAvailable(rs.getString(""));
			breakdownToAdd.setFailureType(rs.getString(""));
			breakdownToAdd.setId(rs.getInt(""));
			
			DBMachine dbMachine = new DBMachine();
			Machine m = dbMachine.getMachine(new Machine(rs.getString("codeMachine")));
			breakdownToAdd.setMachine(m);
			
			workOrderFromDatabase.setBreakdown(breakdownToAdd);
			
			workOrderFromDatabase.setCreationDate(rs.getDate("creationDate"));
			workOrderFromDatabase.setOthers(rs.getString("others"));
			workOrderFromDatabase.setSeverity(rs.getInt("severity"));
			workOrderFromDatabase.setTypeOfMaintenance(String.valueOf(rs.getInt("typeMaintenance")));
			
			ArrayList<Repair> repairsToAdd = new DBRepair().getRepairs(workOrder);
			workOrderFromDatabase.setRepairs(repairsToAdd);
			
			this.close();
		}
		
		return workOrderFromDatabase;
	}

	public ArrayList<WorkOrder> getWorkOrdersFromGroup(Group group) throws Exception {
		ArrayList<WorkOrder> rWorkOrders = new ArrayList<>();
		int id = group.getId();
		this.connect();
		
		sql = "SELECT * FROM workorders "
				+ "WHERE LOWER(idGroup) LIKE LOWER('"+id+"') ";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rWorkOrders.add(getWorkOrderFromResult());
		}
		this.close();
		
		if(rWorkOrders.size() == 0) rWorkOrders = null;
		return rWorkOrders;
	}
	
	private WorkOrder getWorkOrderFromResult(){
		WorkOrder rWorkOrder = null;
		return rWorkOrder;
	}
}
