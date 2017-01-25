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
				
				man.manageMessages(msgToParse);
				
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
}
