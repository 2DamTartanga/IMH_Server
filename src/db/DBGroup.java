package db;

import com.tartanga.dam.imhandroid.model.Group;

public class DBGroup extends DBConn {

	public Group getGroup(Group group, boolean needsUsers, boolean needsRepairs) throws Exception{
		Group rGroup = new Group(group.getId());
		if(needsUsers){
			DBUser dbUser = new DBUser();
			rGroup.setUsers(dbUser.getUsersFromGroup(rGroup));
		}
		return rGroup;
	}
	
	public Group getGroup(Group group) throws Exception{
		return this.getGroup(group, true, false);
	}
	
	
	
}
