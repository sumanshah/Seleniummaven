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

public class WorkingWithElementsList {
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
		
		boolean  isChecked = false;
		
		List<WebElement> radiobuttons = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'Rdg1')]"));
		int count = radiobuttons.size();
		System.out.println("Count of radiobutton : " + count);
		
		for(int j = 0; j<count; j++) {
			isChecked = radiobuttons.get(j).isSelected();
			
			if(!isChecked) {
				radiobuttons.get(j).click();
				Thread.sleep(2000);
				
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	

}
