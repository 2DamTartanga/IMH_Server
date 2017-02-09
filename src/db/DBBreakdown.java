package db;

import java.util.ArrayList;

import com.tartanga.dam.imhandroid.model.Breakdown;
import com.tartanga.dam.imhandroid.model.Machine;
import com.tartanga.dam.imhandroid.model.User;

public class DBBreakdown extends DBConn {

	public boolean addBreakdown(Breakdown breakdown) throws Exception{
		this.connect();
		sql="INSERT INTO breakdowns(date,codMachine,reporter,failureType,description,equipmentAvailable,subject) "+
		"VALUES('"+format.format(breakdown.getDate())+"','"+breakdown.getMachine().getId()+"','"+breakdown.getReporter().getUsername()+
		"','"+breakdown.getFailureType()+"','"+breakdown.getDescription()+"','"+breakdown.getEquipmentAvailable()+
		"','"+breakdown.getSubject()+"')";
		System.out.println(sql);
		boolean ok = stmt.executeUpdate(sql) == 1;
		this.close();
		return ok;
	}
	
	public Breakdown getBreakdown(Breakdown breakdown, boolean needsMachine) throws Exception{
		Breakdown break1=new Breakdown();
		break1.setId(breakdown.getId());
		User us1=new User();
		this.connect();
		sql="SELECT * FROM breakdowns "+
		"WHERE codBreakdown ="+breakdown.getId()+";";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			break1.setDate(rs.getDate("date"));
			break1.setDescription(rs.getString("description"));
			break1.setEquipmentAvailable(rs.getString("equipmentAvailable"));
			break1.setFailureType(rs.getString("failureType"));
			break1.setSubject(rs.getString("subject"));
			us1.setUsername(rs.getString("reporter"));
			DBUser dbU=new DBUser();
			us1=dbU.getUser(us1);
			break1.setReporter(us1);
			Machine mach1=new Machine();
			mach1.setId(rs.getString("codMachine"));
			DBMachine dbM=new DBMachine();
			mach1=dbM.getMachine(mach1);
			break1.setMachine(mach1);
		}
		this.close();
		return break1;
	}
	
	public Breakdown getBreakdown(Breakdown breakdown) throws Exception{
		return this.getBreakdown(breakdown, false);
	}
	public ArrayList<Breakdown> getBreakdownsFromMachine(Machine machine) throws Exception{
		ArrayList<Breakdown> breakdowns= new ArrayList<>();
		Breakdown break1=null;
		this.connect();
		sql="SELECT * FROM breakdowns "+
		"WHERE codMachine = '"+machine.getId()+"';";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			break1=new Breakdown();
			break1.setId(rs.getInt("codBreakdown"));
			break1.setDate(rs.getDate("date"));
			break1.setDescription(rs.getString("description"));
			break1.setEquipmentAvailable(rs.getString("equipmentAvailable"));
			break1.setFailureType(rs.getString("failureType"));
			break1.setSubject(rs.getString("subject"));
			DBUser dbU=new DBUser();
			User us1=dbU.getUser(new User(rs.getString("reporter")));
			break1.setReporter(us1);
			breakdowns.add(break1);
		}
		this.close();
		return breakdowns;
	}
	public ArrayList<Breakdown> getOpenBreakdownsFromMachine(Machine machine) throws Exception{
		ArrayList<Breakdown> breakdowns= new ArrayList<>();
		Breakdown break1=null;
		this.connect();
		sql="SELECT * FROM breakdowns "+
		"INNER JOIN repairs USING(codBreakdown)"+
		"WHERE codMachine = '"+machine.getId()+
		"AND isRrpaired = false';";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			break1=new Breakdown();
			break1.setId(rs.getInt("codBreakdown"));
			break1.setDate(rs.getDate("date"));
			break1.setDescription(rs.getString("description"));
			break1.setEquipmentAvailable(rs.getString("equipmentAvailable"));
			break1.setFailureType(rs.getString("failureType"));
			break1.setSubject(rs.getString("subject"));
			DBUser dbU=new DBUser();
			User us1=dbU.getUser(new User(rs.getString("reporter")));
			break1.setReporter(us1);
			breakdowns.add(break1);
		}
		this.close();
		return breakdowns;
	}
	
}
