package com.feature.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practicePage {

	WebDriver driver;
	JavascriptExecutor js;

	public practicePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@id='radio-btn-example']//input")
	List<WebElement> radioBtn;

	@FindBy(xpath = "//div[@id='checkbox-example-div']//input")
	List<WebElement> checkBox;

	@FindBy(xpath = "//button[@id='openwindow']")
	WebElement openWindow;

	@FindBy(xpath = "//a[@id='opentab']")
	WebElement openTab;

	@FindBy(xpath = "//select[@id='carselect']")
	WebElement selectClass;

	@FindBy(xpath = "//select[@id='multiple-select-example']")
	WebElement multipleSelect;

	@FindBy(xpath = "//input[@id='autosuggest']")
	WebElement autoSuggest;

	@FindBy(xpath = "//a[text()='Selenium WebDriver Java']")
	WebElement autoSugClick;

	@FindBy(xpath = "//input[@id='disabled-button']")
	WebElement disableBtn;

	@FindBy(xpath = "//input[@id='enabled-button']")
	WebElement enableBtn;

	@FindBy(xpath = "//input[@id='enabled-example-input']")
	WebElement enableInput;

	@FindBy(xpath = "//input[@id='hide-textbox']")
	WebElement hideTextbox;

	@FindBy(xpath = "//input[@id='show-textbox']")
	WebElement showTextbox;

	@FindBy(xpath = "//input[@id='displayed-text']")
	WebElement displayedText;

	@FindBy(xpath = "//input[@id='alertbtn']")
	WebElement alertBtn;

	@FindBy(xpath = "//input[@id='confirmbtn']")
	WebElement confirmBtn;

	@FindBy(xpath = "//input[@placeholder='Enter Your Name']")
	WebElement placeHolderText;

	@FindBy(xpath = "//button[@id='mousehover']")
	WebElement mouseHvr;

	@FindBy(xpath = "//a[@href='#top']")
	WebElement hoverTop;

	By hoverReload = By.xpath("//a[text()='Reload']");

	@FindBy(xpath = "//table[@id='product']//tr//td[3]")
	List<WebElement> webtablePrice;

	@FindBy(xpath = "//table[@id='product']//tr//td[3]//preceding-sibling::td[1]")
	WebElement webtableText;

	@FindBy(xpath = "//a[@href='/courses/javascript-for-beginners123']")
	WebElement iframeElement;

	//
	public void radioBtnClick() throws Exception {
		for (WebElement we : radioBtn) {
			we.click();
			Thread.sleep(Duration.ofSeconds(2));
		}
	}

	//
	public void checkboxClick() throws Exception {
		for (WebElement we : checkBox) {
			we.click();
			Thread.sleep(Duration.ofSeconds(2));
		}
	}

	//
	public void openWin() throws Exception {
		String parentWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();

		openWindow.click();
		Thread.sleep(Duration.ofSeconds(2));

		for (String handle : handles) {
			if (!(handle.equals(parentWindow))) {
				driver.close();
			}
		}

		driver.switchTo().window(parentWindow);
	}

	//
	public void openTabs() throws Exception {
		String parentWindow = driver.getWindowHandle();

		openTab.click();
		Thread.sleep(Duration.ofSeconds(2));
		// driver.close();

		driver.switchTo().window(parentWindow);

	}

	//
	public void selectClassExample() throws Exception {

		Select select = new Select(selectClass);

		select.selectByIndex(0);
		Thread.sleep(Duration.ofSeconds(2));

		select.selectByValue("honda");
		Thread.sleep(Duration.ofSeconds(2));

		select.selectByVisibleText("Benz");
		Thread.sleep(Duration.ofSeconds(2));

	}

	//
	public void mulSelectClass() throws Exception {

		Select select = new Select(multipleSelect);

		select.selectByIndex(0);
		Thread.sleep(Duration.ofSeconds(2));

		select.selectByValue("peach");
		Thread.sleep(Duration.ofSeconds(2));

		select.deselectByVisibleText("Orange");
		Thread.sleep(Duration.ofSeconds(2));

		List<WebElement> mulList = select.getOptions();
		System.out.println("Multi list::");
		for (WebElement ml : mulList) {
			System.out.println(ml.getText());
		}
		Thread.sleep(Duration.ofSeconds(2));
	}

	//
	public void autoSuggestion(String predictText) throws Exception {
		autoSuggest.sendKeys(predictText);
		Thread.sleep(Duration.ofSeconds(2));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(autoSugClick));

		autoSugClick.click();
		Thread.sleep(Duration.ofSeconds(2));
	}

	//
	public void disableEnableText(Double text1, Double text2) throws Exception{

		disableBtn.click();
		Thread.sleep(Duration.ofSeconds(2));

		try {
			enableInput.sendKeys(String.valueOf(text1));
			Thread.sleep(Duration.ofSeconds(2));
		} catch (Exception e) {
			e.printStackTrace();
		}

		enableBtn.click();
		Thread.sleep(Duration.ofSeconds(2));
		
		enableInput.sendKeys(String.valueOf(text2));
		Thread.sleep(Duration.ofSeconds(2));
	}

	//
	public void elementDisplayed(String text1, String text2) throws Exception{
		hideTextbox.click();
		Thread.sleep(Duration.ofSeconds(2));

		try {
			displayedText.sendKeys(text1);
			Thread.sleep(Duration.ofSeconds(2));
		} catch (Exception e) {
			e.printStackTrace();
		}

		showTextbox.click();
		Thread.sleep(Duration.ofSeconds(2));

		displayedText.sendKeys(text2);
		Thread.sleep(Duration.ofSeconds(2));
	}

	//
	public void switchToAlert(String text) throws Exception{

		placeHolderText.sendKeys(text);
		Thread.sleep(Duration.ofSeconds(2));
		
		alertBtn.click();
		Thread.sleep(Duration.ofSeconds(2));
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(Duration.ofSeconds(2));
		
		driver.switchTo().defaultContent();

		confirmBtn.click();
		Thread.sleep(Duration.ofSeconds(2));
		alert.dismiss();
		Thread.sleep(Duration.ofSeconds(2));

		driver.switchTo().defaultContent();
	}

	//
	public void hoverAndClick() throws Exception{
		
		
		//Window height and Width
		js = ((JavascriptExecutor)driver);
		Long height = (Long)js.executeScript("return window.innerHeight;");
		Long width = (Long)js.executeScript("return window.innerWidth;");
		System.out.println("Height is:: "+height+"Width is:: "+width);
		Thread.sleep(Duration.ofSeconds(2));
		//Scroll down
		//js.executeScript("window.scrollBy(0,1536);");
		
		//Scroll Up
		//js.executeScript("window.scrollBy(700,0);");
		
		//Scroll into view
		js.executeScript("arguments[0].scrollIntoView(true);", mouseHvr);
		Thread.sleep(Duration.ofSeconds(2));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(mouseHvr).build().perform();
		Thread.sleep(Duration.ofSeconds(2));
		
		hoverTop.click();
		Thread.sleep(Duration.ofSeconds(2));
		
		action.moveToElement(mouseHvr).build().perform();
		
		driver.findElement(hoverReload).click();
		Thread.sleep(Duration.ofSeconds(2));
	}

	//
	public void webtableElement() throws Exception{
		for (WebElement we : webtablePrice) {
			if (we.getText().contains("35")) {
				System.out.println("Course name is::" + webtableText.getText());
				
			}
		}
		Thread.sleep(Duration.ofSeconds(2));
	}

	//
	public void iframes() throws Exception{
		driver.switchTo().frame(0);

		iframeElement.click();
		Thread.sleep(Duration.ofSeconds(2));

		driver.switchTo().defaultContent();
		Thread.sleep(Duration.ofSeconds(2));

	}

}
