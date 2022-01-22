package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base_Class {

	public static WebDriver driver;

	public static void browser_Launch() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\eclipse-workspace\\Adactin\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void open_Url(String url) {
		driver.get(url);
	}

	public static void input_Values(WebElement a, String b) {
		a.sendKeys(b);
	}

	public static void clickOnElement(WebElement c) {
		c.click();

	}

	public static void closeElement() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void navigate_Url(String Url) {

		driver.navigate().to(Url);
	}

	public static void toBackward() {
		driver.navigate().back();
	}

	public static void toForward() {
		driver.navigate().forward();
	}

	public static void toRefresh() {
		driver.navigate().refresh();
	}

	public static void alert_Accept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void alert_Dismiss() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void action_Class(WebElement webElement) {

		Actions action = new Actions(driver);
		action.click(webElement);

	}

	public static void contetClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	public static void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick();
	}

	public static void movetoElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

	public static void dragnDrop(WebElement from, WebElement to) {
		Actions action = new Actions(driver);
		action.clickAndHold(from).moveToElement(to).build().perform();
	}

	public static void frame_Element(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void get_Text(WebElement element) {
		element.getText();
	}

	public static void get_Attribute(WebElement element, String str) {
		element.getAttribute(str);
	}

	@SuppressWarnings("deprecation")
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	public static void explicitlyWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void take_Screenshot(String path) throws IOException {

		TakesScreenshot tc = (TakesScreenshot) driver;
		File screenshotAs = tc.getScreenshotAs(OutputType.FILE);
		File location = new File(path);
		FileUtils.copyFile(screenshotAs, location);

	}

	public static void scroll_Up() {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,-400)", "");
	}

	public static void scroll_Down() {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,400)", "");

	}

	public static void current_Url() {
		driver.getCurrentUrl();
	}

	public static void get_Title() {
		driver.getTitle();

	}

	public static void is_Multiple(WebElement element) {
		Select s = new Select(element);
		s.isMultiple();
	}

	public static void is_Enable(WebElement element) {
		element.isEnabled();
	}

	public static void is_Displayed(WebElement element) {
		element.isDisplayed();
	}

	public static void is_Selected(WebElement element) {
		element.isSelected();
	}

	public static void first_SelectedOption(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();
	}

	public static void all_SelectedOption(WebElement element) {
		Select s = new Select(element);
		s.getAllSelectedOptions();
	}

	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		s.getOptions();

	}
	
	public static void robot_Class() throws AWTException {
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ALL_CANDIDATES);
	robot.keyRelease(KeyEvent.VK_ALL_CANDIDATES);
	}
	
	
	
}
