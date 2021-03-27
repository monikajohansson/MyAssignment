package stepDefinitionsSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriveCreator {

	public WebDriver createBrowser(String browser) {
		WebDriver driver;

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // starta chrome
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); // starta firefox
		} else {
			System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver(); // starta edge
		}

		return driver;
	}
}
