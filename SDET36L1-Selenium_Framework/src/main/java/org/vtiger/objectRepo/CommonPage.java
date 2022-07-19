package org.vtiger.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genricUtilities.WebDriverUtil;

public class CommonPage {
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[.='More]")
	private WebElement moreTab;
	
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campTab;
	
	@FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement adminIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	/**
	 * This method is used to click on campaign tab in common page
	 * @param webdriverUtility
	 */
	public void clickCampaign(WebDriverUtil webdriverUtility) {
		webdriverUtility.mouseHoverOnElementAndClick(moreTab);
	}
	/**
	 * This method is used to signout from the app
	 * @param webdriverUtility
	 */
	
	public void logoutAction(WebDriverUtil webdriverUtility) {
		webdriverUtility.mouseHoverOnElementAndClick(adminIcon);
		signOutLink.click();
	}

}
