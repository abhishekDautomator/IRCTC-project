package Utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HandleWebElements {
	
	static WebDriver driver;
	
	public HandleWebElements(WebDriver driver) {
		HandleWebElements.driver=driver;
	}
	
	public Actions actionMethod() {
		Actions act=new Actions(driver);
		
		return act;
	}
	
	public Select selectMethod(WebElement ele) {
		Select sel=new Select(ele);
		return sel;
	}

}
