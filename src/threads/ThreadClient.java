package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadClient extends Thread {
	
	private Socket clientSocket;
	private ObjectOutputStream out;
	
	public ThreadClient(Socket clientSocket, ObjectOutputStream out){
		this.clientSocket = clientSocket;
		this.out = out;
	}

	@Override
	public void run(){
		
		ObjectInputStream in = null;
		
		try{
			in = new ObjectInputStream(clientSocket.getInputStream());
		}catch(IOException e){
			// FIXME change raised exception
			e.printStackTrace();
		}
		
		while(true){
			
			try{
				Object commandToParse;
				commandToParse = in.readObject();
				
				// TODO parse command and implement posible commands
				// FIXME change --> instanceof String
				if(commandToParse instanceof String){
					 // TODO implement correctly
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
}
