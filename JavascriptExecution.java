package selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecution {
     private WebDriver driver;
     String baseurl;
     public JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		js = (JavascriptExecutor)driver;
	
	}

	@Test
	public void testJavascriptExecution() throws Exception {
		//Navigation
		js.executeScript("window.location = 'https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled';");
		//finding element
		//WebElement textbox = driver.findElement(By.xpath("//input[@id = 'USERNAME_FIELD-inner']"));
	     
		Thread.sleep(3000);
		WebElement textbox = (WebElement) js.executeScript("return document.getElementById('USERNAME_FIELD-inner')");
		
		textbox.sendKeys("Strivedi");
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
