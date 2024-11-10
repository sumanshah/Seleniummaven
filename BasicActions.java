package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicActions {
	
	WebDriver driver;
	String baseurl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
	   	driver.get(baseurl);
	   	
	   	driver.findElement(By.xpath("//div[@id='USERNAME_FIELD']//input[@id='USERNAME_FIELD-inner']")).sendKeys("Strivedi");
	   	System.out.println("Send keys to username field");
	   	driver.findElement(By.id("PASSWORD_FIELD-inner")).sendKeys("Narayan#11");
	   	System.out.println("Send keys to password field");
	   	driver.findElement(By.xpath("//div[@id='USERNAME_FIELD']//input[@id='USERNAME_FIELD-inner']")).clear();
	   	System.out.println("Clearing username field");
	   	
	}
	
	@After
	public void tearDown() throws Exception {
	 driver.quit();
	}
	

	

}
