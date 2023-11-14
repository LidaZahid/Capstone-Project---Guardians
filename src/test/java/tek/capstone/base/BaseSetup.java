package tek.capstone.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.devtools.v110.browser.Browser;

import tek.bdd.guardians.config.ChromeBrowser;
import tek.bdd.guardians.config.ChromeHeadless;
import tek.bdd.guardians.config.EdgeBrowser;
import tek.bdd.guardians.utilities.ReadYamlFiles;
import tek.capston.config.FireFoxBrowser;




public class BaseSetup {
	
	 private static WebDriver webDriver;
	    private final ReadYamlFiles environmentVariables;
	    public static Logger logger;
	    
	    public BaseSetup() {
	        String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
	        String log4JPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
	        environmentVariables = (ReadYamlFiles) ReadYamlFiles.getInstance(filePath);
	        
	        logger = logger.getLogger("logger_File");
	        PropertyConfigurator.configure(log4JPath);
	    }
	    
	    public WebDriver getDriver() {
	        return webDriver;   
	        }
	    
	    public void setupBrowser() {
	        HashMap uiProperties = ((Object) environmentVariables).getYamlProperty("ui");
	        System.out.println(uiProperties);
	        String url = uiProperties.get("url").toString();
	        ChromeHeadless browser;
	        switch (uiProperties.get("browser").toString().toLowerCase()) {
	        case "chrome":
	            if ((boolean) uiProperties.get("headless")) {
	                browser = new ChromeHeadless();
	            } else {
	                browser = new ChromeBrowser();
	            }
	            webDriver = browser.openBrowser(url);
	            break;
	        case "firefox":
	            browser = new FireFoxBrowser();
	            webDriver = browser.openBrowser(url);
	            break;
	        case "edge":
	            browser = new EdgeBrowser();
	            webDriver = ((ChromeBrowser) browser).openBrowser(url);
	            break;
	        default:
	            throw new RuntimeException("Unknown Browser check environment properties");
	        }
	        
	        webDriver.manage().window().maximize();
	        webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
	        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    }
	    
	    public void quitBrowser() {
	        if(webDriver !=null)
	            webDriver.quit();
	    }
}

	
	
	
	
	
	


