package org.tyss.genricUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains all the js reusable methods
 * @author yogi
 *
 */
public final class JsExecutorUtility {
	private JavascriptExecutor js;

	/**
	 * This method is to execute js
	 * @param driver
	 */
	public void initJsExecutor(WebDriver driver) {
		js = (JavascriptExecutor) driver;

	}
	public void navigateApp(String url){
		js.executeScript("window.location=argument[0]", url);

	}

	/**
	 * This method is for navigate app
	 * @param element
	 * @param data
	 */
	public void navigateApp(WebElement element,String data){
		js.executeScript("argument[0].click()", element);

	}
	/**
	 * This method is used to send data to textfield useing jsexecutor
	 * @param element
	 * @param data
	 */
	public void enterData(WebElement element,String data) {
		js.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	/**
	 * This method is used to click on element using jsexecutor	
	 * @param element
	 */
	public void clickOnElement(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * This method is used to scroll till the end of page
	 * @param strategy
	 */
	public void scrollTillEnd(String strategy) {
		//		String sign=null;
		//		if(strategy.equalsIgnoreCase("up"))
		String sign = strategy.equalsIgnoreCase("up") ? "-": "+";

		js.executeScript("window.scrollBy(0,"+sign+"+document.body.scrollHight)");

	}
	/**
	 * This method is used to scroll till some position 
	 * @param y_position
	 */
	public void scrollTillSomePosition(int y_position,String strategy) {
		String sign=strategy.equalsIgnoreCase("up") ? "-": "+";
		js.executeScript("window.scrollBy(0,"+sign+"arguments[0]",y_position);	
	}
	/**
	 * This method is used to scroll till element is visible
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * This method is used to highlight the element
	 * @param element
	 */
	public void highlightElement(WebElement element) {
		js.executeScript("aeguments[0].setAttribute('style','border:5px solid red;')", element);
	}


}
