package selenium;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
	WebDriver driver;
	JavascriptExecutor js;
	String baseurl;
	GenericMethods gm;
	
	

	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		gm = new GenericMethods(driver);
		
		baseurl = "https://fiori.ril.com/sap/bc/ui5_ui5/sap/zhr_jioess_lp/index.html?sap-client=586&sap-ui-language=EN&sap-ui-appcache=false";
		
		//driver.get(baseurl);
		js.executeScript("window.location = 'https://fiori.ril.com/sap/bc/ui5_ui5/sap/zhr_jioess_lp/index.html?sap-client=586&sap-ui-language=EN&sap-ui-appcache=false'");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		
	}

	@Test
	public void test() throws InterruptedException {
		
		WebElement ANL = gm.getElement("//li//a[contains(text(),'Attendance') and contains(@for,'collapseOne')]", "xpath");
		ANL.click();
		
		WebElement AttendanceAndLeaveClick = gm.getElement("//li//a[contains(text(),'Attendance') and contains(@target,'_blank')]", "xpath");
		//AttendanceAndLeaveClick.click();
		js.executeScript("arguments[0].click()", AttendanceAndLeaveClick);
		
		Thread.sleep(2000);
		
		System.out.println(AttendanceAndLeaveClick.isDisplayed());
		String Parenthandle = driver.getWindowHandle();
		
		
		System.out.println("Parent Source is : " + Parenthandle);	
		
		//get all handles
		Set<String> handles = driver.getWindowHandles();
		
		//switching between handles
		for(String handle : handles ) {
			System.out.println(handle);
			if(!handle.equals(Parenthandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(5000);
				driver.close();
				break;
			}
			
			driver.switchTo().window(Parenthandle);
			Thread.sleep(9000);
		}
	}

	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
}
