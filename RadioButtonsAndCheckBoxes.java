package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsAndCheckBoxes {

	WebDriver driver;
	String baseurl; 
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='USERNAME_FIELD']//input[@id='USERNAME_FIELD-inner']")).sendKeys("Strivedi");
		driver.findElement(By.xpath("//div[@id='PASSWORD_FIELD']//input[@id='PASSWORD_FIELD-inner']")).sendKeys("Narayan#11");
		driver.findElement(By.xpath("//span[contains(@class,'sapUiSraDisplayBeforeLogin') and contains(text(),'Log On')]")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[contains(@class,'sapUshellTileBase') and contains(@title,'CAF Create New')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Mobility = driver.findElement(By.id("idMobility-Button"));
		Mobility.click();
		Thread.sleep(2000);
		
		WebElement IoTPlatform = driver.findElement(By.id("idIOT-Button"));
		IoTPlatform.click();
		Thread.sleep(2000);
		
		WebElement SubsChange = driver.findElement(By.id("idSubChng-Button"));
		SubsChange.click();
		Thread.sleep(2000);
		
		WebElement IotConnectivity = driver.findElement(By.id("idIOTMob-Button"));
		IotConnectivity.click();
		Thread.sleep(2000);
		
		WebElement JioLink = driver.findElement(By.id("idJioLink-Button"));
		JioLink.click();
		Thread.sleep(2000);
		
		WebElement Jiofi = driver.findElement(By.id("idJIOFI-Button"));
		Jiofi.click();
		Thread.sleep(2000);
		
		WebElement HQTransfer = driver.findElement(By.id("idHtoH-Button"));
		HQTransfer.click();
		Thread.sleep(2000);

		WebElement JioAirfibre = driver.findElement(By.id("idAirFiber-Button"));
		JioAirfibre.click();
		Thread.sleep(2000);
		
		
		System.out.println("Mobility radio button selected? " + Mobility.isSelected());
		System.out.println("IoTPlatform radio button selected? " + IoTPlatform.isSelected());
		System.out.println("SubsChange radio button selected? " + SubsChange.isSelected());
		System.out.println("JioLink radio button selected? " + JioLink.isSelected());
		System.out.println("Jiofi radio button selected? " + Jiofi.isSelected());
		System.out.println("HQ Transfer radio button selected? " + HQTransfer.isSelected());
		System.out.println("Airfibre radio button selected? " + JioAirfibre.isSelected());	
		
		driver.findElement(By.id("idClick-inner")).click();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	

}
