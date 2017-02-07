package db;

import java.util.ArrayList;

import com.tartanga.dam.imhandroid.model.Machine;
import com.tartanga.dam.imhandroid.model.Section;

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
	
	public ArrayList<Machine> getMachineTypesFromSection(Section sec) throws Exception {
		ArrayList<Machine> machines = new ArrayList<>();
		this.connect();
		sql = "SELECT DISTINCT(machine) FROM models INNER JOIN machines USING(model) WHERE idSection = " + sec.getId();
		stmt.executeQuery(sql);
		while(rs.next()){
			Machine m = new Machine();
			m.setMachineFamilly(rs.getString(0));
			machines.add(m);
		}
		this.close();
		return machines;
	}
	
	public ArrayList<Machine> getMachinesFromTypeAndSection(Section sec) throws Exception {
		ArrayList<Machine> machines = new ArrayList<>();
		this.connect();
		sql = "SELECT *"
				+ "FROM machines m INNER JOIN models USING(model) "
				+ "WHERE m.idSection = " + sec.getId();
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			Machine m = getMachineFromResultSet();
			machines.add(m);
		}
		this.close();
		return machines;
	}
	
	private Machine getMachineFromResultSet() throws Exception{
		Machine mach1=new Machine();
		mach1.setId(rs.getString("codMachine"));
		mach1.setDimmensions(rs.getString("dimensions"));
		mach1.setElectricConnection(rs.getString("electricConnection"));
		mach1.setFileSearch(rs.getString("fileSearch"));
		mach1.setHydraulicConnection(rs.getString("hydraulicSystem"));
		mach1.setImportance(rs.getInt("importance"));
		mach1.setMachineFamilly(rs.getString("machine"));
		mach1.setManufacturer(rs.getString("models.manufacturer"));
		mach1.setModel(rs.getString("model"));
		mach1.setPneumaticConnection(rs.getString("pneumaticConnection"));
		mach1.setPowerSource(rs.getString("powerSource"));
		mach1.setResponsable(rs.getString("responsable"));
		mach1.setSerialNumber(rs.getString("serialNumber"));
		mach1.setStatus(rs.getString("status").charAt(0));
		mach1.setTelephone(rs.getString("telephone"));
		mach1.setTypeOfOil(rs.getString("typeOil"));
		mach1.setWeight(rs.getString("weight"));
		mach1.setWorkingPressure(rs.getString("workingPressure"));
		mach1.setYear(rs.getString("year"));
		return mach1;
	}
	
}
