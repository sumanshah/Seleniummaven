package selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSize {
    private WebDriver driver;
    String baseurl;
	private JavascriptExecutor js;
    
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		//navigation
		js.executeScript("window.location = 'https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled'");
		
		//Size of Window
		Long height = (Long)js.executeScript("return window.innerHeight;");
		Long width = (Long)js.executeScript("return window.innerWidth;");
		
		System.out.println("Height of window is : " + height);
		System.out.println("Width of window is : " + width);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	

}
