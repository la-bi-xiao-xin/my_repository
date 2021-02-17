package JavaDemo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jDemo {

    public   static   void  main(String[] args)  {

        PropertyConfigurator.configure( " F:\\idea_project\\flinkbase\\src\\main\\resources\\log4j.properties " );
        Logger logger  =  Logger.getLogger("testlog");
        logger.debug( " debug " );
        logger.error( " error " );
    }
}
