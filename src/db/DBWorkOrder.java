package db;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.tartanga.dam.imhandroid.model.Breakdown;
import com.tartanga.dam.imhandroid.model.Group;
import com.tartanga.dam.imhandroid.model.Machine;
import com.tartanga.dam.imhandroid.model.Repair;
import com.tartanga.dam.imhandroid.model.WorkOrder;

public class DBWorkOrder extends DBConn {

	public WorkOrder getWorkOrder(WorkOrder workOrder) throws Exception{
		WorkOrder workOrderFromDatabase = new WorkOrder();
		this.connect();
		sql = "SELECT * FROM workorders w" +
				"INNER JOIN breakdowns " + 
				"ON " + workOrder.getId() + "=breakdowns.codBreakdown";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			
			Breakdown breakdownToAdd = 
					new DBBreakdown().getBreakdown(
							new Breakdown(rs.getInt("codBreakdown")));
			DBMachine dbMachine = new DBMachine();
			Machine m = dbMachine.getMachine(new Machine(rs.getString("codMachine")));
			breakdownToAdd.setMachine(m);
			
			workOrderFromDatabase.setBreakdown(breakdownToAdd);
			
			workOrderFromDatabase.setCreationDate(rs.getDate("creationDate"));
			workOrderFromDatabase.setOthers(rs.getString("others"));
			workOrderFromDatabase.setSeverity(rs.getInt("severity"));
			workOrderFromDatabase.setTypeOfMaintenance(String.valueOf(rs.getInt("typeMaintenance")));
			Repair repairToAdd = new DBRepair().getRepairsFromWorkOrder(workOrder);
			workOrderFromDatabase.setRepair(repairToAdd);
			
			this.close();
		}
		
		return workOrderFromDatabase;
	}

	public ArrayList<WorkOrder> getPendingWorkOrdersFromGroup(Group group) throws Exception {
		ArrayList<WorkOrder> rWorkOrders = new ArrayList<>();
		int id = group.getId();
		this.connect();
		//String sub = "SELECT codBreakdown FROM repairs WHERE LOWER(idGroup) LIKE LOWER('"+id+"')";
		String sub="SELECT codBreakdown FROM asignations LEFT OUTER JOIN repairs USING(codBreakdown) WHERE asignations.idGroup="+id+"";
		sql = "SELECT * FROM workorders INNER JOIN asignations ON(workorders.idBreakdown=asignations.codBreakdown) "
				+ "WHERE idBreakdown IN ("+sub+") ORDER BY severity DESC";//TODO AND repairDate(subselect) = 1990-01-01
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rWorkOrders.add(getWorkOrderFromResult(group));
		}
		this.close();
		
		if(rWorkOrders.size() == 0) rWorkOrders = null;
		return rWorkOrders;
	}
	
	private WorkOrder getWorkOrderFromResult(Group group) throws Exception{
		Breakdown br = 
				new DBBreakdown().getBreakdown(
						new Breakdown(rs.getInt("idBreakdown")
								),
						true
						);
		Timestamp timestamp = rs.getTimestamp("creationDate");
		Date date = null;
		if (timestamp != null)
			date = new Date(timestamp.getTime());
		WorkOrder rWorkOrder = new WorkOrder(
				br, 
				rs.getInt("severity"), 
				date, 
				rs.getString("others"), 
				String.valueOf(rs.getInt("typeMaintenance")));
		if(group != null){
			Repair r = new Repair();
			r.setGroup(group);
			rWorkOrder.setRepair(r);
		}
		rWorkOrder.setRepair(new DBRepair().getPendingRepairsFromGroup(rWorkOrder));
		System.out.println(rWorkOrder); // TODO
		return rWorkOrder;
	}
}
