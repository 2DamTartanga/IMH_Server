package threads;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ThreadServer extends Thread{
	
	private ServerSocket serverSocket;
	private ArrayList<ObjectOutputStream> clients;
	
	public ThreadServer(){
		
	}
	
	@Override
	public void run(){
		
	}
}
