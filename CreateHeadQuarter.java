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


public class CreateHeadQuarter {
	WebDriver driver;
	String baseurl;
	JavascriptExecutor js;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor)driver;
		gm = new GenericMethods(driver);	
		
		baseurl = "\"https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled\"";
		
		//navigation
				//driver.get(baseurl);
				js.executeScript("window.location = 'https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled\'");
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		WebElement username = (WebElement)js.executeScript("return document.getElementById('USERNAME_FIELD-inner')");
		username.sendKeys("Strivedi");
		
		WebElement password = (WebElement)js.executeScript("return document.getElementById('PASSWORD_FIELD-inner')");
		password.sendKeys("Narayan#11");
		
		WebElement LoginClick = (WebElement)js.executeScript("return document.getElementById('LOGIN_LINK')");
		
		System.out.println("loginclick is displayed : " + LoginClick.isDisplayed());
		LoginClick.click();
		
		WebElement CreateHQ = gm.getElement("//div[contains(@title,'Headquarters')]", "xpath");
		CreateHQ.click();
		
		//__xmlview2--idCHR4GState-arrow
		
		WebElement CreateHqClick = gm.getElement("//div[contains(text(),'Create HeadQuarter')]", "xpath");
		CreateHqClick.click();
		
		Thread.sleep(3000);
		
		WebElement r4GStateArrowClick = (WebElement) js.executeScript("return document.getElementById('__xmlview2--idCHR4GState-arrow')");
		//r4GStateArrowClick.click();
		
		System.out.println("r4GStateArrowClick is displayed : " + r4GStateArrowClick.isDisplayed());
		
		js.executeScript("arguments[0].click()", r4GStateArrowClick);
		
		Thread.sleep(3000);
		
		WebElement r4GState = (WebElement) js.executeScript("return document.getElementById('__item9-__xmlview2--idCHR4GState-20')");
		
		System.out.println("r4GState is displayed : " + r4GState.isDisplayed());
		js.executeScript("arguments[0].click", r4GState);
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000);
		//driver.quit();
	}

	

}
