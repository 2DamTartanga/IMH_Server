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
	
	

}
