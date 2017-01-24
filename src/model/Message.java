package model;

public class Message {
	public static final String MSG_LOGIN = "login";
	public static final String MSG_ADD_GROUP = "add group";
	public static final String MSG_DEL_GROUP = "mod group";
	public static final String MSG_MOD_GROUP = "delete group";
	
	public static final String MSG_ADD_ISSUE = "add issue";
	public static final String MSG_DEL_ISSUE = "mod issue";
	public static final String MSG_MOD_ISSUE = "delete issue";
	
	public static final String MSG_ADD_MACHINE = "add machine";
	public static final String MSG_DEL_MACHINE = "mod machine";
	public static final String MSG_MOD_MACHINE = "delete machine";
	
	public static final String MSG_ADD_REPAIR = "add repair";
	public static final String MSG_DEL_REPAIR = "mod repair";
	public static final String MSG_MOD_REPAIR = "delete repair";
	
	public static final String MSG_ADD_WORK_ORDER = "add work order";
	public static final String MSG_DEL_WORK_ORDER = "mod work order";
	public static final String MSG_MOD_WORK_ORDER = "delete work order";
	
	public static final String MSG_ADD_USER = "add user";
	public static final String MSG_DEL_USER = "mod user";
	public static final String MSG_MOD_USER = "delete user";
	
	public static final String MSG_ADD_WORK_ZONE = "add work zone";
	public static final String MSG_DEL_WORK_ZONE = "mod work zone";
	public static final String MSG_MOD_WORK_ZONE = "delete work zone";

	
	
	private String messageType;
	private Object content;
	
	
	public Message(String messageType, Object content) {
		super();
		this.setMessageType(messageType);
		this.setContent(content);
	}


	public String getMessageType() {
		return messageType;
	}


	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	public Object getContent() {
		return content;
	}


	public void setContent(Object content) {
		this.content = content;
	}
	
	
}
