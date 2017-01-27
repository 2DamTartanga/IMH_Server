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
import new_classes.*;


public class DBManager implements Database {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String sql;
	private SimpleDateFormat format;
	private String language;
	
	public DBManager(){
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * Abre la conexion
	 */
	private void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imh","root","");//TODO esto!
			stmt = con.createStatement();
			sql = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setLanguage(String language){
		this.language = language;
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
	
	/**
	 * Me la he jugado mucho
	 */
	public User login(User user) throws Exception {//TODO esto!!
		connect();
		User loggedUser = null;
		Group group = null;
		String name = user.getUsername();
		String pass = user.getPassword();
		sql = "SELECT * "
				+ "FROM users JOIN others USING(username) "
				+ "JOIN maintenance USING(username) "
				+ "JOIN groups ON(maintenance.group = groups.id) "
				+ "WHERE LOWER(username) LIKE LOWER('"+name+"') AND password LIKE '"+pass+"';";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			short groupId = rs.getShort("group");
			char role = rs.getString("role").charAt(0);
			role = Character.toUpperCase(role);
			group = new Group(groupId, role);
			loggedUser = new User(
					rs.getString("username"), 
					rs.getString("password"), 
					rs.getString("name"), 
					rs.getString("surname"), 
					rs.getString("email"), 
					rs.getString("course"), 
					Character.toUpperCase(rs.getString("type").charAt(0)),
					group);
		}
		close();
		return loggedUser;
	}
/*
	//TODO
	@Override
	public boolean addGroup(Group group) throws Exception {
		//TODO falta rollback
		int id = group.getId();
		char role = group.getRole();
		role = Character.toUpperCase(role);
		User[] users = group.getUsers();
		boolean ok = true;
		this.connect();
		try{
			sql = "INSERT INTO groups(id,role) VALUES('"+id+"', '"+role+"');";
			if(stmt.executeUpdate(sql) == 0) ok = false;
			
			else if(users != null){
				
				for(User user : users){
					user.setGroup(new Group(group.getName(), group.isDirective()));
					if(!modUsersGroup(user)) ok = false;
				}
			}
		}catch(MySQLIntegrityConstraintViolationException | MysqlDataTruncation e){
			ok = false;
		}
		this.close();
		return ok;
	}

	private boolean modUsersGroup(User user) throws Exception {
		boolean ok = true;
		String name = user.getUsername();
		int groupId = user.getGroup().getId();
		this.connect();
		try{
			sql = "SELECT * FROM maintenance "
					+ "WHERE LOWER(username) LIKE LOWER('"+name+"');";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				sql = "UPDATE maintenance SET groupId = "+groupId+" "
						+ "WHERE LOWER(username) LIKE LOWER('"+name+"');";
			}else{
				sql = "INSERT INTO maintenance(username, groupId)"
						+ " VALUES('"+name+"', "+groupId+")";
			}
			if(stmt.executeUpdate(sql) == 0){
				ok = false;
			}
		}catch(MySQLIntegrityConstraintViolationException | MysqlDataTruncation e){
			ok = false;
		}
		this.close();
		return ok;
	}
*/

	@Override
	public boolean addBreakdown(Breakdown breakdown) throws Exception {
		//TODO
		boolean ok;
		boolean isOther = breakdown.getReporter().getSurname() == null;
		String date = format.format(breakdown.getDate());
		String name = (isOther)? breakdown.getReporter().getName() : breakdown.getReporter().getUsername();
		int failureType = breakdown.getFailureType().getId();
		String subject = breakdown.getSubject();
		int machineCode =  breakdown.getMachine().getCode();
		String description = breakdown.getDescription();
		int equipmentAvailable = breakdown.getEquipmentAvailable();
		this.connect();

		sql = "INSERT INTO breakdowns(date," +( (isOther)? "reporter" : "username") + ", failureType, subject, description, machine, equipmentAvailable) "
				+ "VALUES('" + date + "','" + name + "','" + failureType + "','" + subject + "','" + description + "','" + machineCode + "','" + equipmentAvailable + "')";
		ok = stmt.executeUpdate(sql) == 1;
		
		this.close();
		return ok;
	}

	@Override
	public boolean addRepair(WorkOrder workOrder) throws Exception {
		// TODO 
		//TODO pillar la repair mas nueva
		Repair repair = workOrder.getRepairs().get(0);
		int workOrderId = workOrder.getBreakdown().getId();
		String repairDate = format.format(repair.getRepairDate());
		float timeSpent = repair.getTimeSpent();
		int failureLocalization = repair.getFailureLocalization().getId();
		boolean failureRepaired = repair.isFailureRepaired();
		String replacements = repair.getReplacements();
		String tools = repair.getTools();
		String repairProcess = repair.getRepairProcess();
		boolean hasInstructions = repair.isHasInstructions();
		boolean needsInstructions = repair.isNeedsInstructions();
		
		boolean ok;
		this.connect();
		
		sql = "INSERT INTO repairs("
				+ "workOrder,"
				+ "group,"
				+ "repairDate,"
				+ "timeSpent,"
				+ "failureLocalization,"
				+ "failureRepaired,"
				+ "replacements,"
				+ "tools,"
				+ "repairProcess,"
				+ "hasInstructions,"
				+ "needsInstructions)"
				+ " VALUES("
				+ ""+workOrderId+","
				+ ""+repairDate+","
				+ ""+timeSpent+","
				+ ""+failureLocalization+","
				+ ""+failureRepaired+","
				+ ""+replacements+","
				+ ""+tools+","
				+ ""+repairProcess+","
				+ ""+hasInstructions+","
				+ ""+needsInstructions+""
				+ ");";
		
		ok = stmt.executeUpdate(sql) == 1;
		this.close();
		return ok;
	}

/*
	@Override
	public boolean addUser(User user) throws Exception {//TODO falta rollback en caso de que falle algun insert
		String uname = user.getUsername();
		String name = user.getName();
		String surname = user.getSurname();
		String pass = user.getPassword();
		String email = user.getEmail();
		String course = user.getCourse();
		char type = user.getType();
		Group group = user.getGroup();
		boolean ok = true;
		this.connect();
		try{
			sql = "INSERT INTO users(username, password) VALUES('"+uname+"','"+pass+"');";
			if(stmt.executeUpdate(sql) == 0) ok = false; 
			else if(name != null){
				sql = "INSERT INTO others(username, name, surname, email, course, type)"
						+ " VALUES('"+uname+"','"+name+"','"+surname+"','"+email+"','"+course+"','"+type+"')  ;";
				if(stmt.executeUpdate(sql) == 0) ok = false;
				else if(group != null){
					int groupId = group.getId();
					sql = "INSERT INTO maintenance(username, groupId)"
							+ " VALUES('"+uname+"', "+groupId+")";
					System.out.println(sql);
					if(stmt.executeUpdate(sql) == 0) ok = false;
				}
			}
		}catch(MySQLIntegrityConstraintViolationException | MysqlDataTruncation e){
			ok = false;
		}
		this.close();
		return ok;
	}

*/







	@Override
	public Group getGroup(Group group) throws Exception {
		//TODO
		Group returnGroup = null;
		ArrayList<User> users;
		int groupId = group.getId();
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
			returnGroup = new Group(groupId, role, users);
		}
		return returnGroup;
	}

	private ArrayList<User> getUsersFromGroup(Group group) throws Exception{
		//TODO
		int groupId = group.getId();
		ArrayList<User> users = new ArrayList<>();
		this.connect();
		sql = "SELECT * "
				+ "FROM users JOIN others USING(username) "
				+ "JOIN maintenance USING(username) "
				+ "JOIN groups ON(maintenance.group = groups.id) "
				+ "WHERE groupId LIKE '"+groupId+"';";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			users.add(
					new User(
						rs.getString("username"), 
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getString("surname"), 
						rs.getString("email"), 
						rs.getString("course"), 
						Character.toUpperCase(rs.getString("type").charAt(0))
						)
					);
		}
		this.close();
		if(users.size() == 0) users = null;
		
		return users;
	}
	
	@Override
	public Breakdown getBreakdown(Breakdown breakdown) throws Exception {
		int id = breakdown.getId();
		Breakdown returnBreakdown = null;;
		Date date = null;
		User reporter = null;
		String reporterUsername = null;
		String username = null;
		FailureType failureType = null;
		String subject = null;
		String description = null;
		Machine machine = null;
		int machineCode = -1;
		int equipmentAvailable = -1;
		boolean ok;
		this.connect();
		sql = "SELECT * FROM breakdowns WHERE id = "+id+";";
		rs = stmt.executeQuery(sql);
		if(ok = rs.next()){
			date = format.parse(rs.getString("date"));
			reporterUsername = rs.getString("reporter");
			username = rs.getString("username");
			failureType = getFailureType(rs.getInt("failureType"));
			subject = rs.getString("subject");
			description = rs.getString("description");
			machineCode = rs.getInt("machine");
			equipmentAvailable = rs.getInt("equipmentAvailable");
		}
		this.close();
		if(ok){
			reporter = getUser(new User(reporterUsername));
			if(reporter.getName() == null || reporter.getName().isEmpty()){
				reporter.setName(username);
			}
			machine = getMachine(new Machine(machineCode));
			returnBreakdown = new Breakdown(id, date, reporter, failureType, subject, description, machine, equipmentAvailable);
		}
		return returnBreakdown;
	}

	private FailureType getFailureType(int id) throws Exception {

		ResultSet rs = null;
		
		FailureType failureType = null;
		sql = "SELECT * FROM failureTypes WHERE id = "+id+";";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			failureType = new FailureType(
					rs.getInt("id"), 
					rs.getString("name_"+language)
					);
		}
		return failureType;
	}

	@Override
	public Machine getMachine(Machine machine) throws Exception {
		// TODO 
		this.connect();
		
		this.close();
		return null;
	}

	/**
	 * Datos necesarios: id de breakdown y id de grupo
	 */
	@Override
	public WorkOrder getRepair(WorkOrder workOrder) throws Exception {
		// TODO
		Repair repair = null;
		
		int id = workOrder.getId();
		Group group = workOrder.getRepairs().get(0).getGroup();
		int groupId = group.getId();
		Date repairDate = null;
		float timeSpent = -1;
		FailureLocalization failureLocalization = null;
		boolean failureRepaired = false;
		String replacements = null;
		String tools = null;
		String repairProcess = null;
		boolean hasInstructions = false;
		boolean needsInstructions = false;
		this.connect();
		sql = "SELECT * FROM repairs "
				+ "JOIN groups ON(groups.id = repairs.groupId) "
				+ "JOIN failureLocalizations ON(repairs.failureLocalization = failureLocalizations.id) "
				+ "WHERE workOrder = "+id+" AND groups.id = "+groupId+";";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			group = new Group(
					rs.getInt("groups.id"), 
					Character.toUpperCase(rs.getString("role").charAt(0))
					);
			repairDate = format.parse(rs.getString("repairDate"));
			timeSpent = rs.getFloat("timeSpent");
			failureLocalization = new FailureLocalization(
					rs.getInt("failureLocalizations.id"),
					rs.getString("failureLocalizations.name")
					);
			failureRepaired = rs.getBoolean("failureRepaired");
			replacements = rs.getString("replacements");
			tools = rs.getString("tools");
			repairProcess = rs.getString("repairProcess");
			hasInstructions = rs.getBoolean("hasInstructions");
			needsInstructions = rs.getBoolean("needsInstructions");
			repair = new Repair(group, 
					repairDate, 
					timeSpent, 
					failureLocalization, 
					failureRepaired, 
					replacements, 
					tools, 
					repairProcess, 
					hasInstructions, 
					needsInstructions
					);
		}
		workOrder.setRepair(repair);
		return workOrder;
	}

	@Override
	public User getUser(User user) throws Exception {
		// TODO 
		this.connect();
		User returnUser = null;
		Group group = null;
		String name = user.getUsername();
		sql = "SELECT * "
				+ "FROM users JOIN others USING(username) "
				+ "JOIN maintenance USING(username) "
				+ "JOIN groups ON(maintenance.group = groups.id) "
				+ "WHERE LOWER(username) LIKE LOWER('"+name+"');";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			short groupId = rs.getShort("group");
			char role = rs.getString("role").charAt(0);
			role = Character.toUpperCase(role);
			group = new Group(groupId, role);
			returnUser = new User(
					rs.getString("username"), 
					rs.getString("password"), 
					rs.getString("name"), 
					rs.getString("surname"), 
					rs.getString("email"), 
					rs.getString("course"), 
					Character.toUpperCase(rs.getString("type").charAt(0)),
					group);
		}
		this.close();
		return returnUser;
	}

	@Override
	public WorkOrder getWorkOrder(WorkOrder order) throws Exception {
		// TODO 
		int id = order.getBreakdown().getId();
		Date date = null;;
		String others = null;
		int typeOfMaintenance = -1;
		ArrayList<Repair> repairs = null;
		WorkOrder returnWorkOrder = null;
		Breakdown breakdown = null;
		this.connect();
		String subselect = "SELECT id FROM breakdowns WHERE id = "+id+";";
		
		sql = "SELECT * FROM workOrders "
				+ "USING(id) WHERE ("+subselect+") = '"+id+"'";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			date = format.parse(rs.getString("date"));
			others = rs.getString("others");
			typeOfMaintenance = rs.getInt("typeOfMaintenance");
			
		}
		this.close();
		
		breakdown = getBreakdown(new Breakdown(id));
		repairs = getRepairsFromWorkOrder(order);
		returnWorkOrder = new WorkOrder(breakdown, date, others, typeOfMaintenance, repairs);
		
		return returnWorkOrder;
	}

	private ArrayList<Repair> getRepairsFromWorkOrder(WorkOrder order) throws Exception {
		ArrayList<Repair> repairs = new ArrayList<>();
		
		int id = order.getId();
		Group group = null;
		Date repairDate = null;
		float timeSpent = -1;
		FailureLocalization failureLocalization = null;
		boolean failureRepaired = false;
		String replacements = null;
		String tools = null;
		String repairProcess = null;
		boolean hasInstructions = false;
		boolean needsInstructions = false;
		this.connect();
		sql = "SELECT * FROM repairs "
				+ "JOIN groups ON(groups.id = repairs.groupId) "
				+ "JOIN failureLocalizations ON(repairs.failureLocalization = failureLocalizations.id) "
				+ "WHERE workOrder = "+id+" ORDER BY repairDate DESC;";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			group = new Group(
					rs.getInt("groups.id"), 
					Character.toUpperCase(rs.getString("role").charAt(0))
					);
			repairDate = format.parse(rs.getString("repairDate"));
			timeSpent = rs.getFloat("timeSpent");
			failureLocalization = new FailureLocalization(
					rs.getInt("failureLocalizations.id"),
					rs.getString("failureLocalizations.name")
					);
			failureRepaired = rs.getBoolean("failureRepaired");
			replacements = rs.getString("replacements");
			tools = rs.getString("tools");
			repairProcess = rs.getString("repairProcess");
			hasInstructions = rs.getBoolean("hasInstructions");
			needsInstructions = rs.getBoolean("needsInstructions");
			
			repairs.add(new Repair(group, 
						repairDate, 
						timeSpent, 
						failureLocalization, 
						failureRepaired, 
						replacements, 
						tools, 
						repairProcess, 
						hasInstructions, 
						needsInstructions
						)
					);
		}
		this.close();
		if(repairs.size() == 0) repairs = null;
		return repairs;
	}

	@Override
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

	
}
