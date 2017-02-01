package db;

import java.sql.SQLException;
import java.util.ArrayList;

public class DBTools extends NewDBManager{

	public ArrayList<String> getToolsFromRepair(String name) throws Exception{
		ArrayList<String> rTools = new ArrayList<>();
		this.connect();
		String sub = "SELECT id FROM tools WHERE LOWER(name) LIKE LOWER('"+name+"')";
		sql = "SELECT name FROM tools WHERE id = ("+sub+");";
		this.close();
		return rTools;
	}
}
