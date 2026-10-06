package com.plug.ecommerce.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {



public WebDriver launchBrowser(String browser) {

	WebDriver driver = null;

	if (browser.equalsIgnoreCase("chrome")) {

		driver = new ChromeDriver();

	} else if (browser.equalsIgnoreCase("firefox")) {

		driver = new FirefoxDriver();

	} else if (browser.equalsIgnoreCase("edge")) {

		driver = new EdgeDriver();

	} else {

		System.out.println("Invalid browser: " + browser);
	}

	return driver;
}

public void maximizeWindow(WebDriver driver) {

	driver.manage().window().maximize();
}

public void minimizeWindow(WebDriver driver) {

	driver.manage().window().minimize();
}

public void waitForPageLoad(WebDriver driver) {

	driver.manage().timeouts()
			.pageLoadTimeout(Duration.ofSeconds(20));
}

public void implicitWait(WebDriver driver, int sec) {

	driver.manage().timeouts()
			.implicitlyWait(Duration.ofSeconds(sec));
}

public void quitBrowser(WebDriver driver) {

	driver.quit();
}



public WebDriverWait webDriverWaitObj(WebDriver driver, int sec) {

	WebDriverWait wait =
			new WebDriverWait(driver, Duration.ofSeconds(sec));

	return wait;
}

public void waitUntilEleToBeVisible(
		WebDriver driver,
		int sec,
		WebElement element) {

	webDriverWaitObj(driver, sec)
			.until(ExpectedConditions.visibilityOf(element));
}

public void waitUntilEleToBeClickable(
		WebDriver driver,
		int sec,
		WebElement element) {

	webDriverWaitObj(driver, sec)
			.until(ExpectedConditions.elementToBeClickable(element));
}

public void waitUntilTogetTitle(
		WebDriver driver,
		int sec,
		String title) {

	webDriverWaitObj(driver, sec)
			.until(ExpectedConditions.titleContains(title));
}

public void waitUntilAlertToBePresent(
		WebDriver driver,
		int sec) {

	webDriverWaitObj(driver, sec)
			.until(ExpectedConditions.alertIsPresent());
}



public Select dropdownObject(WebElement element) {

	Select sel = new Select(element);

	return sel;
}

public void handleDropdown(
		WebElement element,
		String text) {

	dropdownObject(element)
			.selectByVisibleText(text);
}

public void handleDropdown(
		WebElement element,
		int index) {

	dropdownObject(element)
			.selectByIndex(index);
}

public void handleDropdown(
		String value,
		WebElement element) {

	Select sel = new Select(element);

	sel.selectByValue(value);
}



public void mousehover(
		WebDriver driver,
		WebElement element) {

	Actions act = new Actions(driver);

	act.moveToElement(element).perform();
}

public Actions performActions(WebDriver driver) {

	Actions act = new Actions(driver);

	return act;
}

public void dragAndDrop(
		WebDriver driver,
		WebElement src,
		WebElement dst) {

	performActions(driver)
			.dragAndDrop(src, dst)
			.perform();
}

public void dropAndDrop(
		WebDriver driver,
		WebElement element,
		int x,
		int y) {

	performActions(driver)
			.dragAndDropBy(element, x, y)
			.perform();
}

public void doubleClick(WebDriver driver) {

	performActions(driver)
			.doubleClick()
			.perform();
}

public void doubleClick(
		WebDriver driver,
		WebElement element) {

	performActions(driver)
			.doubleClick(element)
			.perform();
}

public void rightClick(WebDriver driver) {

	performActions(driver)
			.contextClick()
			.perform();
}

public void rightClick(
		WebDriver driver,
		WebElement element) {

	performActions(driver)
			.contextClick(element)
			.perform();
}

public void enterKeyPress(WebDriver driver) {

	performActions(driver)
			.sendKeys(Keys.ENTER)
			.perform();
}


public void switchToWindow(
		WebDriver driver,
		String expWind) {

	Set<String> window =
			driver.getWindowHandles();

	Iterator<String> it =
			window.iterator();

	while (it.hasNext()) {

		String win = it.next();

		String currentTitle =
				driver.switchTo()
						.window(win)
						.getTitle();

		if (currentTitle.contains(expWind)) {

			break;
		}
	}
}

public String getParentWindow(WebDriver driver) {

	return driver.getWindowHandle();
}



public Robot robotObj() throws AWTException {

	Robot rb = new Robot();

	return rb;
}

public void enterKey() throws Throwable {

	robotObj()
			.keyPress(KeyEvent.VK_ENTER);
}

public void enterRelease() throws Throwable {

	robotObj()
			.keyRelease(KeyEvent.VK_ENTER);
}

public void pressEnter() throws AWTException {

	Robot rb = new Robot();

	rb.keyPress(KeyEvent.VK_ENTER);

	rb.keyRelease(KeyEvent.VK_ENTER);
}



public void switchToFrame(
		WebDriver driver,
		int index) {

	driver.switchTo().frame(index);
}

public void switchToFrame(
		WebDriver driver,
		String nameOrID) {

	driver.switchTo().frame(nameOrID);
}

public void switchToFrame(
		WebDriver driver,
		WebElement address) {

	driver.switchTo().frame(address);
}


public void acceptAlert(WebDriver driver) {

	driver.switchTo()
			.alert()
			.accept();
}

public void cancelAlert(WebDriver driver) {

	driver.switchTo()
			.alert()
			.dismiss();
}

public void dismissAlert(WebDriver driver) {

	driver.switchTo()
			.alert()
			.dismiss();
}


public static String getScreenShot(
		WebDriver driver,
		String screenShotName) throws Throwable {

	JavaUtility jUtils = new JavaUtility();

	TakesScreenshot ts =
			(TakesScreenshot) driver;

	File src =
			ts.getScreenshotAs(OutputType.FILE);

	String path =
			"./screenshot/"
			+ screenShotName
			+ jUtils.getSystemDateInFormat()
			+ ".png";

	File dst = new File(path);

	FileUtils.copyFile(src, dst);

	return dst.getAbsolutePath();
}

public String takeScreenshot(
		WebDriver driver,
		String screenshotName) throws IOException {

	TakesScreenshot ts =
			(TakesScreenshot) driver;

	File src =
			ts.getScreenshotAs(OutputType.FILE);

	File dest =
			new File("./screenshots/"
					+ screenshotName
					+ ".png");

	FileUtils.copyFile(src, dest);

	return dest.getAbsolutePath();
}


public void scrollBarAction(WebDriver driver) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	jse.executeScript(
			"window.scrollBy(0,800)", "");
}

public void scrollAction(
		WebDriver driver,
		WebElement element) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	int y =
			element.getLocation().getY();

	jse.executeScript(
			"window.scrollBy(0," + y + ")",
			element);
}

public void scrollDownTillBottomOfThePage(
		WebDriver driver) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	jse.executeScript(
			"window.scrollBy(0,document.body.scrollHeight)");
}

public void scrollTillEleToBeVisible(
		WebDriver driver,
		WebElement element) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	jse.executeScript(
			"arguments[0].scrollIntoView()",
			element);
}

public void scrollTillElementToBeVisible(
		WebDriver driver,
		WebElement element) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	jse.executeScript(
			"arguments[0].scrollIntoView()",
			element);
}

public void clickOnElement(
		WebDriver driver,
		WebElement element) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	jse.executeScript(
			"arguments[0].click();",
			element);
}

public void jseUsingSendKeys(
		WebDriver driver,
		WebElement element,
		String expData) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	jse.executeScript(
			"arguments[0].value=arguments[1]",
			element,
			expData);
}

public void scrollUpTillElementToBeVisible(
		WebDriver driver,
		WebElement element) {

	JavascriptExecutor jse =
			(JavascriptExecutor) driver;

	Point loc =
			element.getLocation();

	int x = loc.getX();
	int y = loc.getY();

	jse.executeScript(
			"window.scrollBy("
			+ x + "," + y + ")");
}


}