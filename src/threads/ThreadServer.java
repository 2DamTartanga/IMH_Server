package threads;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer extends Thread{

	private static final int PORT = 8008;
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
			System.out.println(msg);
			while (true) {
				Thread.sleep(100);
				{
					examineRequest();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void examineRequest() throws IOException {
		Socket cs = serverSocket.accept();
		String msg = "New request: " + cs.getInetAddress() + "\n";
		ObjectOutputStream out = new ObjectOutputStream(cs.getOutputStream());
		ThreadClient tc = new ThreadClient(cs, out);
		tc.start();
		System.out.println(msg);
	}
}
