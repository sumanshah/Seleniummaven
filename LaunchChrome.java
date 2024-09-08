package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;

public class LaunchChrome {

	public static void main(String[] args) {
	  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suman5.Saha\\OneDrive - Reliance Corporate IT Park Limited\\Desktop\\SM\\Automation\\chromedriver_win32 (6)\\chromedriver.exe");
     // String driverPath = SeleniumManager.getInstance().;
	  WebDriver driver = new ChromeDriver();
	  String baseURL = "https://www.youtube.com/watch?v=YyB2NGV69xE&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT";
	  driver.get(baseURL);
	  System.out.println(driver.getTitle());
	  driver.quit();
	  
	}

}
