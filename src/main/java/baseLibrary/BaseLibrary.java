package baseLibrary;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {
	
	public static WebDriver driver;
	FileInputStream fis;
	String file = "D:\\GoogleProject\\TestData\\config.properties";
	
	public void launchURL(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getdata(String key) {
		String value = "";
		try {
			fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void doubleclick(WebElement ele) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele);
			action.clickAndHold(ele);
			action.doubleClick().build().perform();
		}

		catch (Exception e) {
			System.out.println("Issue in double click action " + e);
		}
	}
	
	public static void scrollByXPath(WebElement xpath) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", xpath);
		} catch (Exception e) {
			System.out.println("Issue in ScrollByxpath" + e);
		}
	}

}
