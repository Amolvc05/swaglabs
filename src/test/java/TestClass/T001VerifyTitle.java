package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;




public class T001VerifyTitle extends BaseClass
 {
     @Test
     public void Verifytitle()
     {
    	 log.info(" Starting TC_001_verifytitle ");
    	 try
    	 {
    	String Actaltitle= driver.getTitle();
    	log.info(" getting title ");
    	    		 
    	    		  String Expectedtitle ="Swag Labs";
    	    		  Assert.assertEquals(Expectedtitle, Actaltitle);
    	    		 log.info(" title validation ");
    	 }catch(Exception e)
    	 {
    		 Assert.fail();
    	 }
     }
	
}
