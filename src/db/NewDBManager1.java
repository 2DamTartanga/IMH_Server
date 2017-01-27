package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import clases.*;


public class NewDBManager1{

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String sql;
	private SimpleDateFormat format;
	
	public NewDBManager1(){
		format = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	/**
	 * Abre la conexion
	 */
	private void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdaimh","root","");//TODO esto!
			stmt = con.createStatement();
			sql = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Cierra la conexion
	 * 
	 * @throws SQLException Excepcion sql
	 */
	private void close() throws SQLException {
		stmt.close();
		if(rs != null) rs.close();
		con.close();
		sql = "";
	}
	
	public boolean addIssue(Issue issue) throws Exception {
		//TODO
		boolean ok;
		boolean isOther = issue.getReporter().getSurName() == null;
		String name = (isOther)?issue.getReporter().getUserName() : issue.getReporter().getName();
		String failureType = issue.getFailureType();
		String machineCode =  issue.getMachine().getId();
		String description = issue.getDescription();
		int id = getLastId();
		this.connect();

		sql = "INSERT INTO breakdowns(codBreakdown,date,reporter," + " failureType, description, codMachine, equipmentAvaiable	, subject) "
				+ "VALUES('"+id+"', NOW(),'" + name + "','" + failureType + "','" + description + "','" + machineCode + "','1','TODO');";
		ok = stmt.executeUpdate(sql) == 1;
		
		this.close();
		return ok;
	}

	private int getLastId() throws Exception {
		int id = 0;
		this.connect();
		sql = "SELECT MAX(codBreakdown) FROM breakdowns;";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			id = rs.getInt(1);
		}
		id++;
		this.close();
		return id;
	}

	public boolean addRepair(WorkOrder workOrder) throws Exception {
		// TODO 
		//TODO pillar la repair mas nueva
		Repair repair = workOrder.getRepair().get(0);
		String workOrderId = workOrder.getId();
		//String repairDate = format.format(repair.getFinishDate());//TODO
		float timeSpent = repair.getTimeSpent();
		String failureLocalization = repair.getFailureLocalization();
		boolean failureRepaired = repair.isSolved();
		String replacements = repair.getReplacements();
		String tools = repair.getTools();
		String repairProcess = repair.getRepairProcess();
		int availabilityAfterRepair = 1;
		boolean ok;
		this.connect();
		
		sql = "INSERT INTO repairs("
				+ "codBreakdown,"
				+ "idGroup,"
				+ "repairDate,"
				+ "time,"
				+ "idLocalization,"
				+ "isRepaired,"
				+ "replacements,"
				+ "tools,"
				+ "repairProcess,"
				+ "avaiabilityAfter)"
				+ " VALUES("
				+ ""+workOrderId+","
				+ "'1',"//TODO
				+ "NOW(),"
				+ ""+timeSpent+","
				+ "'"+failureLocalization+"',"
				+ ""+failureRepaired+","
				+ "'"+replacements+"',"
				+ "'"+tools+"',"
				+ "'"+repairProcess+"',"
				+ ""+availabilityAfterRepair+""
				+ ");";
		
		ok = stmt.executeUpdate(sql) == 1;
		this.close();
		return ok;
	}
/*
	public TechnicianGroup getGroup(TechnicianGroup group) throws Exception {
		//TODO
		TechnicianGroup returnGroup = null;
		ArrayList<User> users;
		String groupId = group.getId();
		char role = '.';
		this.connect();
		sql = "SELECT groupId, role FROM groups WHERE groupId = "+groupId+";";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			role = rs.getString("role").charAt(0);
		}
		this.close();
		if(group != null){
			users = getUsersFromGroup(group);
			TechnicianGroup tg = new TechnicianGroup();
			tg.setId(groupId);
			tg.setTechnicians(users);
			tg.setWorkOrders(new ArrayList<WorkOrder>());
			returnGroup = tg;
		}
		return returnGroup;
	}

	public Issue getIssue(Issue breakdown) throws Exception {
		int id = 1;
		Issue returnIssue = null;;
		String date = null;
		User reporter = null;
		String reporterUsername = null;
		String username = null;
		String failureType = null;
		String subject = null;
		String description = null;
		MachineAndroid machine = null;
		String machineCode = null;
		int equipmentAvailable = -1;
		boolean ok;
		this.connect();
		sql = "SELECT * FROM breakdowns WHERE id = "+id+";";
		rs = stmt.executeQuery(sql);
		if(ok = rs.next()){
			date = rs.getString("date");
			reporterUsername = rs.getString("reporter");
			username = rs.getString("username");
			failureType = rs.getString("failureType");
			subject = rs.getString("subject");
			description = rs.getString("description");
			machineCode = rs.getString("machine");
			equipmentAvailable = rs.getInt("equipmentAvailable");
		}
		this.close();
		if(ok){
			User user = new User();
			user.setUserName(reporterUsername);
			reporter = getUser(user);
			if(reporter.getName() == null || reporter.getName().isEmpty()){
				reporter.setName(username);
			}
			MachineAndroid am = new MachineAndroid();
			am.setId(machineCode);
			machine = getMachine(am);
			Issue is = new Issue();
			is.setDate(date);
			is.setDescription(description);
			is.setFailureType(failureType);
			is.setMachine(machine);
			is.setReporter(reporter);
			returnIssue =is;
		}
		return returnIssue;
	}

	public Localization getLocalization(Localization localization) throws Exception {
		// TODO 
		Localization returnLocalization = null;
		ArrayList<Machine> machines;
		int id = localization.getId();
		this.connect();
		sql = "SELECT * FROM localizations WHERE id = "+id+";";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			returnLocalization = new Localization(
					rs.getInt("id"), 
					rs.getString("name_"+language));
		}
		this.close();
		if(returnLocalization != null){
			machines = getLocalizationMachines(localization);
			returnLocalization.setMachines(machines);
		}
		return returnLocalization;
	}

	private ArrayList<Machine> getLocalizationMachines(Localization localization) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
}
