package model;

public class Machine {
	
	private String code;
	private String type;
	private String year;
	private String phoneNumber;
	private String model;
	private String serialNumber;
	private String manager;
	private String electricConnection;
	private boolean hasPneumaticConnection;
	private boolean hasHidraulicSystem;
	private String dimmensions;
	private String powerSource;
	private String weight;
	private String typeOfOil;
	private String workingPressure;
	private int state;
	private String manufacturer;
	private String severity;
	private String fileSearch;
	
	
	public Machine(String code, String type, String year, String phoneNumber, String model, String serialNumber,
			String manager, String electricConnection, boolean hasPneumaticConnection, boolean hasHidraulicSystem,
			String dimmensions, String powerSource, String weight, String typeOfOil, String workingPressure, int state,
			String manufacturer, String severity, String fileSearch) {
		this.code = code;
		this.type = type;
		this.year = year;
		this.phoneNumber = phoneNumber;
		this.model = model;
		this.serialNumber = serialNumber;
		this.manager = manager;
		this.electricConnection = electricConnection;
		this.hasPneumaticConnection = hasPneumaticConnection;
		this.hasHidraulicSystem = hasHidraulicSystem;
		this.dimmensions = dimmensions;
		this.powerSource = powerSource;
		this.weight = weight;
		this.typeOfOil = typeOfOil;
		this.workingPressure = workingPressure;
		this.state = state;
		this.manufacturer = manufacturer;
		this.severity = severity;
		this.fileSearch = fileSearch;
	}


	public String getCode() {
		return code;
	}


	public String getType() {
		return type;
	}


	public String getYear() {
		return year;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getModel() {
		return model;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public String getManager() {
		return manager;
	}


	public String getElectricConnection() {
		return electricConnection;
	}


	public boolean isHasPneumaticConnection() {
		return hasPneumaticConnection;
	}


	public boolean isHasHidraulicSystem() {
		return hasHidraulicSystem;
	}


	public String getDimmensions() {
		return dimmensions;
	}


	public String getPowerSource() {
		return powerSource;
	}


	public String getWeight() {
		return weight;
	}


	public String getTypeOfOil() {
		return typeOfOil;
	}


	public String getWorkingPressure() {
		return workingPressure;
	}


	public int getState() {
		return state;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public String getSeverity() {
		return severity;
	}


	public String getFileSearch() {
		return fileSearch;
	}
	
	

}
