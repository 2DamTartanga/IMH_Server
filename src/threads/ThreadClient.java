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
			Logger.xDD().info("New request from " + clientSocket.getInetAddress());
			if(input instanceof Message){
				Logger.xDD().info("ThreadClient -> " + "Request tipo Message recibida.");
				Logger.xDD().debug("Message -> " + (Message) input);
				output = manager.manageMessages((Message) input);
				out.writeObject(output);
				Logger.xDD().debug("Output -> " + output);
				Logger.xDD().info("ThreadClient -> " + "Response enviada.");
			}
		}catch(ClassNotFoundException e){
			Logger.xDD().error("ThreadClient -> Error ClassNotFoundException = " + e.getMessage());
		}catch(IOException e){
			Logger.xDD().error("ThreadClient -> Error IOException = " + e.getMessage());
		}finally{
			try {
				if(in != null) in.close();
				if(out != null) out.close();
				if(clientSocket != null) clientSocket.close();
				Logger.xDD().info("ThreadClient -> Cerrados el socket y los streams.");
			}catch(IOException ex) {
				Logger.xDD().error("ThreadClient -> Error al cerrar socks y streams = " + ex.getMessage());
			}
		}
	}
}