package Utillities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import configFileReader.ConfigFileReader;
//import ticketBookingIRCTC.TicketBookingIRCTC;

public class WaitMethodsClass {
	 static WebDriver driver;
	 static WebDriverWait webDriverWait;
	 static Wait<WebDriver> fluentWait;
	public WaitMethodsClass(WebDriver driver) {
		
		WaitMethodsClass.driver=driver;
	}

	public static void sleepMethod(int millisec) {
		try{
			Thread.sleep(millisec);
			}
		catch(Exception e) {
			
			System.out.println("Interrupted exception occured");
		}
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	
	public static void webDriverWait(WebElement ele,WebDriver driver) {
		webDriverWait=new WebDriverWait(driver,3);
		webDriverWait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public static WebElement fluentWait(int sec,WebDriver driver,By ele) {
		fluentWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(1));
		WebElement element=fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
			return driver.findElement(ele);
			}
			});
		return element;
	}
	

}
