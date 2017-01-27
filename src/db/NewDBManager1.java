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

	public TechnicianGroup getGroup(TechnicianGroup group) throws Exception {
		//TODO
		TechnicianGroup returnGroup = null;
		ArrayList<User> users;
		String groupId = group.getId();
		char role = '.';
		this.connect();
		sql = "SELECT id, role FROM groups WHERE id LIKE '"+groupId+"' AND UPPER(role) LIKE 'T';";
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

	private ArrayList<User> getUsersFromGroup(TechnicianGroup group) throws Exception {
		ArrayList<User> users = new ArrayList<>();
		String id = group.getId();
		this.connect();
		String sub = "SELECT id FROM groups WHERE id LIKE '"+id+"'";
		sql = "SELECT * "
				+ "FROM users JOIN others USING(username) "
				+ "JOIN maintenance USING(username)"
				+ "WHERE maintenance.idGroup LIKE ("+sub+") ;";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			User user = new User();
			user.setCourse(rs.getString("course"));
			//user.setCycle(rs.getString("cycle"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setSurName(rs.getString("surname"));
			user.setUserName(rs.getString("username"));
			users.add(user);
		}
		if(users.size() == 0) users = null;
		this.close();
		return users;
	}

	public Issue getIssue(Issue issue) throws Exception {
		int id = 3;//TODO
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
		sql = "SELECT * FROM breakdowns WHERE codBreakdown = "+id+";";
		rs = stmt.executeQuery(sql);
		if(ok = rs.next()){
			date = rs.getString("date");
			reporterUsername = rs.getString("reporter");
			//username = rs.getString("username");//TODO
			failureType = rs.getString("failureType");
			subject = rs.getString("subject");
			description = rs.getString("description");
			machineCode = rs.getString("codMachine");
			equipmentAvailable = rs.getInt("equipmentAvaiable");
		}
		this.close();
		if(ok){
			User user = new User();
			user.setUserName(reporterUsername);
			
			//reporter = getUser(user);//Descomentar cuando se junte con la otra mitad
			if(reporter != null){
				if(reporter.getName() == null || reporter.getName().isEmpty()){
					reporter.setName(username);
				}
			}
			MachineAndroid am = new MachineAndroid();
			am.setId(machineCode);
			//machine = getMachine(am);//Descomentar cuando se junte con la otra mitad
			Issue is = new Issue();
			is.setDate(date);
			is.setDescription(description);
			is.setFailureType(failureType);
			is.setMachine(machine);
			is.setReporter(reporter);
			is.setSeverity(String.valueOf(equipmentAvailable));
			returnIssue =is;
		}
		return returnIssue;
	}

	public WorkZone getWorkZone(WorkZone workZone) throws Exception {
		// TODO 
		WorkZone returnWorkZone = null;
		ArrayList<MachineAndroid> machines;
		String id = workZone.getId();
		this.connect();
		sql = "SELECT * FROM sections WHERE UPPEr(idSection) LIKE UPPER('"+id+"');";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			returnWorkZone = new WorkZone();
			returnWorkZone.setId(rs.getString("idSection"));
			returnWorkZone.setName("nameSection");
		}
		this.close();
		if(returnWorkZone != null){
			machines = getWorkZoneMachines(workZone);
			returnWorkZone.setMachines(machines);
		}
		return returnWorkZone;
	}

	private ArrayList<MachineAndroid> getWorkZoneMachines(WorkZone workZone) throws Exception {
		ArrayList<MachineAndroid> machines = new ArrayList<>();
		MachineAndroid machine = null;
		String id = workZone.getId();
		this.connect();
		String sub = "SELECT idSection FROM sections WHERE UPPER(idSection) LIKE UPPER('"+id+"')";
		sql = "SELECT * FROM machines WHERE idSection LIKE ("+sub+");";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			machine = new MachineAndroid();
			machine.setId(rs.getString("codMachine"));
			machine.setState(Integer.parseInt(rs.getString("status")));
			machines.add(machine);
		}
		this.close();
		if(machines.size() == 0) machines = null;
		return machines;
	}

	
}
