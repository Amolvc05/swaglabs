package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard 
{
	WebDriver driver;
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	


	@FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack' and text()='Add to cart']")
	WebElement title;
	
	@FindBy (xpath = "//a[@data-test='shopping-cart-link']")
	WebElement Shopingcart;
	
	public void addtocartsaucelabsbackpack()
	{
		 title.click();
	}
	
	public void gotoShopingcart()
	{
		Shopingcart.click();
	}
}
