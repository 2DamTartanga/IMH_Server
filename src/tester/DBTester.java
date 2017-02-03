package tester;

import control.Manager;
import db.DBManager;
import model.Group;
import model.User;

public class DBTester {

	
	static Manager manager;
	public static void main(String[] args) {
		try {
		manager = new Manager();
		
			switch (2) {
			case 1:
					//login();
				break;
			case 2:
				//addUser();
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
/*
	private static void addUser() throws Exception {
		User user = new User("nuevo", "nuevo", "nuevo", "123", "nuevo@mail", "nuevo", 'A', new Group("T-234",false));
		System.out.println(manager.addUser(user));
	}

	private static void login() throws Exception {
		User user = new User(null, null, "pepe", "123", null, null, 'c', null);
		
		System.out.println(manager.login(user));
		
	}*/
}
