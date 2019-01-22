package pages;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utillities.WaitMethodsClass;

public class LoginPage {
	WebDriver driver;
	
	By loginButton=By.xpath("//a[@id='loginText']");
	By userName=By.xpath("//input[@id='userId']");
	By passWord=By.xpath("//input[@id='pwd']");
	By captcha=By.xpath("//input[@id='nlpAnswer']");
	By submit=By.xpath("//button[@type='submit' and contains(text(),'SIGN IN')]");
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void loginIntoIRCTC(String user,String pwd) {
		driver.findElement(loginButton).click();
		driver.findElement(userName).sendKeys(user);
		driver.findElement(passWord).sendKeys(pwd);
		
		WaitMethodsClass.sleepMethod(3000);
		if(ExpectedConditions.elementToBeClickable(captcha) != null)
			driver.findElement(captcha).click();
		
		//providing user a time span of 10 sec to enter captcha on the page
		WaitMethodsClass.sleepMethod(10000);
		
		WaitMethodsClass.webDriverWait(driver.findElement(submit),driver);
		driver.findElement(submit).click();
		
	}

	
}
