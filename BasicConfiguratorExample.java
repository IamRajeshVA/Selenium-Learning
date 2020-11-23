package Log4jlearning;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicConfiguratorExample {

	static Logger logger=Logger.getLogger(BasicConfiguratorExample.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicConfigurator.configure();
		logger.debug("This is debug message");
		logger.info("this is an INFO");
		logger.warn( "this is a warning" );
		logger.error("this is a error message");
		logger.fatal("this is a fatal message");
		
		
	}

}
