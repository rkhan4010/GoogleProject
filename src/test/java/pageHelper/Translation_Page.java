package pageHelper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.BaseLibrary;

public class Translation_Page extends BaseLibrary {

	public Translation_Page() {
		PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//div[@class='aCQag']//button[@aria-label='More source languages']//div[@class='VfPpkd-Bz112c-RLmnJb']")
	private WebElement Dropdown_From;
	
	@FindBy(xpath ="//c-wiz[@class='bvzp8c Tht3fc']//div[@class='OoYv6d']//div[@class='F29iQc']//div[@class='Llmcnf'][normalize-space()='English']")
	private WebElement Language_English;
	
	@FindBy(xpath="//div[@class='aCQag']//button[@aria-label='More target languages']//div[@class='VfPpkd-Bz112c-RLmnJb']")
	private WebElement Dropdown_To;
	
	@FindBy(xpath="//c-wiz[@class='bvzp8c DlHcnf']//div[@class='ykTHSe']//div[@class='F29iQc']//div[@class='Llmcnf'][normalize-space()='Hindi']")
	private WebElement Language_Hindi;
	
	@FindBy(xpath="//textarea[@aria-label='Source text']")
	private WebElement Text_Area;
	
	@FindBy(xpath="//span[@class='ryNqvb']")
	private WebElement Get_Text;
	
	public void isTranslate() {
		try {
			Dropdown_From.click();
			Language_English.click();
			Dropdown_To.click();
			scrollByXPath(Language_Hindi);
			Language_Hindi.click();
			Text_Area.click();;
			Text_Area.sendKeys("Test");
			Thread.sleep(2000);
			String actual = Get_Text.getText();
			Assert.assertEquals(actual, "परीक्षा");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
