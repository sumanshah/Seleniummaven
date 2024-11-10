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

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import selenium.GenericMethods;
import selenium.GenericMethodsList;

public class GenericMethodsDemo {
	private WebDriver driver;
	private String baseurl;
	private GenericMethods gm;
	private GenericMethodsList gml;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		gm = new GenericMethods(driver);
		gml = new GenericMethodsList(driver);
		
		//maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}

	@Test
	public void test() {
		driver.get(baseurl);
		
		WebElement e1 = gm.getElement("//input[@id='USERNAME_FIELD-inner']", "xpath");
		e1.sendKeys("Strivedi");
		
		WebElement e2 = gm.getElement("//input[@id='PASSWORD_FIELD-inner']", "xpath");
		e2.sendKeys("Narayan#11");
		
		WebElement e3 = gm.getElement("//span[contains(text(), 'Log On') and contains(@class, 'sapMBtnContent sapMLabelBold sapUiSraDisplayBeforeLogin')]", "xpath");
		e3.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		List<WebElement> elementList = gml.getElementList("//input[contains(@id,'__tile')]", "id");
		
		int size = elementList.size();
		
		System.out.println("Size of the element list is: " + size);
		
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}



}
