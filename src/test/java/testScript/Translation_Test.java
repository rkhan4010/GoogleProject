package testScript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageHelper.Translation_Page;

public class Translation_Test extends Translation_Page {
	
	@BeforeTest
	public void launched_URL() {
		launchURL(getdata("URL"));
	}
	
	@Test
	public void isTranslation_Complete() {
		Translation_Page object = new Translation_Page();
		object.isTranslate();
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}
