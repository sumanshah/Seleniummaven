package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class IdXPathDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		String baseurl = "http://10.144.97.192:8090/JEPIOT/";
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Suman5.Saha");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sit@0708");
		driver.findElement(By.xpath("//input[@value='Login']")).click();	
		System.out.println();
	}

}
