package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import control.Manager;
import model.Message;

public class ThreadClient extends Thread {
	
	private Socket clientSocket;
	private ObjectOutputStream out;
	private Manager man;
	
	public ThreadClient(Socket clientSocket, ObjectOutputStream out){
		this.clientSocket = clientSocket;
		this.out = out;
	}

	@Override
	public void run(){
		
		ObjectInputStream in = null;
		
		// FIXME
		man = new Manager();
		
		try{
			in = new ObjectInputStream(clientSocket.getInputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		while(true){
			
			try{
				Message msgToParse;
				msgToParse = (Message) in.readObject();
				
				switch(msgToParse.getAction()){
				
				case Message.ADD:
					manageAdds(msgToParse, man);
					break;
				case Message.DEL:
					manageDeletes(msgToParse, man);
					break;
				case Message.MOD:
					manageMods(msgToParse, man);
					break;
				case Message.GET:
					manageGets(msgToParse, man);
				
				default:
					break;
				}
				
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				try{
					// server disconnected
					if(out != null) out.close();
				}catch(IOException ioE){
					ioE.printStackTrace();
				}
			}
			
		}
	}
	
	private void manageAdds(Message msg, Manager man){
		switch(msg.getObject()){
		
		case Message.ISSUE:
			
			break;
		case Message.WORK_ORDER:
			
			break;
		case Message.REPAIR:
			
			break;
		case Message.USER:
			
			break;
		case Message.GROUP:
			
			break;
		case Message.MACHINE:
			
			break;
		case Message.WORK_ZONE:
			
			break;
		default:
			break;
		}
	}
	
	private void manageMods(Message msg, Manager man){
		switch(msg.getObject()){
		
		case Message.ISSUE:
			
			break;
		case Message.WORK_ORDER:
			
			break;
		case Message.REPAIR:
			
			break;
		case Message.USER:
			
			break;
		case Message.GROUP:
			
			break;
		case Message.MACHINE:
			
			break;
		case Message.WORK_ZONE:
			
			break;
		default:
			break;
		}
	}
	
	private void manageDeletes(Message msg, Manager man){
		switch(msg.getObject()){
		
		case Message.ISSUE:
			
			break;
		case Message.WORK_ORDER:
			
			break;
		case Message.REPAIR:
			
			break;
		case Message.USER:
			
			break;
		case Message.GROUP:
			
			break;
		case Message.MACHINE:
			
			break;
		case Message.WORK_ZONE:
			
			break;
		default:
			break;
		}
	}
	
	private void manageGets(Message msg, Manager man){
		switch(msg.getObject()){
		
		case Message.ISSUE:
			
			break;
		case Message.WORK_ORDER:
			
			break;
		case Message.REPAIR:
			
			break;
		case Message.USER:
			
			break;
		case Message.GROUP:
			
			break;
		case Message.MACHINE:
			
			break;
		case Message.WORK_ZONE:
			
			break;
		default:
			break;
		}
	}
}
