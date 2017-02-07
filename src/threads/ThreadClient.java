package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.tartanga.dam.imhandroid.model.Message;

import control.Manager;

public class ThreadClient extends Thread {

	private Socket clientSocket;
	private ObjectOutputStream out;
	private Manager manager;

	public ThreadClient(Socket clientSocket, ObjectOutputStream out){
		this.clientSocket = clientSocket;
		this.out = out;
	}

	@Override
	public void run(){
		Object input;
		ObjectInputStream in = null;
		Object output;
		manager = new Manager();
		try{
			in = new ObjectInputStream(clientSocket.getInputStream());
			input = in.readObject();
			if(input instanceof Message){
				output = manager.manageMessages((Message) input);
				out.writeObject(output);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(in != null) in.close();
				if(out != null) out.close();
				if(clientSocket != null) clientSocket.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}