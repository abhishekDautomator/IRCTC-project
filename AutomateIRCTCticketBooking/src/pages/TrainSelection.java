package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import pages.JourneyDetailsPage;
import Utillities.ReadFromExcel;
import Utillities.WaitMethodsClass;
import Utillities.DateConvertor;

public class TrainSelection {
	
	WebDriver driver;
	String trainNumber=ReadFromExcel.getCellData("IRCTC_JourneyDetails", 4, 1);
	String journeyDate=ReadFromExcel.getCellData("IRCTC_JourneyDetails", 2, 1);
	String date=DateConvertor.dateConvert(journeyDate);
	By train=By.xpath("//div[contains(@class,'train_avl')]//div[contains(text(),'"+trainNumber+"')]//..//../..//button[contains(text(),'Check availability')]");
	By book=By.xpath("//span[contains(text(),'"+date+"')]//..//..//button[contains(text(),'Book Now')]");
	By Continue=By.xpath("//button[contains(text(),'Continue')]");
	By confirm=By.xpath("//span[contains(text(),'continue')]//..//..//span[contains(text(),'Ok')]");
	public TrainSelection(WebDriver driver){
		this.driver=driver;
	}	
	
	public void selectTrain() {
		
		WaitMethodsClass.sleepMethod(2000);
		
		WebElement e=driver.findElement(train);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",e);
		driver.findElement(train).click();
		WaitMethodsClass.sleepMethod(2000);
		driver.findElement(book).click();
		WaitMethodsClass.sleepMethod(1000);
		driver.findElement(Continue).click();
		WaitMethodsClass.sleepMethod(1000);
		driver.findElement(confirm).click();
	}
	
	
}
