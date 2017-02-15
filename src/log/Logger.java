package log;

import org.apache.log4j.PropertyConfigurator;

public class Logger {

	final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Logger.class);
	
	public static org.apache.log4j.Logger xDD(){
		return log;
	}
	
	public static void loadProperty(){
		PropertyConfigurator.configure(Logger.class.getClassLoader().getResource("log4j.properties"));
	}
}
