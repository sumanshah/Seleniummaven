package selenium;

import org.openqa.selenium.*;
import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class PractiseClass {
	
	WebDriver driver;
	String baseurl;
	

	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		driver.get(baseurl);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='USERNAME_FIELD-inner']")).sendKeys("Strivedi");
		driver.findElement(By.xpath("//input[@id='PASSWORD_FIELD-inner']")).sendKeys("Narayan#11");
		driver.findElement(By.xpath("//span[contains(text(), 'Log On') and contains(@class, 'sapMBtnContent sapMLabelBold sapUiSraDisplayBeforeLogin')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@data-targeturl='#ZCORPORATE_HEADQUARTER_SO-display']")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("sapMTileContent")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@id,'idCHCompanyName')]//input[@class='sapMInputBaseInner']")).sendKeys("Create Auto HQ");
		driver.findElement(By.xpath("//input[contains(@id,'idCHPANNumber-inner')]")).sendKeys("ASDCG7896H");
		driver.findElement(By.xpath("//span[contains(@id,'idCHRegistrationType')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Bank Statement')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'idCHCompanyRegistrationNumber-inner')]")).sendKeys("87654345");
		driver.findElement(By.xpath("//div[contains(@id,'idRadioNoDomain-Button')]")).click();
		driver.findElement(By.xpath("//span[contains(@id,'idCHCompanyStatus-arrow')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'PRIVATE SECTOR')]")).click();
		driver.findElement(By.xpath("//span[contains(@id,'idCHIndustryType-arrow')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'BFSI')]")).click();
		driver.findElement(By.xpath("//button[contains(@id,'idEnterpriseType-arrow')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Enterprise  Medium (ME) - Services')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'idCHHouseFlatNumberName-inner')]")).sendKeys("1167");
		driver.findElement(By.xpath("//input[contains(@id,'idCHBuildingNumberName-inner')]")).sendKeys("BK11");
		driver.findElement(By.xpath("//input[contains(@id,'idCHPin-inner')]")).sendKeys("752017");
		driver.findElement(By.xpath("//input[contains(@id,'idCHCity-inner')]")).sendKeys("Puri");
		driver.findElement(By.xpath("//span[contains(@id,'idCHRegion-arrow')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'ODISHA')]")).click();
		Thread.sleep(3000);
	
		WebElement e1 = driver.findElement(By.xpath("//select[contains(@id,'CHR4GState')]"));
	
		 Actions actions = new Actions(driver);
		 actions.moveToElement(e1).click().perform();
		 
		WebElement e2 = driver.findElement(By.xpath("//li[contains(text(),'ODISHA') and contains(@id,'idCHR4GState')]"));
		actions.moveToElement(e2).click().perform();
		 
		Select s = new Select(e1);
		Thread.sleep(3000);
		s.selectByVisibleText("ODISHA");
		
		Thread.sleep(3000);
		
		WebElement e3 = driver.findElement(By.xpath("//span[contains(@id,'idCHR4GCity')]"));
		actions.moveToElement(e3).click().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e3);
		
		WebElement e4 = driver.findElement(By.xpath("//li[contains(text(),'PURI') and contains(@id,'idCHR4GCity')]"));
		actions.moveToElement(e4).click().perform();
		 
		  
		Select s1 = new Select(e3);
		Thread.sleep(3000);
		s1.selectByVisibleText("PURI");
		
		
		driver.findElement(By.xpath("//span[contains(@id,'idCHR4GState-arrow')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[contains(@id,'__list20')]//li[contains(text(),'ODISHA')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@id,'idCHR4GCity-arrow')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'PURI')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@id,'idCHJioCenter-arrow')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'I136/PURI, ORISSA')]")).click();
		Thread.sleep(3000);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
		
	}

	

}
