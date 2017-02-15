package db;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.tartanga.dam.imhandroid.model.WorkOrder;

public class DBTools extends DBConn{

	public HashMap<Integer, String> getToolsFromRepair(WorkOrder wo) throws Exception{
		HashMap<Integer, String> rTools = new HashMap<>();
		Date date = wo.getRepair().getDate();
		int idBreakdown = wo.getId();
		int idGroup = wo.getRepair().getGroup().getId();
		this.connect();
		String sub = "SELECT idTool FROM repairTools WHERE codBreakdown = "+idBreakdown+" AND idGroup = "+idGroup+" AND repairDate = DATE_FORMAT('"+format.format(date)+"','yyyy-MM-dd HH:mm:ss')  ";
		sql = "SELECT * FROM tools WHERE idTools IN ("+sub+");";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rTools.put(rs.getInt("idTools"), rs.getString("name"));
		}
		if(rTools.size() == 0)
			rTools = null;
		wo.getRepair().setTools(rTools);
		this.close();
		return rTools;
	}
	
	public int insertTootls(WorkOrder workOrder) throws Exception{
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
		String sub = "SELECT idTool "
				+ "FROM repairTools"
				+ " WHERE codBreakdown = "+id+" "
				+ "AND idGroup = "+group+" "
				+ "AND asignationDate = "
					+ "DATE_FORMAT('"+format.format(date)+"','%Y-%m-%d %T')  ";
		sql = "SELECT * FROM tools WHERE idTools IN ("+sub+");";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rTools.put(
					rs.getInt("idTools"),
					rs.getString("name")
					);
		}
		if(rTools.size() == 0) rTools = null;
		this.close();
		return rTools;
	}

	public HashMap<Integer, String> getTools() throws Exception {
		HashMap<Integer, String> rTools = new HashMap<>();
		this.connect();
		sql = "SELECT * FROM tools";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rTools.put(
					rs.getInt("idTools"),
					rs.getString("name")
					);
		}
		if(rTools.size() == 0) rTools = null;
		this.close();
		return rTools;
	}
	
}
