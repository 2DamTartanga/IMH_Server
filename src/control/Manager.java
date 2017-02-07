package control;

import java.util.ArrayList;

import com.tartanga.dam.imhandroid.model.Breakdown;
import com.tartanga.dam.imhandroid.model.Group;
import com.tartanga.dam.imhandroid.model.Machine;
import com.tartanga.dam.imhandroid.model.Message;
import com.tartanga.dam.imhandroid.model.Section;
import com.tartanga.dam.imhandroid.model.User;
import com.tartanga.dam.imhandroid.model.WorkOrder;

import db.DBManager;
import interfaces.Database;

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
			//resultOfTheOperation = addUser( (User) msg.getContent());
			break;
		case Message.GROUP:
			//resultOfTheOperation = addGroup( (Group) msg.getContent());
			break;
		case Message.BREAKDOWN:
			System.out.println((Breakdown)msg.getContent());
			resultOfTheOperation = addBreakdown( (Breakdown) msg.getContent());
			break;
		case Message.WORK_ORDER:
			//resultOfTheOperation = addWorkOrder( (WorkOrder) msg.getContent());
			break;
		case Message.REPAIR:
			resultOfTheOperation = addRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			//resultOfTheOperation = addMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			//resultOfTheOperation = addLocalization( (Localization) msg.getContent());
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
			//resultOfTheOperation = modUser( (User) msg.getContent());
			break;
		case Message.GROUP:
			//resultOfTheOperation = modGroup( (Group) msg.getContent());
			break;
		case Message.BREAKDOWN:
			//resultOfTheOperation = modBreakdown( (Breakdown) msg.getContent());
			break;
		case Message.WORK_ORDER:
			//resultOfTheOperation = modWorkOrder( (WorkOrder) msg.getContent());
			break;
		case Message.REPAIR:
			//resultOfTheOperation = modRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			//resultOfTheOperation = modMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			//resultOfTheOperation = modLocalization( (Localization) msg.getContent());
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
			//resultOfTheOperation = delUser( (User) msg.getContent());
			break;
		case Message.GROUP:
			//resultOfTheOperation = delGroup( (Group) msg.getContent());
			break;
		case Message.BREAKDOWN:
			//resultOfTheOperation = delBreakdown( (Breakdown) msg.getContent());
			break;
		case Message.WORK_ORDER:
			//resultOfTheOperation = delWorkOrder( (WorkOrder) msg.getContent());
			break;
		case Message.REPAIR:
			//resultOfTheOperation = delRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			//resultOfTheOperation = delMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			//resultOfTheOperation = delLocalization( (Localization) msg.getContent());
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
		case Message.BREAKDOWN:
			resultOfTheOperation = (Breakdown) getBreakdown( (Breakdown) msg.getContent());
			break;
		case Message.WORK_ORDER:
			if(msg.getContent() instanceof WorkOrder){
			resultOfTheOperation = (WorkOrder) getWorkOrder( (WorkOrder) msg.getContent());
			}else if(msg.getContent() instanceof Group){
				resultOfTheOperation = getWorkOrdersFromGroup((Group) msg.getContent());
			}
			break;
		case Message.REPAIR:
			resultOfTheOperation = (WorkOrder) getRepair( (WorkOrder) msg.getContent());
			break;
		case Message.MACHINE:
			resultOfTheOperation = (Machine) getMachine( (Machine) msg.getContent());
			break;
		case Message.WORK_ZONE:
			resultOfTheOperation = (Section) getLocalization( (Section) msg.getContent());
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
	public boolean addBreakdown(Breakdown breakdown) throws Exception {
		return dbm.addBreakdown(breakdown);
	}
	
	@Override
	public Group getGroup(Group group) throws Exception {
		return dbm.getGroup(group);
	}

	@Override
	public Breakdown getBreakdown(Breakdown breakdown) throws Exception {
		return dbm.getBreakdown(breakdown);
	}

	@Override
	public Machine getMachine(Machine machine) throws Exception {
		return dbm.getMachine(machine);
	}

	@Override
	public WorkOrder getRepair(WorkOrder workOrder) throws Exception {
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
	public Section getLocalization(Section localization) throws Exception {
		return dbm.getLocalization(localization);
	}

	@Override
	public ArrayList<WorkOrder> getWorkOrdersFromGroup(Group group) throws Exception {
		return dbm.getWorkOrdersFromGroup(group);
	}

	@Override
	public boolean addRepair(WorkOrder workOrder) throws Exception {
		return dbm.addRepair(workOrder);
	}
}
