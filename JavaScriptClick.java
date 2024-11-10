package selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptClick {
	private WebDriver driver;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor)driver;	
	}
	
	@Test
	public void test() {
		//navigation
		js.executeScript("window.location = 'https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled'");
		
		//click on element
		WebElement checkboxElement = (WebElement)js.executeScript("return document.getElementById('LOGIN_LINK');");
		
		js.executeScript("arguments[0].click", checkboxElement);
		
		WebElement textbox = (WebElement)js.executeScript("return document.getElementById('USERNAME_FIELD-inner');");
		textbox.sendKeys("strivedi");		
	    
		
	}

	@After
	public void tearDown() throws Exception {
		
	}



}
