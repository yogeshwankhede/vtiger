package org.vtiger.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement actualCampaignNameText;
	
	//business library
	
	public String getActualCamoainName() {
		return actualCampaignNameText.getText();
	}
	
	
}
