package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import interfaces.Database;
import model.Group;
import model.Issue;
import model.Machine;
import model.User;
import model.WorkOrder;
import model.WorkZone;

public class DBManager implements Database {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String sql;
	
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
			String  groupName;
			
			loggedUser = new User(
					rs.getString("username"), 
					rs.getString("surname"), 
					rs.getString("name"), 
					rs.getString("password"), 
					rs.getString("email"), 
					rs.getString("course"), rs.getString("type"));
			groupName = role + "-" + groupId;
			group = new Group(groupName, role == 'D');
			loggedUser.setGroup(group);
		}
		close();
		return loggedUser;
	}

	@Override
	public boolean addGroup(Group group) throws Exception {
		int id = group.getId();
		char role = group.getRole();
		role = Character.toUpperCase(role);
		User[] users = group.getUsers();
		boolean ok = true;
		this.connect();
		try{
			sql = "INSERT INTO groups (id,role) VALUES('"+id+"', '"+role+"');";
			if(stmt.executeUpdate(sql) == 0) ok = false;
			
			else if(users != null){
				
				for(User user : users){
					user.setGroup(new Group(group.getName(), group.isDirective()));
					if(!addUser(user)) ok = false;
				}
			}
		}catch(MySQLIntegrityConstraintViolationException | MysqlDataTruncation e){
			ok = false;
		}
		this.close();
		return ok;
	}

	@Override
	public boolean modGroup(Group group) throws Exception {
		// TODO Auto-generated method stub
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
	public boolean addIssue(Issue issue) throws Exception {
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modIssue(Issue issue) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delIssue(Issue issue) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addMachine(Machine machine) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modMachine(Machine machine) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delMachine(Machine machine) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addRepair(WorkOrder workOrder) throws Exception {
		// TODO Auto-generated method stub

		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modRepair(WorkOrder workOrder) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delRepair(WorkOrder workOrder) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addUser(User user) throws Exception {//TODO falta rollback en caso de que falle algun insert
		String uname = user.getUserName();
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
			sql = "INSERT INTO users (username, password) VALUES('"+uname+"','"+pass+"');";
			if(stmt.executeUpdate(sql) == 0) ok = false; 
			else if(name != null){
				sql = "INSERT INTO others (username, name, surname, email, course, type)"
						+ "VALUES('"+uname+"','"+name+"','"+surname+"','"+email+"','"+course+"','"+type+"')  ;";
				if(stmt.executeUpdate(sql) == 0) ok = false;
				else if(group != null){
					int groupId = group.getId();
					sql = "INSERT INTO maintenance (username, group_id) "
							+ "VALUES('"+uname+"', "+groupId+")";
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
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delUser(User user) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addWorkOrder(WorkOrder order) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modWorkOrder(WorkOrder order) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delWorkOrder(WorkOrder order) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addWorkZone(WorkZone workZone) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean modWorkZone(WorkZone workZone) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean delWorkZone(WorkZone workZone) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	
}
