package tek.capston.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser implements Browser {
	
	public WebDriver openBrowser(String url) { 
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get(url);
		return driver;
		
	}

	@Override
	public String browserName() {
		// TODO Auto-generated method stub
		return null;
	}

}
