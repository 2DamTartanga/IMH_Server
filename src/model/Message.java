package model;

public class Message {
	
	public static final String ADD = "add";
	public static final String MOD = "mod";
	public static final String DEL = "delete";
	public static final String GET = "get";
	public static final String LOGIN = "login";
	
	public static final String GROUP = "group";
	public static final String ISSUE = "issue";
	public static final String MACHINE = "machine";
	public static final String REPAIR = "repair";
	public static final String WORK_ORDER= "work order";
	public static final String USER = "user";
	public static final String WORK_ZONE = "work zone";
	
	private String action;
	private String object;
	private Object content;
	
	
	public Message(String action, String object, Object content) {
		this.action = action;
		this.object = object;
		this.content = content;
	}

	public String getAction() {
		return action;
	}

	public String getObject() {
		return object;
	}

	public Object getContent() {
		return content;
	}
	
}
