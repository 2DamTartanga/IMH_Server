package control;


import db.DBManager;
import interfaces.Database;
import model.Group;
import model.Issue;
import model.Machine;
import model.User;
import model.WorkOrder;
import model.WorkZone;

public class Manager implements Database {

	private static Manager singleton;
	private DBManager dbm;
	
	private Manager(){
		dbm = new DBManager();
	}
	
	public Manager getInstance(){
		if(singleton == null){
			singleton = new Manager();
		}
		return singleton;
	}

	@Override
	public User login(User user) throws Exception {
		return dbm.login(user);
	}

	@Override
	public boolean addGroup(Group group) throws Exception {
		return dbm.addGroup(group);
	}

	@Override
	public boolean modGroup(Group group) throws Exception {
		return dbm.modGroup(group);
	}

	@Override
	public boolean delGroup(Group group) throws Exception {
		return dbm.delGroup(group);
	}

	@Override
	public boolean addIssue(Issue issue) throws Exception {
		return dbm.addIssue(issue);
	}

	@Override
	public boolean modIssue(Issue issue) throws Exception {
		return dbm.modIssue(issue);
	}

	@Override
	public boolean delIssue(Issue issue) throws Exception {
		return dbm.delIssue(issue);
	}

	@Override
	public boolean addMachine(Machine machine) throws Exception {
		// TODO Auto-generated method stub
		return dbm.addMachine(machine);
	}

	@Override
	public boolean modMachine(Machine machine) throws Exception {
		return dbm.modMachine(machine);
	}

	@Override
	public boolean delMachine(Machine machine) throws Exception {
		return dbm.delMachine(machine);
	}

	@Override
	public boolean addRepair(WorkOrder workOrder) throws Exception {
		return dbm.addRepair(workOrder);
	}

	@Override
	public boolean modRepair(WorkOrder workOrder) throws Exception {
		return dbm.modRepair(workOrder);
	}

	@Override
	public boolean delRepair(WorkOrder workOrder) throws Exception {
		return dbm.delRepair(workOrder);
	}

	@Override
	public boolean addUser(User user) throws Exception {
		return dbm.addUser(user);
	}

	@Override
	public boolean modUser(User user) throws Exception {
		return dbm.modUser(user);
	}

	@Override
	public boolean delUser(User user) throws Exception {
		return dbm.delUser(user);
	}

	@Override
	public boolean addWorkOrder(WorkOrder order) throws Exception {
		return dbm.addWorkOrder(order);
	}

	@Override
	public boolean modWorkOrder(WorkOrder order) throws Exception {
		return dbm.modWorkOrder(order);
	}

	@Override
	public boolean delWorkOrder(WorkOrder order) throws Exception {
		return dbm.delWorkOrder(order);
	}

	@Override
	public boolean addWorkZone(WorkZone workZone) throws Exception {
		return dbm.addWorkZone(workZone);
	}

	@Override
	public boolean modWorkZone(WorkZone workZone) throws Exception {
		return dbm.modWorkZone(workZone);
	}

	@Override
	public boolean delWorkZone(WorkZone workZone) throws Exception {
		return dbm.delWorkZone(workZone);
	}
	
	
	
	
	
}
