package db;

import java.util.ArrayList;

import model.Breakdown;
import model.Machine;
import model.Section;

public class DBMachine extends DBConn {

	public Machine getMachine(Machine machine) throws Exception{
		Machine mach1=new Machine();
		mach1.setId(machine.getId());
		Section section=new Section();
		this.connect();
		sql="SELECT * FROM machines "+
		"INNER JOIN sections USING(idSection) "+
		"INNER JOIN models USING (model) "+
		"INNER JOIN manufacturers ON(models.manufacturer=manufacturers.id) "+
		"WHERE codMachine='"+machine.getId()+"';";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			mach1=getMachineFromResultSet();
			section.setId(rs.getString("idSection"));
			section.setName(rs.getString("nameSection"));
			//machine.setBreakdowns(new DBBrekadown().getBreakdownsFromMachine(mach1));
		}
		mach1.setSection(section);
		this.close();
		return mach1;
	}
	
	public ArrayList<Machine> getMachinesFromSection(Section section) throws Exception{
		ArrayList<Machine> machines=new ArrayList<>();
		Machine m=new Machine();
		this.connect();
		sql="SELECT * FROM machines"+
		"INNER JOIN sections USING(idSection)"+
		"INNER JOIN models USING (model)"+
		"INNER JOIN manufacturers ON(models.manufacturer=manufacturers.id)"+
		"WHERE idSection='"+section.getId()+"';";
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			m=getMachineFromResultSet();
			m.setId(rs.getString(1));
			machines.add(m);
		}
		this.close();
		return machines;
	}
	private Machine getMachineFromResultSet() throws Exception{
		Machine mach1=new Machine();
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
