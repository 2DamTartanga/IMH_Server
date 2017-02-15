package threads;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import log.Logger;

public class ThreadServer extends Thread{

	private static final int PORT = 6100;
	private ServerSocket serverSocket;

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
			Logger.xDD().info("ThreadServer -> " + msg);
			while (true) {
				Thread.sleep(100);
				Logger.xDD().info("ThreadServer -> " + " dormiendo el thread 100ms");
				{
					examineRequest();
				}
			}
		} catch (IOException e) {
			Logger.xDD().error("ThreadServer -> " + "IOException: " + e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			Logger.xDD().error("ThreadServer -> " + "InterruptedException: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void examineRequest() throws IOException {
		Socket cs = serverSocket.accept();
		ObjectOutputStream out = new ObjectOutputStream(cs.getOutputStream());
		ThreadClient tc = new ThreadClient(cs, out);
		tc.start();
		Logger.xDD().info("ThreadServer -> " + "New request: " + cs.getInetAddress() + "\n");
	}
}
