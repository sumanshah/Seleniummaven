package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebPage {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		String baseurl = "http://10.144.97.192:8090/JEPIOT/";
		driver.get(baseurl);

		System.out.println(driver.getTitle());
		driver.quit();
		

	}

}
