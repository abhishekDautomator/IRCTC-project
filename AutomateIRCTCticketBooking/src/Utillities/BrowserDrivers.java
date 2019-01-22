package Utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class BrowserDrivers {
	static WebDriver driver;
	public static WebDriver operaDriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.opera.driver","C:\\Users\\naray\\eclipse-workspace\\AutomateIRCTCticketBooking\\BrowserDriverExe\\operadriver.exe");
		OperaOptions opt=new OperaOptions();
		opt.setBinary("C:\\Program Files\\Opera\\launcher.exe");
		driver=new OperaDriver(opt);
		return driver;
	}
	
	public static WebDriver fieFoxDriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Users\\naray\\eclipse-workspace\\AutomateIRCTCticketBooking\\BrowserDriverExe\\geckodriver.exe");
		FirefoxOptions opt=new FirefoxOptions();
		opt.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver=new FirefoxDriver(opt);
		return driver;
	}
	
	public static WebDriver edgeDriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","C:\\Users\\naray\\eclipse-workspace\\AutomateIRCTCticketBooking\\BrowserDriverExe\\MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
		return driver;
	}
	
	public static WebDriver chromeDriver() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\naray\\eclipse-workspace\\AutomateIRCTCticketBooking\\BrowserDriverExe\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		driver=new ChromeDriver(opt);
		return driver;
	}

}
