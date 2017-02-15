package log;

import org.apache.log4j.PropertyConfigurator;

public class Logger {

	private static org.apache.log4j.Logger log;
	
	public static org.apache.log4j.Logger xDD(){
		if(log == null){
			log = org.apache.log4j.Logger.getLogger(Logger.class);
			loadProperty();
		}
		return log;
	}
	
	public static void loadProperty(){
		PropertyConfigurator.configure(Logger.class.getClassLoader().getResource("log/log4j.properties"));
	}
}
