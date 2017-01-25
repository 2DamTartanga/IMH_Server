package control;

import db.DBManager;
import interfaces.Database;
import model.Group;
import model.Issue;
import model.Machine;
import model.Message;
import model.Repair;
import model.User;
import model.WorkOrder;
import model.WorkZone;

public class Manager implements Database {

	private DBManager dbm;

	public Manager() {
		dbm = new DBManager();
	}


	public Object manageMessages(Message msg) {
		Object objectToReturn = null;

		try{
			switch (msg.getAction()) {
			case Message.ADD:
				objectToReturn = add(msg);
				break;
			case Message.MOD:
				objectToReturn = mod(msg);
				break;
			case Message.DEL:
				objectToReturn = del(msg);
				break;
			case Message.GET:
				objectToReturn = get(msg);
				break;
			case Message.LOGIN:
				objectToReturn = login( (User) msg.getContent() );
				break;
			default:
				break;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return objectToReturn;
	}

	public boolean add(Message msg) throws Exception {
		boolean resultOfTheOperation = false;
		switch (msg.getObject()) {

		case Message.USER:
			resultOfTheOperation = addUser( (User) msg.getContent());
			break;
		case Message.GROUP:
			resultOfTheOperation = addGroup( (Group) msg.getContent());
			break;
		case Message.ISSUE:
			resultOfTheOperation = addIssue( (Issue) msg.getContent());
			break;
		case Message.WORK_ORDER:
			resultOfTheOperation = addWorkOrder( (WorkOrder) msg.getContent());
			break;
		case Message.REPAIR:
			resultOfTheOperation = addRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			resultOfTheOperation = addMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			resultOfTheOperation = addWorkZone( (WorkZone) msg.getContent());
			break;
		default:
			break;
		}
		
		return resultOfTheOperation;
	}

	public boolean mod(Message msg) throws Exception {
		boolean resultOfTheOperation = false;
		switch (msg.getObject()) {

		case Message.USER:
			resultOfTheOperation = modUser( (User) msg.getContent());
			break;
		case Message.GROUP:
			resultOfTheOperation = modGroup( (Group) msg.getContent());
			break;
		case Message.ISSUE:
			resultOfTheOperation = modIssue( (Issue) msg.getContent());
			break;
		case Message.WORK_ORDER:
			resultOfTheOperation = modWorkOrder( (WorkOrder) msg.getContent());
			break;
		case Message.REPAIR:
			resultOfTheOperation = modRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			resultOfTheOperation = modMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			resultOfTheOperation = modWorkZone( (WorkZone) msg.getContent());
			break;
		default:
			break;
		}
		
		return resultOfTheOperation;
	}

	public boolean del(Message msg) throws Exception {
		boolean resultOfTheOperation = false;
		switch (msg.getObject()) {

		case Message.USER:
			resultOfTheOperation = delUser( (User) msg.getContent());
			break;
		case Message.GROUP:
			resultOfTheOperation = delGroup( (Group) msg.getContent());
			break;
		case Message.ISSUE:
			resultOfTheOperation = delIssue( (Issue) msg.getContent());
			break;
		case Message.WORK_ORDER:
			resultOfTheOperation = delWorkOrder( (WorkOrder) msg.getContent());
			break;
		case Message.REPAIR:
			resultOfTheOperation = delRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			resultOfTheOperation = delMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			resultOfTheOperation = delWorkZone( (WorkZone) msg.getContent());
			break;
		default:
			break;
		}

		return resultOfTheOperation;
	}

	public Object get(Message msg) throws Exception {
		Object resultOfTheOperation = null;
		switch (msg.getObject()) {

		case Message.USER:
			resultOfTheOperation = (User) getUser( (User) msg.getContent());
			break;
		case Message.GROUP:
			resultOfTheOperation = (Group) getGroup( (Group) msg.getContent());
			break;
		case Message.ISSUE:
			resultOfTheOperation = (Issue) getIssue( (Issue) msg.getContent());
			break;
		case Message.WORK_ORDER:
			resultOfTheOperation = (WorkOrder) getWorkOrder( (WorkOrder) msg.getContent());
			break;
		case Message.REPAIR:
			resultOfTheOperation = (Repair) getRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			resultOfTheOperation = (Machine) getMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			resultOfTheOperation = (WorkZone) getWorkZone( (WorkZone) msg.getContent());
			break;
		default:
			break;
		}
		
		return resultOfTheOperation;
	}

	public void others(Message msg) {
		
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

	@Override
	public Group getGroup(Group group) throws Exception {
		return dbm.getGroup(group);
	}

	@Override
	public Issue getIssue(Issue issue) throws Exception {
		return dbm.getIssue(issue);
	}

	@Override
	public Machine getMachine(Machine machine) throws Exception {
		return dbm.getMachine(machine);
	}

	@Override
	public Repair getRepair(WorkOrder workOrder) throws Exception {
		return dbm.getRepair(workOrder);
	}

	@Override
	public User getUser(User user) throws Exception {
		return dbm.getUser(user);
	}

	@Override
	public WorkOrder getWorkOrder(WorkOrder order) throws Exception {
		return dbm.getWorkOrder(order);
	}

	@Override
	public WorkZone getWorkZone(WorkZone workZone) throws Exception {
		return dbm.getWorkZone(workZone);
	}
}
