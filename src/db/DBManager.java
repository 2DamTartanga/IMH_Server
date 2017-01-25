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
	
	/**
	 * Cierra la conexion
	 * 
	 * @throws SQLException Excepcion sql
	 */
	private void close() throws SQLException {
		stmt.close();
		
		if(rs != null){
			rs.close();
		}
		
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
				sql = "UPDATE maintenance SET group_id = "+groupId+" "
						+ "WHERE LOWER(username) LIKE LOWER('"+name+"');";
			}else{
				sql = "INSERT INTO maintenance(username, group_id)"
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

	@Override
	public boolean modGroup(Group group) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delGroup(Group group) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addBreakdown(Breakdown breakdown) throws Exception {
		//TODO
		boolean ok;
		boolean isOther = breakdown.getReporter().getSurname() == null;
		String date = format.format(breakdown.getDate());
		String name = (isOther)? breakdown.getReporter().getName() : breakdown.getReporter().getUserName();
		this.connect();

		sql = "INSERT INTO breakdowns(date," +( (isOther)? "reporter" : "username") + ", failure_type, subject, description, machine, equipment_available) "
				+ "VALUES('" + date + "','" + name + "','" + failureType + "','" + subject + "','" + description + "','" + machine + "','" + equipmentAvailable + "')";
		ok = stmt.executeUpdate(sql) == 1;
		
		this.close();
		return ok;
	}

	@Override
	public boolean modBreakdown(Breakdown breakdown) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delBreakdown(Breakdown breakdown) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addMachine(Machine machine) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modMachine(Machine machine) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delMachine(Machine machine) throws Exception {
		this.connect();
		
		this.close();
		return false;
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
		boolean subnormality = repair.isSubnormality();
		boolean notEnoughMaterials = repair.isNotEnoughMaterial();
		boolean notEnoughTime = repair.isNotEnoughTime();
		
		boolean ok;
		this.connect();
		
		sql = "INSERT INTO assignated_groups("
				+ "work_order,"
				+ "group,"
				+ "repair_date,"
				+ "time_spent,"
				+ "failure_localization,"
				+ "failure_repaired,"
				+ "replacements,"
				+ "tools,"
				+ "repair_process,"
				+ "has_instructions,"
				+ "needs_instructions,"
				+ "subnormality,"
				+ "not_enough_material,"
				+ "not_enough_time)"
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
				+ ""+needsInstructions+","
				+ ""+subnormality+","
				+ ""+notEnoughMaterials+","
				+ ""+notEnoughTime+","
				+ ");";
		
		ok = stmt.executeUpdate(sql) == 1;
		this.close();
		return ok;
	}

	@Override
	public boolean modRepair(WorkOrder workOrder) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delRepair(WorkOrder workOrder) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

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
					sql = "INSERT INTO maintenance(username, group_id)"
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

	@Override
	public boolean modUser(User user) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delUser(User user) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addWorkOrder(WorkOrder order) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modWorkOrder(WorkOrder order) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delWorkOrder(WorkOrder order) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addLocalization(Localization localization) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modLocalization(Localization localization) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delLocalization(Localization localization) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public Group getGroup(Group group) throws Exception {
		//TODO
		Group returnGroup = null;
		ArrayList<User> users;
		int groupId = group.getId();
		char role = '.';
		this.connect();
		sql = "SELECT group_id, role FROM groups WHERE group_id = "+groupId+";";
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
				+ "WHERE group_id LIKE '"+groupId+"';";
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
		Date date;
		User reporter;
		FailureType failureType;
		String subject;
		String description;
		Machine machine;
		int equipmentAvailable;
		this.connect();
		sql = "SELECT ";
		this.close();
		return breakdown;
	}

	@Override
	public Machine getMachine(Machine machine) throws Exception {
		// TODO 
		this.connect();
		
		this.close();
		return null;
	}

	@Override
	public Repair getRepair(WorkOrder workOrder) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return null;
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
		int typeOfMaintenance = null;
		ArrayList<Repair> repairs = null;
		WorkOrder returnWorkOrder = null;
		Breakdown breakdown = null;
		this.connect();
		String subselect = "SELECT id FROM breakdowns WHERE id = "+id+";";
		
		sql = "SELECT * FROM work_orders "
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
		ArrayList<Repair> repairs = null;
		
		int id = 
		
		this.connect();
		
		
		this.close();
		
		return repairs;
	}

	@Override
	public Localization getLocalization(Localization localization) throws Exception {
		// TODO 
		this.connect();
		
		this.close();
		return null;
	}

	
}
