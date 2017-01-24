package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	/**
	 * Abre la conexion
	 */
	private void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/");//TODO esto!
			stmt = con.createStatement();
			
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
		rs.close();
		con.close();
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
		String sql = "SELECT * "
				+ "FROM users JOIN others USING(username) "
				+ "JOIN maintenance USING(username) "
				+ "JOIN groups ON(mainetance.group = groups.id) "
				+ "WHERE LOWER(username) LIKE LOWER("+name+") AND password "+pass+"";
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
		return user;
	}

	@Override
	public boolean addGroup(Group group) throws Exception {
		this.connect();
		this.close();
		return false;
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
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
	}

	@Override
	public boolean addIssue(Issue issue) throws Exception {
		// TODO Auto-generated method stub
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
	public boolean addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		this.connect();
		
		this.close();
		return false;
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
