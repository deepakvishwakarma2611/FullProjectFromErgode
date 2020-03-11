package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Base {
	
	public static WebDriver driver;
	
	public WebDriver setup() throws Exception
	{
		System.out.println(System.getProperty("user.dir"));
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\config.properties");
		prop.load(fis);
		
		if(prop.getProperty("browser").contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if (prop.getProperty("browser").contains("htmlunit"))
		{
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new HtmlUnitDriver();
			
		}
		
		else if(prop.getProperty("browser").contentEquals("headless"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepak\\Downloads\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1600,900");
			options.addArguments("headless");
			
			 driver = new ChromeDriver(options);
		}
		
		else if (prop.getProperty("browser").contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("userdir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("http://www.qaclickacademy.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void ScreenShot(String ScreenshotName) throws Exception
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\Deepak\\eclipse-workspace\\Project1\\Screenshot\\"+ScreenshotName+"screenshot.png");
		FileUtils.copyFile(src, destination);
		
	
	}
	

}
