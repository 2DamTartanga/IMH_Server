package db;

import java.sql.SQLException;
import java.util.ArrayList;

public class DBTools extends DBConn{

	public ArrayList<String> getToolsFromRepair(String name) throws Exception{
		ArrayList<String> rTools = new ArrayList<>();
		this.connect();
		String sub = "SELECT id FROM tools WHERE LOWER(name) LIKE LOWER('"+name+"')";
		sql = "SELECT name FROM tools WHERE id = ("+sub+");";
		this.close();
		return rTools;
	}
	
	public int insertTootls(ArrayList<String> toolNames) throws Exception{//TODO cambiar tools de arrayList a hashMap?
		int rowsInserted = 0;
		ArrayList<Integer> toolIds = new ArrayList<>(); 
		this.connect();
		sql = "";
		
		
		this.close();
		
		
		return rowsInserted;
	}
}
