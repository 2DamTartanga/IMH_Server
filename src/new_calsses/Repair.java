package new_calsses;

import java.util.Date;

public class Repair {

	private Group group;
	private Date repairDate;
	private float timeSpent;
	private FailureLocalization failureLocalization;
	private boolean failureRepaired;
	private String replacements;
	private String tools;
	private String repairProcess;
	private boolean hasInstructions;
	private boolean needsInstructions;
	private boolean subnormality;
	private boolean notEnoughMaterial;
	private boolean notEnoughTime;
	
	public Repair(Group group, Date repairDate, float timeSpent, FailureLocalization failureLocalization,
			boolean failureRepaired) {
		super();
		this.group = group;
		this.repairDate = repairDate;
		this.timeSpent = timeSpent;
		this.failureLocalization = failureLocalization;
		this.failureRepaired = failureRepaired;
	}
	
	public Repair(Group group, Date repairDate, float timeSpent, FailureLocalization failureLocalization,
			boolean failureRepaired, String replacements, String tools, String repairProcess, boolean hasInstructions,
			boolean needsInstructions) {
		super();
		this.group = group;
		this.repairDate = repairDate;
		this.timeSpent = timeSpent;
		this.failureLocalization = failureLocalization;
		this.failureRepaired = failureRepaired;
		this.replacements = replacements;
		this.tools = tools;
		this.repairProcess = repairProcess;
		this.hasInstructions = hasInstructions;
		this.needsInstructions = needsInstructions;
	}
	
	public Repair(Group group, Date repairDate, float timeSpent, FailureLocalization failureLocalization,
			boolean failureRepaired, String replacements, String tools, String repairProcess, boolean hasInstructions,
			boolean needsInstructions, boolean subnormality, boolean notEnoughMaterial, boolean notEnoughTime) {
		super();
		this.group = group;
		this.repairDate = repairDate;
		this.timeSpent = timeSpent;
		this.failureLocalization = failureLocalization;
		this.failureRepaired = failureRepaired;
		this.replacements = replacements;
		this.tools = tools;
		this.repairProcess = repairProcess;
		this.hasInstructions = hasInstructions;
		this.needsInstructions = needsInstructions;
		this.subnormality = subnormality;
		this.notEnoughMaterial = notEnoughMaterial;
		this.notEnoughTime = notEnoughTime;
	}

	public Group getGroup() {
		return group;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public float getTimeSpent() {
		return timeSpent;
	}

	public FailureLocalization getFailureLocalization() {
		return failureLocalization;
	}

	public boolean isFailureRepaired() {
		return failureRepaired;
	}

	public String getReplacements() {
		return replacements;
	}

	public String getTools() {
		return tools;
	}

	public String getRepairProcess() {
		return repairProcess;
	}

	public boolean isHasInstructions() {
		return hasInstructions;
	}

	public boolean isNeedsInstructions() {
		return needsInstructions;
	}

	public boolean isSubnormality() {
		return subnormality;
	}

	public boolean isNotEnoughMaterial() {
		return notEnoughMaterial;
	}

	public boolean isNotEnoughTime() {
		return notEnoughTime;
	}
	
	
	
	
	
}
