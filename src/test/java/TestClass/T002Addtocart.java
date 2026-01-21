package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObject.Dashboard;

public class T002Addtocart extends BaseClass
{
	
	@Test
	public void Verifyaddtocart() throws InterruptedException
	{ log.info(" Starting T002Addtocart ");
		try
		{
			
		Dashboard d= new Dashboard(driver);
	
		d.addtocartsaucelabsbackpack();
		log.info(" clicked on addtoproductbutton ");
		d.gotoShopingcart();
		log.info("Naviagted to cart ");
		String Expectedtitle="Sauce Labs Backpack";
		WebElement producttext =driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		String Actaultitle=producttext.getText();
		log.info(" get textt ");
		Assert.assertEquals(Actaultitle, Expectedtitle);
		log.info(" validate product title ");
		}catch (Exception e)
		{
		  Assert.fail();
		}
		
				
	}

}
