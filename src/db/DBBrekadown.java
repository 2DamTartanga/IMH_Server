package db;

import model.Breakdown;
import model.Machine;
import model.User;

public class DBBrekadown extends DBConn {

	public boolean addBreakdown(Breakdown breakdown) throws Exception{
		this.connect();
		sql="INSERT INTO breakdowns(date,codMachine,reporter,failureType,description,equipmentAvailable,subject)"+
		"VALUES('"+breakdown.getDate()+"','"+breakdown.getMachine().getId()+"','"+breakdown.getReporter().getUsername()+
		"','"+breakdown.getFailureType()+"','"+breakdown.getDescription()+"','"+breakdown.getEquipmentAvailable()+
		"','"+breakdown.getSubject()+"')";
		boolean ok = stmt.executeUpdate(sql) == 1;
		this.close();
		return ok;
	}
	
	public Breakdown getBreakdown(Breakdown breakdown, boolean needsMachine) throws Exception{
		Breakdown break1=new Breakdown();
		break1.setId(breakdown.getId());
		User us1=new User();
		this.connect();
		sql="SELECT * FROM breakdowns"+
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
			if(needsMachine){
				Machine mach1=new Machine();
				mach1.setId(rs.getString("codMachine"));
				DBMachine dbM=new DBMachine();
				mach1=dbM.getMachine(mach1);
				break1.setMachine(mach1);
			}
		}
		this.close();
		return break1;
	}
	
	public Breakdown getBreakdown(Breakdown breakdown) throws Exception{
		return this.getBreakdown(breakdown, false);
	}
}
