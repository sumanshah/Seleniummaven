package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitTypes {

	WebDriver driver;
	
	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElement(By locator, int timeouts ) {
		WebElement element = null;
		
		try {
			System.out.println("Waiting for max::" + timeouts + "seconds for elemt to be available");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
			System.out.println("Element appeared on WebPage");
		
	}catch(Exception e) {
		System.out.println("Element not appeared on WebPage");
}
		return element;		
}
	
}