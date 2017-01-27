package interfaces;


import new_classes.*;

public interface Database {

	public User login(User user) throws Exception;
	
	public Group getGroup(Group group) throws Exception;
	
	public boolean addBreakdown(Breakdown breakdown) throws Exception;
	public Breakdown getBreakdown(Breakdown breakdown) throws Exception;

	public Machine getMachine(Machine machine) throws Exception;

	/**
	 * A�ade reparaci�n al WorkOrder
	 * si el WorkOrder ya ten�a una reparaci�n resuelta, no hace nada
	 * si el WorkOrder ya ten�a una reparaci�n no resuelta, la sustituye
	 * @param workOrder
	 * @return si la reparaci�n se ha a�adido correctamente
	 */
	public boolean addRepair(WorkOrder workOrder) throws Exception;
	public WorkOrder getRepair(WorkOrder workOrder) throws Exception;
	
	public User getUser(User user) throws Exception;
	
	public WorkOrder getWorkOrder(WorkOrder order) throws Exception;
	
	public Section getLocalization(Section localization) throws Exception;
	
}
