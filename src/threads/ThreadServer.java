package threads;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadServer extends Thread{
	
	private static final int PORT = 8008;
	private ServerSocket serverSocket;
	private ArrayList<ObjectOutputStream> clientsOutputs;
	
	public static void main(String[] args){
		ThreadServer ts = new ThreadServer();
		ts.start();
	}
	
	public ThreadServer(){ }
	
	@Override
	public void run(){
		String msg = "Listening for connections...";
		try {
			serverSocket = new ServerSocket(PORT);
			clientsOutputs = new ArrayList<>();
			System.out.println(msg);
			while (true) {
				Thread.sleep(100);
				{
					if(clientsOutputs.size() < 50){
						addClient();
					}
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void addClient() throws IOException {
		Socket cs = serverSocket.accept();
		String msg = "Client connected: " + cs.getInetAddress() + "\n";
		ObjectOutputStream out = new ObjectOutputStream(cs.getOutputStream());
		clientsOutputs.add(out);
		ThreadClient tc = new ThreadClient(cs, out);
		tc.start();
		System.out.println(msg);
	}
}
