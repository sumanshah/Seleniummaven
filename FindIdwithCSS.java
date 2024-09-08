package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindIdwithCSS {
	
		public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input#USERNAME_FIELD-inner")).sendKeys("Strivedi"); //CSS selector - by id
		driver.findElement(By.cssSelector("input[id='PASSWORD_FIELD-inner']")).sendKeys("Narayan#11"); //CSS selector - by id
		driver.findElement(By.cssSelector(".sapMBtnContent.sapMLabelBold.sapUiSraDisplayBeforeLogin")).click(); //CSS selector - by class
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@id, 'tile25') and contains(@title, 'CAF')]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@id, 'idMobility-Button' ) and contains(@class, 'sapMRbBOut')]")).click();
		driver.findElement(By.xpath("//div[contains(@id, 'idClick-inner')]//span[contains(@class, 'sapMBtnContent')]")).click();
	
		}

}
