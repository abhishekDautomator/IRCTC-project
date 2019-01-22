package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Utillities.*;

public class PassengersDetail {
	WebDriver driver;
	Select sel;
	String passengerName;
	String passengerAge;
	String passengerGender;
	String passengerBerth;
	String passengerCountry;
	int numOfPassenger=Integer.parseInt(ReadFromExcel.getCellData("IRCTC_PassengerDetails", 1, 1));
	String mobileNumber;
	public PassengersDetail(WebDriver driver){
		this.driver=driver;
	}
	
	HandleWebElements hwe=new HandleWebElements(driver);
	
	
	public void enterPassengerDetails(){
		
		
		int column=1;
		
		
		while(numOfPassenger!=0) {
			
			passengerName=ReadFromExcel.getCellData("IRCTC_PassengerDetails",3, column);
			passengerAge=ReadFromExcel.getCellData("IRCTC_PassengerDetails",4, column);
			passengerGender=ReadFromExcel.getCellData("IRCTC_PassengerDetails",5, column);
			passengerBerth=ReadFromExcel.getCellData("IRCTC_PassengerDetails",6, column);
			passengerCountry=ReadFromExcel.getCellData("IRCTC_PassengerDetails",7, column);
			
			By name=By.xpath("(//input[@id='psgn-name'])["+column+"]");
			By age=By.xpath("(//input[@placeholder='Age'])["+column+"]");
			By gender=By.xpath("(//select[@formcontrolname='passengerGender'])["+column+"]");
			By berth=By.xpath("(//select[@formcontrolname='passengerBerthChoice'])["+column+"]");
			By country=By.xpath("(//select[@formcontrolname='passengerNationality'])["+column+"]");
			
			WaitMethodsClass.sleepMethod(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(name));
			
			driver.findElement(name).sendKeys(passengerName);
			driver.findElement(age).sendKeys(passengerAge);
			
			sel=hwe.selectMethod(driver.findElement(gender));
			sel.selectByVisibleText(passengerGender);
			
			
			sel=hwe.selectMethod(driver.findElement(berth));
			sel.selectByVisibleText(passengerBerth);
			
			
			sel=hwe.selectMethod(driver.findElement(country));
			sel.selectByVisibleText(passengerCountry);
			
			numOfPassenger--;
			column++;
			
			if(numOfPassenger!=0) {
				By addNewPassenger=By.xpath("//span[contains(text(),'+ Add Passenger')]");
				
				driver.findElement(addNewPassenger).click();
			}
			
		}
		 
			mobileNumber=ReadFromExcel.getCellData("IRCTC_PassengerDetails",9,1);
			By mobile=By.xpath("//input[@id='mobileNumber']");
			driver.findElement(mobile).clear();
			driver.findElement(mobile).sendKeys(mobileNumber);
			
			//Pausing the tool for 9 sec to enter the captcha
			By captcha=By.xpath("//div[contains(@class,'passengerDivSep')]//input[@id='nlpAnswer']");
			driver.findElement(captcha).click();
			WaitMethodsClass.sleepMethod(9000);
			
			By submit=By.xpath("//button[contains(text(),'Continue Booking')]");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(submit));
			driver.findElement(submit).click();
			
			WaitMethodsClass.sleepMethod(2000);
			By confirm=By.xpath("//div[contains(@class,'panel-primary')]//..//button[contains(text(),'Continue Booking')]");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(confirm));
			driver.findElement(confirm).click();
	}


}
