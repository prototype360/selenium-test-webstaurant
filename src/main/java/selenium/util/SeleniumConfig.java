package selenium.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author prototype360
 *
 */

public class SeleniumConfig {
	private static String propertiesFile = System.getProperty("user.dir") + "/src/test/resources/test.properties";
	public static WebDriver driver;
	public static Wait<WebDriver> wait;

	public SeleniumConfig(){
		
	}
	
	public static void startBrowser() throws FileNotFoundException, IOException {
		Properties pf = new Properties();
		pf.load(new FileInputStream(propertiesFile));
		
		System.setProperty("webdriver.chrome.driver", pf.getProperty("driver"));

		boolean isHeadless = Boolean.parseBoolean(pf.getProperty("headless"));
		ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        //browserOptions.setBrowserVersion("123.0.6312.124");
        HashMap<String, Object> tcOptions = new HashMap<String, Object>();
        tcOptions.put("project", "selenium-test");
        tcOptions.put("w3c", true);
        if(isHeadless) {
        	browserOptions.addArguments("--headless=new");
        }
        tcOptions.put("build", "Demonstration: selenium-test with WebDriverManager");
        browserOptions.setCapability("Test Case:Options", tcOptions);

        WebDriverManager webDriverManager = WebDriverManager.chromedriver().capabilities(browserOptions);
        webDriverManager.setup();
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.webstaurantstore.com/");
        driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofMillis(60000));

	}
	
	public void closeBrowser() throws IOException {
		driver.manage().deleteAllCookies();
		driver.quit();
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
	}
		
}
