package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateBetweenPages {

	WebDriver driver;
	String baseurl;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "https://nwgwtgs.bss.sit.jio.com/sap/bc/ui5_ui5/ui2/ushell/shells/abap/fiorilaunchpad.html?saml2=disabled";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseurl);
		String title = driver.getTitle();
		System.out.println("Title of the page : " + title );
		
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL of page is : " + currenturl);
		
		String urltonavigate = "http://10.144.97.192:8090/JEPIOT/";
		driver.navigate().to(urltonavigate);
		currenturl = driver.getCurrentUrl();
		System.out.println("Current URL of page is : " + currenturl);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Navigate back");
		currenturl = driver.getCurrentUrl();
		System.out.println("Current URL of page is : " + currenturl);
		
		driver.navigate().forward();
		System.out.println("Navigate forward");
		currenturl = driver.getCurrentUrl();
		System.out.println("Current URL of page is : " + currenturl);
		
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Navigate back");
		currenturl = driver.getCurrentUrl();
		System.out.println("Current URL of page is : " + currenturl);
		
		driver.navigate().refresh();
		System.out.println("Navigate Refresh");
		
		String pagesource = driver.getPageSource();
		System.out.println(pagesource);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}

	

}

