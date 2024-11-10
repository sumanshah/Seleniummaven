package selenium;

import static org.junit.Assert.*;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
	WebDriver driver;
	String baseurl;

	
	@Before
	public void setUp() throws Exception {
	driver = new ChromeDriver(); 
	baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		
	//maximize the browser
	driver.manage().window().maximize();
	
	}

	@Test
	public void test() {
		driver.get(baseurl);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("USERNAME_FIELD")));
		emailField.sendKeys("Strivedi");
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	

}
