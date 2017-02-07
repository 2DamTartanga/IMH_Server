package com.tartanga.dam.imhandroid.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private ArrayList<Machine> machines;
	public Section(){
		
	}
	public Section(String id, ArrayList<Machine> machines) {
		this.id = id;
		this.machines = machines;
	}
	
	public String getId() {
		return id;
	}
	public ArrayList<Machine> getMachines() {
		return machines;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMachines(ArrayList<Machine> machines) {
		this.machines = machines;
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + ", machines=" + machines + "]";
	}
	
	
	
}
