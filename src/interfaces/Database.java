package interfaces;


import model.Group;
import model.Issue;
import model.Machine;
import model.User;
import model.WorkOrder;
import model.WorkZone;

public interface Database {

	public User login(User user) throws Exception;
	
	public boolean addGroup(Group group) throws Exception;
	
	public boolean modGroup(Group group) throws Exception;
	
	public boolean delGroup(Group group) throws Exception;
	
	public boolean addIssue(Issue issue) throws Exception;
	
	public boolean modIssue(Issue issue) throws Exception;
	
	public boolean delIssue(Issue issue) throws Exception;
	

	public boolean addMachine(Machine machine) throws Exception;
	
	public boolean modMachine(Machine machine) throws Exception;
	
	public boolean delMachine(Machine machine) throws Exception;

	/**
	 * Añade reparación al WorkOrder
	 * si el WorkOrder ya tenía una reparación resuelta, no hace nada
	 * si el WorkOrder ya tenía una reparación no resuelta, la sustituye
	 * @param workOrder
	 * @return si la reparación se ha añadido correctamente
	 */
	public boolean addRepair(WorkOrder workOrder) throws Exception;
	
	public boolean modRepair(WorkOrder workOrder) throws Exception;
	
	public boolean delRepair(WorkOrder workOrder) throws Exception;
	
	
	public boolean addUser(User user) throws Exception;
	
	public boolean modUser(User user) throws Exception;
	
	public boolean delUser(User user) throws Exception;
	
	
	public boolean addWorkOrder(WorkOrder order) throws Exception;
	
	public boolean modWorkOrder(WorkOrder order) throws Exception;
	
	public boolean delWorkOrder(WorkOrder order) throws Exception;
	
	
	public boolean addWorkZone(WorkZone workZone) throws Exception;
	
	public boolean modWorkZone(WorkZone workZone) throws Exception;
	
	public boolean delWorkZone(WorkZone workZone) throws Exception;
	
}
