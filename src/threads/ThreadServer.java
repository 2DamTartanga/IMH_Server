package threads;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import config.Config;
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
		setConfig();
		try {
			serverSocket = new ServerSocket(PORT);
			Logger.xDD().info("ThreadServer -> " + msg);
			while (true) {
				Thread.sleep(100);
				examineRequest();
			}
		} catch (IOException e) {
			Logger.xDD().error("ThreadServer -> " + "IOException: " + e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			Logger.xDD().error("ThreadServer -> " + "InterruptedException: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void setConfig() {
		InputStream input;
		try {
			Properties properties = new Properties();
			String configFile = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(configFile);
			if(input != null){
				properties.load(input);
				
				Config.HOST = properties.getProperty("database_host");
				Config.PORT = properties.getProperty("database_port");
				Config.USER = properties.getProperty("database_username");
				Config.PASSWORD = properties.getProperty("database_password");
				
			}else{
				//TODO Fatal log
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
