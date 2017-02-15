package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.tartanga.dam.imhandroid.model.Message;

import control.Manager;
import log.Logger;


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
			Logger.xDD().info("ThreadClient -> Socket cliente ha enviado un objeto.");
			if(input instanceof Message){
				Logger.xDD().info("ThreadClient -> Socket cliente ha enviado un objeto del tipo Message.");
				output = manager.manageMessages((Message) input);
				Logger.xDD().info("ThreadClient -> Optenida salida de manageMessages().");
				out.writeObject(output);
				Logger.xDD().info("ThreadClient -> Enviada salida de manageMessages() a socket cliente.");
			}
		}catch(ClassNotFoundException e){
			Logger.xDD().error("ThreadClient -> Error ClassNotFoundException.");
			e.printStackTrace();
		}catch(IOException e){
			Logger.xDD().error("ThreadClient -> Error IOException.");
			e.printStackTrace();
		}finally{
			try {
				if(in != null) in.close();
				if(out != null) out.close();
				if(clientSocket != null) clientSocket.close();
				Logger.xDD().info("ThreadClient -> Cerrados el socket y los streams.");
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}