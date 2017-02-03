package db;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.WorkOrder;

public class DBTools extends DBConn{

	public HashMap<Integer, String> getToolsFromRepair(String name) throws Exception{
		HashMap<Integer, String> rTools = new HashMap<>();
		this.connect();
		String sub = "SELECT id FROM tools WHERE LOWER(name) LIKE LOWER('"+name+"')";
		sql = "SELECT name FROM tools WHERE id = ("+sub+");";
		this.close();
		return rTools;
	}
	
	public int insertTootls(WorkOrder workOrder) throws Exception{//TODO cambiar tools de arrayList a hashMap?
		int rowsInserted = 0;
		HashMap<Integer, String> tools = workOrder.getRepair().getTools();
		if(tools != null){
		int id = workOrder.getId();
		int idGroup = workOrder.getRepair().getGroup().getId();
		Date date = workOrder.getRepair().getDate();
		String fDate = format.format(date);
		this.connect();
		for (Map.Entry<Integer, String> tool : tools.entrySet()) {
			try{
				sql = "INSERT INTO repairTools(codBreakdown,idGroup,repairDate, idTool) "
						+ "VALUES("+id+","+idGroup+",'"+fDate+"',"+tool.getKey()+") ";
				stmt.executeUpdate(sql);
				rowsInserted++;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		this.close();
		}
		
		return rowsInserted;
	}

	public HashMap<Integer, String> getToolsFromRepair(int id, String group, Date date) throws Exception {
		HashMap<Integer, String> rTools = new HashMap<>();
		this.connect();
		String sub = "SELECT idTool FROM repairTools "
				+ "WHERE codBreakdown = "+id+" "
				+ "AND LOWER(idGroup) LIKE LOWER('"+group+"')";//TODO date
		sql = "SELECT * FROM tools WHERE idTools = ("+sub+");";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rTools.put(rs.getInt("idTools"), rs.getString("name"));
		}
		if(rTools.size() == 0) rTools = null;
		this.close();
		return rTools;
	}
}
