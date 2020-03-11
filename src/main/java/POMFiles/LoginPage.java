package POMFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	String url = "https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1";

	By Email = By.xpath("//input[@id = 'user_email']");
	
	By Password = By.xpath("//input[@id = 'user_password']");
	
	By Login = By.xpath("//input[@value= 'Log In']");
	
	By AlertMessage = By.xpath("//div[@class= 'alert alert-danger']");
	
	public void LoginURL()
	{
		driver.get(url);
	}
	
	public WebElement EmailField()
	{
		return driver.findElement(Email);
	}
	
	public WebElement PasswordField()
	{
		return driver.findElement(Password);
	}
	
	public WebElement LoginButton()
	{
		return driver.findElement(Login);
	}
	
	public WebElement InvalidCredentialErrorMessage()
	{
		return driver.findElement(AlertMessage);
	}
}
