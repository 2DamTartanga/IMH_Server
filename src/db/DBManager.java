package db;


import java.util.ArrayList;

import com.tartanga.dam.imhandroid.model.Breakdown;
import com.tartanga.dam.imhandroid.model.Group;
import com.tartanga.dam.imhandroid.model.Machine;
import com.tartanga.dam.imhandroid.model.Section;
import com.tartanga.dam.imhandroid.model.User;
import com.tartanga.dam.imhandroid.model.WorkOrder;

import interfaces.Database;


public class DBManager implements Database{
	
	private DBBreakdown dbBreakdown=new DBBreakdown();
	private DBGroup dbGroup=new DBGroup();
	private DBMachine dbMachine=new DBMachine();
	private DBRepair dbRepair=new DBRepair();
	private DBSection dbSection=new DBSection();
	private DBUser dbUser=new DBUser();
	private DBWorkOrder dbWorkOrder=new DBWorkOrder();
	
	
	
	public User login(User user) throws Exception {
		return new DBUser().login(user);//TODO workorders
	}

	public boolean addBreakdown(Breakdown breakdown) throws Exception{
		return dbBreakdown.addBreakdown(breakdown); 
	}

	public Machine getMachine(Machine machine) throws Exception{
		return dbMachine.getMachine(machine);
	}
	@Override
	public Group getGroup(Group group) throws Exception {
		return dbGroup.getGroup(group);//TODO workOrders
	}

	@Override
	public Breakdown getBreakdown(Breakdown breakdown) throws Exception {
		return dbBreakdown.getBreakdown(breakdown);
	}

	@Override
	public boolean addRepair(WorkOrder workOrder) throws Exception {
		return dbRepair.addRepair(workOrder);//TODO tools
	}

	@Override
	public WorkOrder getRepair(WorkOrder workOrder) throws Exception {
		return dbRepair.getRepairs(workOrder);
	}

	@Override
	public User getUser(User user) throws Exception {
		return dbUser.getUser(user);
	}

	@Override
	public WorkOrder getWorkOrder(WorkOrder order) throws Exception {
		return dbWorkOrder.getWorkOrder(order);
	}

	@Override
	public Section getLocalization(Section localization) throws Exception {
		return dbSection.getSection(localization);
	}

	@Override
	public ArrayList<WorkOrder> getWorkOrdersFromGroup(Group group) throws Exception {
		return dbWorkOrder.getPendingWorkOrdersFromGroup(group);
	}

	@Override
	public ArrayList<Section> getSections() throws Exception {
		return dbSection.getSections();
	}

	
	



	

	
}
