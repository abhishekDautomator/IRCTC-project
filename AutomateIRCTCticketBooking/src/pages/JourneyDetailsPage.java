package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//import Utillities.HandleWebElements;
import Utillities.ReadFromExcel;
import Utillities.WaitMethodsClass;

public class JourneyDetailsPage {
	
	WebDriver driver;
	
	String classes=ReadFromExcel.getCellData("IRCTC_JourneyDetails",3,1);
	String from=ReadFromExcel.getCellData("IRCTC_JourneyDetails", 0,1);
	String to=ReadFromExcel.getCellData("IRCTC_JourneyDetails", 1,1);
	String date=ReadFromExcel.getCellData("IRCTC_JourneyDetails", 2, 1);
	
	By fromStation=By.xpath("//input[@placeholder='From*']");
	By toStation=By.xpath("//input[@placeholder='To*']");
	By journeyDate=By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']");
	By clickClassCategory=By.xpath("//label[contains(text(),'All Classes')]");
	By selectFromClassOptions=By.xpath("//span[contains(text(),'"+classes+"')]");
	By clickFindTrainsButton=By.xpath("//button[@label='Find Trains']");
	
	public JourneyDetailsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void submitJourneyDetails() {
		WaitMethodsClass.sleepMethod(1000);
		driver.findElement(fromStation).sendKeys(from);
		driver.findElement(toStation).sendKeys(to);
		driver.findElement(journeyDate).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE,date);
		driver.findElement(clickClassCategory).click();
		WaitMethodsClass.sleepMethod(1000);
		driver.findElement(selectFromClassOptions).click();
		driver.findElement(clickFindTrainsButton).click();
	}
}
