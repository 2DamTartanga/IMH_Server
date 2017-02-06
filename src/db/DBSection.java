package db;

import java.util.ArrayList;

import model.Section;

public class DBSection extends DBConn {

	public Section getSection(Section section, boolean needsMachines)throws Exception{
		Section sect1=new Section();
		sect1.setId(section.getId());
		this.connect();
		sql= "SELECT nameSection FROM sections WHERE lower(idSection) LIKE lower('"+section.getId()+"');";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			sect1.setName(rs.getString(1));
		}
		if(needsMachines){
			DBMachine dbM=new DBMachine();
			sect1.setMachines(dbM.getMachinesFromSection(sect1));
		}
		this.close();
		return sect1;
	}
	
	public ArrayList<Section> getSections() throws Exception {
		ArrayList<Section> sections = new ArrayList<>();
		this.connect();
		sql = "SELECT * FROM sections";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			Section sec = new Section();
			sec.setId(rs.getString(0));
			sec.setName(rs.getString(1));
			sec.setMachines(new DBMachine().getMachinesFromSection(sec));
			sections.add(sec);
		}
		this.close();
		return sections;
	}
	
	public Section getSection(Section section)throws Exception{
		return getSection(section,true);
	}
	
	public int returnMachinesByStatus(Section section, String status) throws Exception{
		int n=0;
		this.connect();
		sql="SELECT COUNT * FROM MACHINES WHERE lower(status) LIKE lower('"+status+"');";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			n=rs.getInt(1);
		}
		this.close();
		return n;
	}
	
}
