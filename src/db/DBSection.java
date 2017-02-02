package db;

import model.Section;

public class DBSection extends NewDBManager {

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
	
	public Section getSection(Section section)throws Exception{
		return getSection(section,true);
	}
	
}
