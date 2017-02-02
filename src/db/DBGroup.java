package db;

import model.Group;

public class DBGroup extends NewDBManager {

	public Group getGroup(Group group, boolean needsUsers, boolean needsRepairs) throws Exception{
		Group rGroup = new Group(group.getId());
		if(needsUsers){
			DBUser dbUser = new DBUser();
			rGroup.setUsers(dbUser.getUsersFromGroup(rGroup));
		}
		if(needsRepairs){
			DBWorkOrder dbWorkOrder = new DBWorkOrder();
			rGroup.setWorkOrders(dbWorkOrder.getWorkOrdersFromGroup(rGroup));
		}
		return rGroup;
	}
	
	public Group getGroup(Group group) throws Exception{
		return this.getGroup(group, true, true);
	}
	
	
	
}
