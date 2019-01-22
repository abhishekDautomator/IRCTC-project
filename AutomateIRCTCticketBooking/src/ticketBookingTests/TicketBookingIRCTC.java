package ticketBookingTests;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;




import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utillities.BrowserDrivers;
import Utillities.ConfigFileReader;
import Utillities.WaitMethodsClass;
import pages.JourneyDetailsPage;
import pages.LoginPage;
import pages.PassengersDetail;
import pages.TrainSelection;


public class TicketBookingIRCTC {
	static WebDriver driver;
	
	static String url=ConfigFileReader.readURL();
	static String username=ConfigFileReader.readUserName();
	static String password=ConfigFileReader.readPassword();
	
	@BeforeSuite
	public static void createDriverInstance() {
		driver=BrowserDrivers.chromeDriver();
		
	}
	
	@BeforeClass
	public static void openBrowser() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test()
	public static void login() {
		LoginPage login=new LoginPage(driver);
		login.loginIntoIRCTC(username, password);
		
	}
	
	@Test(dependsOnMethods={"login"})
	public static void fillingJouneyDetails() {
		WaitMethodsClass.sleepMethod(1000);
		JourneyDetailsPage fillJourneyDetails=new JourneyDetailsPage(driver);
		fillJourneyDetails.submitJourneyDetails();
	}
	
	@Test(dependsOnMethods={"fillingJouneyDetails"})
	public static void selectJourneyTrain() throws ParseException {
		WaitMethodsClass.sleepMethod(1000);
		TrainSelection selectTrain=new TrainSelection(driver);
		selectTrain.selectTrain();
	}
	@Test(dependsOnMethods= {"selectJourneyTrain"})
	public static void enterPassengerDetails() {
		WaitMethodsClass.sleepMethod(2000);
		PassengersDetail pd=new PassengersDetail(driver);
		pd.enterPassengerDetails();
	}
	@AfterSuite
	public static void closeBrowser() {
		//driver.close();
	}
	
	
	
}
