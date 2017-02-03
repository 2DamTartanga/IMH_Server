package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import interfaces.Database;
import model.Breakdown;
import model.Group;
import model.Machine;
import model.Repair;
import model.Section;
import model.User;
import model.WorkOrder;


public class NewDBManager implements Database{
	
	private DBBrekadown dbBreakdown=new DBBrekadown();
	private DBGroup dbGroup=new DBGroup();
	private DBMachine dbMachine=new DBMachine();
	private DBRepair dbRepair=new DBRepair();
	private DBSection dbSection=new DBSection();
	private DBUser dbUser=new DBUser();
	private DBWorkOrder dbWorkOrder=new DBWorkOrder();
	
	
	
	public User login(User user) throws Exception {
		User loggedUser = new DBUser().login(user);
		return loggedUser;
	}

	public boolean addBreakdown(Breakdown breakdown) throws Exception{
		return dbBreakdown.addBreakdown(breakdown); 
	}

	public Machine getMachine(Machine machine) throws Exception{
		return dbMachine.getMachine(machine);
	}
	@Override
	public Group getGroup(Group group) throws Exception {
		return dbGroup.getGroup(group);
	}

	@Override
	public Breakdown getBreakdown(Breakdown breakdown) throws Exception {
		return dbBreakdown.getBreakdown(breakdown);
	}

	@Override
	public boolean addRepair(WorkOrder workOrder) throws Exception {
		return false;
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

	



	

	
}
