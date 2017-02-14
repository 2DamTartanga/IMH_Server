package db;

import java.sql.Timestamp;
import java.util.Date;

import com.tartanga.dam.imhandroid.model.Group;
import com.tartanga.dam.imhandroid.model.Repair;
import com.tartanga.dam.imhandroid.model.WorkOrder;

public class DBRepair extends DBConn {
	
	 //static Logger log = Logger.getLogger(DBRepair.class.getName());
	
	public WorkOrder getRepairs(WorkOrder workOrder, boolean needsGroup) throws Exception{
		Repair r = null;
		int id = workOrder.getId();
		int idGroup = workOrder.getRepair().getGroup().getId();
		this.connect();
		sql = "SELECT * FROM repairs "
			+ "WHERE codBreakdown = "+id+" "
			+ "AND idGroup LIKE "+idGroup+";";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			r = getRepairFromResultSet(needsGroup);
			//r.setTools(new DBTools().getToolsFromRepair(workOrder));//TODO ESTO!!
		}
		workOrder.setRepair(r);
		this.close();
		return workOrder;
	}
	
	public WorkOrder getRepairs(WorkOrder workOrder) throws Exception{
		return this.getRepairs(workOrder,true);
	}
	
	public boolean addRepair(WorkOrder workOrder) throws Exception{//TODO acabar
		int result;
		//TODO dani
		this.connect();
		Repair r = workOrder.getRepair();
		int id = workOrder.getId();
		int group = r.getGroup().getId();
		Date repairDate = r.getDate();
		float time = r.getTime();
		String availabilityAfterRepair = r.getAvailabilityAfterRepair();
		String repairProcess = r.getRepairProcess();
		int idLocalization = r.getFailureLocalization();
		boolean isRepaired = r.isRepaired();
		String replacements = r.getReplacements();
		Date assignationDate = r.getAsignationDate();
		
		sql = "INSERT INTO repairs ("
				+ "codBreakdown, "
				+ "idGroup, "
				+ "repairDate, "
				+ "time, "
				+ "availabilityAfter, "
				+ "repairProcess, "
				+ "idLocalization, "
				+ "isRepaired, "
				+ "replacements, "
				+ "assignationDate "
				+ ")VALUES("
				+ id +", "
				+ group+", "
				+ "'"+ format.format(repairDate) +"', "
				+ time +", "
				+ "'"+ availabilityAfterRepair +"', "
				+ "'"+ repairProcess +"', "
				+ idLocalization +", "
				+ isRepaired +", "
				+ "'"+ replacements +"', "
				+"'"+ format.format(assignationDate) +"' "
				+ ")";
		/*sql = "UPDATE repairs SET "
				+ "repairDate = '"+format.format(r.getDate())+"', "
				+ "time = "+r.getTime()+", "
				+ "availabilityAfter = '"+r.getAvailabilityAfterRepair().charAt(0)+"', "
				+ "repairProcess = '"+r.getRepairProcess()+"', "
				+ "idLocalization = "+r.getFailureLocalization()+", "
				+ "isRepaired = "+r.isRepaired()+", "
				+ "replacements = '"+r.getReplacements()+"' "
				+ " "
				+ "WHERE codBreakdown = "+workOrder.getId()+" "
				+ "AND idGroup = "+r.getGroup().getId()+" ;";*/
		sql = "INSERT INTO ";
		System.out.println(sql);
		result = stmt.executeUpdate(sql);
		new DBTools().insertTootls(workOrder);
		
		this.close();
		
		return result == 1;
	}
	
	public Repair getRepairsFromGroup(Group group) throws Exception{
		Repair rRepair = null;
		
		this.connect();
		sql = "SELECT * FROM repairs "
				+ "WHERE idGroup='"
				+ group.getId() + "';";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rRepair = getRepairFromResultSet(false);
		}
		return rRepair;
	}
	
	public Repair getRepairsFromWorkOrder(WorkOrder workOrder) throws Exception{
		return getRepairs(workOrder,false).getRepair();
	}
	
	private Repair getRepairFromResultSet(boolean needsGroup) throws Exception{
		Repair rRepair = null;
		Timestamp timestamp = rs.getTimestamp("repairDate");
		Date date = null;
		if (timestamp != null)
			date = new Date(timestamp.getTime());
		
		rRepair = new Repair(
				date,
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
				date));
		return rRepair;
	}

	public Repair getPendingRepairsFromGroup(WorkOrder workOrder) throws Exception {
		Repair rRepair = null;
		int id = workOrder.getId();
		int group = workOrder.getRepair().getGroup().getId();
		this.connect();
		sql = "SELECT * FROM repairs WHERE codBreakdown = "+id+" AND isRepaired = 0 AND idGroup = "+group+";";
		System.out.println(sql); // TODO
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rRepair = getRepairFromResultSet(false);
		}
		this.close();
		return rRepair;
	}
	
}
