package new_classes;

public class Machine {

	private int code; 
	private MachineType type;
	private String serialNumber;
	private int status;
	private String year;
	private Localization localization; //??
	private int importance;
	
	private String phoneNumber;
	private String manager;
	private String electricConnection;
	private boolean pneumaticConnection;
	private boolean hydraulicConnection;
	private String dimmensions;
	private String powerSource;
	private String weight;
	private String typeOfOil;
	private String workingPressure;
	private String manufacturer;
	private String fileSearch;
	
	
	
	public Machine(int code) {
		this.code = code;
	}
	public Machine(int code, MachineType type, int status, Localization localization, int importance) {
		this(code);
		this.type = type;
		this.status = status;
		this.localization = localization;
		this.importance = importance;
	}
	public int getCode() {
		return code;
	}
	public MachineType getType() {
		return type;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public int getStatus() {
		return status;
	}
	public String getYear() {
		return year;
	}
	public Localization getLocalization() {
		return localization;
	}
	public int getImportance() {
		return importance;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getManager() {
		return manager;
	}
	public String getElectricConnection() {
		return electricConnection;
	}
	public boolean isPneumaticConnection() {
		return pneumaticConnection;
	}
	public boolean isHydraulicConnection() {
		return hydraulicConnection;
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
	public String getManufacturer() {
		return manufacturer;
	}
	public String getFileSearch() {
		return fileSearch;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public void setElectricConnection(String electricConnection) {
		this.electricConnection = electricConnection;
	}
	public void setPneumaticConnection(boolean pneumaticConnection) {
		this.pneumaticConnection = pneumaticConnection;
	}
	public void setHydraulicConnection(boolean hydraulicConnection) {
		this.hydraulicConnection = hydraulicConnection;
	}
	public void setDimmensions(String dimmensions) {
		this.dimmensions = dimmensions;
	}
	public void setPowerSource(String powerSource) {
		this.powerSource = powerSource;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void setTypeOfOil(String typeOfOil) {
		this.typeOfOil = typeOfOil;
	}
	public void setWorkingPressure(String workingPressure) {
		this.workingPressure = workingPressure;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setFileSearch(String fileSearch) {
		this.fileSearch = fileSearch;
	}
	
	
	
	
	
}
