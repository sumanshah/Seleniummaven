package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByClassNameDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String baseurl = "http://10.144.97.192:8090/JEPIOT/";
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("tooltip")).click();;
		
	}

}
