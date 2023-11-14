package tek.capston.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import io.cucumber.core.backend.Options;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadless<ChromeOptions> implements Browser {
    
	public WebDriver openBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		Options.addArguments = ("--headless");
		WebDriver driver = new ChromeDriver();
		driver.get(url);;
		return driver; 
		
	}
}
1zz