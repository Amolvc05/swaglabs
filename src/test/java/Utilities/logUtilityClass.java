package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logUtilityClass 
{ 
    public static Logger getLogger(Class<?> className)
    {
        return LogManager.getLogger(className);
    }


}
