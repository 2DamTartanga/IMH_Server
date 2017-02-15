
package com.tartanga.dam.imhandroid.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private ArrayList<User> users;
	private ArrayList<WorkOrder> workOrders;
	
	public Group(int id) {
		this.id = id;
	}

	public Group(int id, ArrayList<User> users) {
		this.id = id;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void setWorkOrders(ArrayList<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", users=" + users + ", workOrders=" + workOrders + "]";
	}
	
	
	
	
}