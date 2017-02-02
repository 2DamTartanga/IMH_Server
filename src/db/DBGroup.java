package db;

import java.sql.SQLException;

import model.Group;
import model.User;

public class DBGroup extends NewDBManager {

	public Group getGroup(Group group, boolean needsUsers, boolean needsRepairs) throws Exception{
		Group rGroup = new Group(group.getId());
		if(needsUsers){
			DBUser dbUser = new DBUser();
			rGroup.setUsers(dbUser.getUsersFromGroup(rGroup));
		}
		if(needsRepairs){
			DBRepair dbRepair = new DBRepair();
			rGroup.setRepairs(dbRepair.getRepairsFromGroup(rGroup));
		}
		
		
		return rGroup;
	}
	public Group getGroup(Group group) throws Exception{
		return this.getGroup(group, true, true);
	}
	
	
	
}
