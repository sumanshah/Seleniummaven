package selenium;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.GenericMethods;

public class JavaScriptClick1 {
	WebDriver driver;
    String baseurl;
	JavascriptExecutor js;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		 
		js = (JavascriptExecutor)driver;
		
		gm = new GenericMethods(driver);
		//navigation
		driver.get(baseurl);
		//js.executeAsyncScript("window.location = 'https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled'");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		
	}

	@Test
	public void test() {
		//
		WebElement username = (WebElement)js.executeScript("return document.getElementById('USERNAME_FIELD-inner')");
		//WebElement username = gm.getElement("USERNAME_FIELD-inner", "id");
		username.sendKeys("strivedi");
		
		WebElement password = gm.getElement("PASSWORD_FIELD-inner", "id");
		password.sendKeys("Narayan#11");
		
		WebElement loginClick = gm.getElement("//span[contains(@class,'sapUiSraDisplayBeforeLogin')]", "xpath");
		System.out.println("LoginClick is displayed " + loginClick.isDisplayed());
		
		loginClick.click();
		System.out.println("LoginClick is Selected" + username.isSelected());
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		
	}
	
	

	

}
