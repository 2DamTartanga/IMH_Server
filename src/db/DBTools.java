package db;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DBTools extends NewDBManager{

	public HashMap<Integer, String> getToolsFromRepair(String name) throws Exception{
		HashMap<Integer, String> rTools = new HashMap<>();
		this.connect();
		String sub = "SELECT id FROM tools WHERE LOWER(name) LIKE LOWER('"+name+"')";
		sql = "SELECT name FROM tools WHERE id = ("+sub+");";
		this.close();
		return rTools;
	}
	
	public int insertTootls(HashMap<Integer, String> tools) throws Exception{//TODO cambiar tools de arrayList a hashMap?
		int rowsInserted = 0;
		this.connect();
		sql = "INSERT INTO ";
		
		
		this.close();
		
		
		return rowsInserted;
	}

	public HashMap<Integer, String> getToolsFromRepair(int id, String group, Date date) throws Exception {
		HashMap<Integer, String> rTools = new HashMap<>();
		this.connect();
		String sub = "SELECT idTool FROM repairTools "
				+ "WHERE codBreakdown = "+id+" "
				+ "AND LOWER(idGroup) LIKE LOWER('"+group+"');";//TODO date
		sql = "SELECT * FROM tools WHERE idTools = ("+sub+")";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rTools.put(rs.getInt("idTools"), rs.getString("name"));
		}
		if(rTools.size() == 0) rTools = null;
		this.close();
		return rTools;
	}
}
