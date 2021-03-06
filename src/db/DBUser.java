package db;

import java.util.ArrayList;

import com.tartanga.dam.imhandroid.model.Group;
import com.tartanga.dam.imhandroid.model.User;

public class DBUser extends DBConn {

	public User login(User user) throws Exception{
		User rUser = null;
		System.out.println("Logeando");
		String username = user.getUsername();
		String password = user.getPassword();
		this.connect();
		sql = "SELECT * "
				+ "FROM users "
				+ "LEFT OUTER JOIN others USING(username) "
				+ "LEFT OUTER JOIN maintenance USING(username)"
				+"LEFT OUTER JOIN groups ON(maintenance.idGroup=groups.id) "
				+ "WHERE LOWER(username) LIKE LOWER('"+username+"') "
					+ "AND password LIKE '"+password+"';";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			if(rs.getString("role")!=null && rs.getString("role").charAt(0)=='T')rUser = getUserFromResult(true);
			else rUser=getUserFromResult(false);
			System.out.println(rUser);
		}
		this.close();
		return rUser;
	}
	
	public User getUser(User user) throws Exception{
		User rUser = null;
		String username = user.getUsername();
		this.connect();
		sql = "SELECT * "
				+ "FROM users "
				+ "LEFT OUTER JOIN others USING(username) "
				+ "JOIN maintenance USING(username)"
				+ "WHERE LOWER(username) LIKE LOWER('"+username+"');";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			rUser = getUserFromResult(true);
		}
		this.close();
		return rUser;
		
	}
	
	public ArrayList<User> getUsersFromGroup(Group group) throws Exception{
		ArrayList<User> rUsers = new ArrayList<>();
		int id = group.getId();
		this.connect();
		sql = "SELECT * "
				+ "FROM users "
				+ "LEFT OUTER JOIN others USING(username) "
				+ "LEFT OUTER JOIN maintenance USING(username)"
				+ "WHERE idGroup = "+id+";";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			rUsers.add(getUserFromResult(false));
		}
		this.close();
		if(rUsers.size() == 0) rUsers = null;
		return rUsers;
	}
	
	private User getUserFromResult(boolean needsGroup) throws Exception{
		User rUser = new User(rs.getString("username"), 
				rs.getString("password"),
				rs.getString("name"), 
				rs.getString("surname"), 
				rs.getString("email"), 
				rs.getString("course")
				);
		if(needsGroup && rs.getInt("idGroup") != 0){
			DBGroup dbGroup = new DBGroup();
			Group group = new Group(rs.getInt("idGroup"));
			group = dbGroup.getGroup(group,false,true);
			rUser.setGroup(group);
		}
		return rUser;
	}
	public boolean updatePassword(User user) throws Exception{
		this.connect();
		sql="UPDATE users "+
		"SET password='"+user.getPassword()+
		"' WHERE username LIKE '"+user.getUsername()+"';";
		int result = stmt.executeUpdate(sql);
		this.close();
		return result==1;
	}
	
	
	
}
