package BaseClass;

import java.time.Duration;
import java.util.Properties;

import org.bouncycastle.asn1.cmp.ProtectedPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.Propertiesutilityclass;
import Utilities.logUtilityClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass 
  {   protected WebDriver driver;
      protected Properties prop;
      protected Logger log = logUtilityClass.getLogger(this.getClass());
       @Parameters({"browser"}) 
       
   @BeforeClass
   public void Setup(String browser) throws InterruptedException
   {
	   log  = LogManager.getLogger(this.getClass());
	   prop = Propertiesutilityclass.loadProperties();
       
	   
    	   
    	   String browserName = browser.toLowerCase();

    	   if (browserName.equals("chrome")) {

    	       System.setProperty(
    	           "webdriver.chrome.driver",
    	           System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe"
    	       );
    	       driver = new ChromeDriver();
    	       log.info("(chrome Browser setup started");

    	   } 
    	   else if (browserName.equals("edge")) {

    	       System.setProperty(
    	           "webdriver.edge.driver",
    	           System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe"
    	       );
    	       driver = new EdgeDriver();
    	       log.info("(edge Browser setup started");
    	   } 
    	   else if (browserName.equals("firefox")) {

    	       System.setProperty(
    	           "webdriver.gecko.driver",
    	           System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe"
    	       );
    	       driver = new FirefoxDriver();
    	       log.info("(firefox Browser setup started");
    	   } 
    	   else {
    	       throw new IllegalArgumentException("Invalid browser name: " + browser);
    	   }

	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	   driver.get(prop.getProperty("SLURL"));
	   log.info("url opened");
	   driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(prop.getProperty("Username"));
	   driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("Password"));
	   log.info("(credentials passed");
	   driver.findElement(By.xpath("//input[@id='login-button']")).click();
	   log.info("clicked on loginbutton");
	   
	   
   }
   
   @AfterClass
   public void Close()
   {
	   driver.quit();
   }

  
	

  }
