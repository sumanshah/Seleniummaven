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
import java.util.concurrent.TimeUnit;



public class ElementState {
	WebDriver driver;
	String baseurl;

	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseurl = "www.google.com";
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void test() {
    WebElement e1 = driver.findElement(By.id("APjFqb"));
    e1.sendKeys("Udemy");
    System.out.println("E1 ");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();	
	}

	
}
