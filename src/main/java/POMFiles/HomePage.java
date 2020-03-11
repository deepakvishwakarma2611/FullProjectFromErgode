package POMFiles;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){ 
		
		this.driver = driver;	
		
	}
	
	By HeaderText = By.xpath("//div[@class = 'text-center']/h2");
	
	By LoginLink = By.xpath("//span[text() = 'Login']");
	
	By RegisterLink = By.xpath("//span[text() = 'Register']");
	
	By ModulesName = By.xpath("//ul[@class = 'nav navbar-nav navbar-right']/li/a");
	
	
	public WebElement LoginLink()
	{
		return driver.findElement(LoginLink);
	}	
	
	public WebElement RegisterLink()
	{
		return driver.findElement(RegisterLink);
	}
	
	public List<WebElement> ModulesName()
	{
		return driver.findElements(ModulesName);
	}
	
	public WebElement HeaderText()
	{
		return driver.findElement(HeaderText);
	}
}
