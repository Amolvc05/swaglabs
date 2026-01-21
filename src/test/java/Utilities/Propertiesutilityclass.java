package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Propertiesutilityclass
{
	private static Properties prop;

    public static Properties loadProperties() 
    {
        try 
        {
            FileInputStream fis = new FileInputStream("src/test/resources/data.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return prop;
    }


}
