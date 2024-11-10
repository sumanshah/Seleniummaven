package selenium;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.GenericMethods;

public class ScreenshotsDemo {
	private WebDriver driver;
	private String baseurl;
	private GenericMethods gmt;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		gmt = new GenericMethods(driver);
	}
	
	@Test
	public void test() throws Exception {
		WebElement username = gmt.getElement("//input[contains(@id,'USERNAME_FIELD')]", "xpath");
		username.sendKeys("strivedi");
		
		WebElement password = gmt.getElement("//input[contains(@id,'PASSWORD_FIELD-inner')]", "xpath");
		password.sendKeys("Narayan#11");
		
		WebElement loginClick = gmt.getElement("//span[contains(@class,'sapUiSraDisplayBeforeLogin')]", "xpath");
		loginClick.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
	}

	
	@After
	public void tearDown() throws Exception {
		//String filename = getRandomString(10) + ".png";
		//String directory =System.getProperty("user.dir") + "//Screenshots//";
		//File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(sourceFile, new File(directory + filename));	
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	public String takeScreenshot(WebDriver driver) {
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			fileInputStreamReader = new FileInputStream(sourceFile);
			byte[] bytes = new byte[(int) sourceFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.getEncoder().encode(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}
	
	public static String getRandomString(int Length) {
		StringBuilder sb = new StringBuilder();
		String Characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for(int i=0; i < Length; i++) {
			int index = (int)(Math.random() * Characters.length());
			sb.append(Characters.charAt(index));
		}
		return sb.toString();
	}

	

}
