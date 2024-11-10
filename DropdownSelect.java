package selenium;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
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
		
		WebElement E1 = driver.findElement(By.id("idMobility-Button"));
		E1.click();
		
		driver.findElement(By.id("idClick-inner")).click();
		
		WebElement element = driver.findElement(By.xpath("//div[contains(@id, '__popover0-scroll')]//ul[contains(@class,'sapMSelectList') and contains(@role,'listbox')]"));
		
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Selection New CAF");
		sel.selectByIndex(0);
		
		Thread.sleep(2000);
		
		WebElement E2 = driver.findElement(By.xpath("//div[contains(@id, '__popover1-scroll')]//ul[contains(@class,'sapMSelectList') and contains(@role,'listbox')]"));
		
		Select sel1 = new Select(E2);
		System.out.println("Postpaid CAF");
		sel1.selectByValue("Postpaid");
		
		Thread.sleep(2000);
		
		List<WebElement> opt1 = sel.getOptions();
		int size1 = opt1.size();
		System.out.println(size1);
		for(int i =0; i<size1; i++) {
			String OptionName = opt1.get(i).getText();
			System.out.println(OptionName);
		}
		
		List<WebElement> opt2 = sel1.getOptions();
		int size2 = opt2.size();
		System.out.println(size2);
		for(int j = 0; j< size2; j++) {
			String OptionN2 = opt2.get(j).getText();
			System.out.println(OptionN2);
		}
		
	}


	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	
}
