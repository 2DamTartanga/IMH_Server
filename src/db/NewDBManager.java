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
import model.User;
import model.WorkOrder;



public class NewDBManager{

	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	protected String sql;
	protected SimpleDateFormat format;
	
	public NewDBManager(){
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * Abre la conexion
	 */
	protected void connect()
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
	
	
	/**
	 * Cierra la conexion
	 * 
	 * @throws SQLException Excepcion sql
	 */
	protected void close() throws SQLException {
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
		TechnicianGroup group = null;
		String name = user.getUserName();
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

	public boolean addBreakdown(Issue issue) throws Exception {
		//TODO
		boolean ok;
		boolean isOther = issue.getReporter().getSurName() == null;
		String date = format.format(issue.getDate());
		String name = (isOther)? issue.getReporter().getName() : issue.getReporter().getUserName();
		String failureType = issue.getFailureType();
		String machineCode =  issue.getMachine().getId();
		String description = issue.getDescription();
		this.connect();

		sql = "INSERT INTO breakdowns(date," +( (isOther)? "reporter" : "username") + ", failureType, description, codMachine) "
				+ "VALUES('" + date + "','" + name + "','" + failureType + "','" + description + "','" + machineCode + ");";
		ok = stmt.executeUpdate(sql) == 1;
		
		this.close();
		return ok;
	}

	public boolean addRepair(WorkOrder workOrder) throws Exception {
		// TODO 
		//TODO pillar la repair mas nueva
		Repair repair = workOrder.getRepair().get(0);
		String workOrderId = workOrder.getId();
		String repairDate = format.format(repair.getFinishDate());
		float timeSpent = repair.getTimeSpent();
		String failureLocalization = repair.getFailureLocalization();
		boolean failureRepaired = repair.isSolved();
		String replacements = repair.getReplacements();
		String tools = repair.getTools();
		String repairProcess = repair.getRepairProcess();
		
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
				+ "repairProcess)"
				+ " VALUES("
				+ ""+workOrderId+","
				+ ""+repairDate+","
				+ ""+timeSpent+","
				+ ""+failureLocalization+","
				+ ""+failureRepaired+","
				+ ""+replacements+","
				+ ""+tools+","
				+ ""+repairProcess+""
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

	private ArrayList<User> getUsersFromGroup(TechnicianGroup group) throws Exception{
		//TODO
		String groupId = group.getId();
		ArrayList<User> users = new ArrayList<>();
		this.connect();
		sql = "SELECT * "
				+ "FROM users JOIN others USING(username) "
				+ "JOIN maintenance USING(username) "
				+ "JOIN groups ON(maintenance.group = groups.id) "
				+ "WHERE groupId LIKE '"+groupId+"';";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			TechnicianGroup tg = new TechnicianGroup();
			User user = new User();
			user.setCourse(rs.getString("course"));
			user.setCycle("");
			user.setEmail(rs.getString("email"));
			user.setGroup(tg);
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setSurName(rs.getString("surname"));
			user.setUserName(rs.getString("username"));
			users.add(user);
		}
		this.close();
		if(users.size() == 0) users = null;
		
		return users;
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

	public Machine getMachine(Machine machine) throws Exception {
		return new DBMachine().getMachine(machine);
	}

	/**
	 * Datos necesarios: id de breakdown y id de grupo
	 */
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

	public User getUser(User user) throws Exception {
		// TODO 
		this.connect();
		User returnUser = null;
		Group group = null;
		String name = user.getUserName();
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
