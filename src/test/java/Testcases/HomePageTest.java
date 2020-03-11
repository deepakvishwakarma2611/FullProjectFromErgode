package Testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POMFiles.HomePage;
import Resources.Base;

public class HomePageTest extends Base{

	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void Initialize() throws Exception
	{
		driver = setup();
		log.info("Initializing the driver");
	}

	@Test
	public void verifyHomePageURL() throws Exception
	{
	
		
		String ExpectedURL = "http://www.qaclickacademy.com/";
				
		String ActualURL = driver.getCurrentUrl();
		
		log.info("Getting current url");
		
		Assert.assertEquals(ActualURL, ExpectedURL);
		
		log.info("comparing expected and actual result");

	}
	
	@Test
	public void verifyModulesName() throws Exception
	{
		log.error("I am error");

		
		String a[] = {"HOME","COURSES","VIDEOS","INTERVIEW GUIDE","PRACTICE","BLOG","ABOUT","CONTACT"};
		
		List ExpectedModuleName = Arrays.asList(a); 
		
		System.out.println(ExpectedModuleName);
		
		HomePage h = new HomePage(driver);
		
		List <WebElement> ModuleList = h.ModulesName();
		
		ArrayList <String> ActualModuleName = new ArrayList <String>();
		
		for(int i=0; i<ModuleList.size();i++)
		{
			ActualModuleName.add(ModuleList.get(i).getText());
		}
		
		System.out.println(ActualModuleName);
		
		Assert.assertEquals(ActualModuleName, ExpectedModuleName);
	
	}
	
	@Test
	public void verifyHeaderText()
	{
		log.debug("I am debug");
		log.fatal("I am Fatal");
		
		String ExpectedText = "FEATURED COURSES";
		
		HomePage h = new HomePage(driver);

		String ActualText = h.HeaderText().getText();
		
		Assert.assertEquals(ActualText, ExpectedText);
		
		
	}
	
	@AfterTest()
	public void Teardown()
	{
		driver.close();
	}
	
	
}
