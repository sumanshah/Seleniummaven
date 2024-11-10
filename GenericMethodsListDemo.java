package selenium;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.GenericMethodsList;
import selenium.GenericMethods;

public class GenericMethodsListDemo {
	private WebDriver driver;
	private String baseurl;
	private GenericMethods gm;
	private GenericMethodsList gml;
	

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		gml = new GenericMethodsList(driver);
		gm = new GenericMethods(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test
	public void test() {
		driver.get(baseurl);
		
		//List<WebElement> elementList = gml.getElementList("//input[contains(@id,'__tile')]", "id");
		
		List<WebElement> elementList = gml.getElementList("//div[contains(@id,'USER')]", "xpath");
		
		int size = elementList.size();
		
		System.out.println("elementList size is : " + size);		
		
		boolean result1 = gml.isElementPresent("//div[contains(@id,'USER')]", "xpath");
		System.out.println("size of element list is : " + result1);
		
		
	}

	@After
	public void tearDown() throws Exception {
	
		Thread.sleep(3000);
	}
	

}
