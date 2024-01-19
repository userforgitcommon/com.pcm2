package sis.pcm.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.codehaus.plexus.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sis.pcm.stepdefinitions.baseclass;
import sis.pcm.utilities.ReadConfig;

public class common_pom extends baseclass {

	public WebDriver ldriver;
	ReadConfig rd = new ReadConfig();

	WebDriverWait wait;

	public common_pom(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

		logger = Logger.getLogger(getClass());
		pcmusername = rd.getXL_PCM_Username();
	}

	public void waitForElement(WebElement element) {

		wait = new WebDriverWait(ldriver, 10);
		//wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	}

	public boolean isTextDisplayed(WebElement element) {

		// wait.until(ExpectedConditions.elementToBeClickable(element));

		try {
			waitForElement(element);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public void waitForElementToDisappear(WebElement element) {

		// wait.until(ExpectedConditions.elementToBeClickable(element));

		wait = new WebDriverWait(ldriver, 60);
		//wait = new WebDriverWait(ldriver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}

	public void scrollIntoView(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) ldriver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickElementJS(WebElement element) throws InterruptedException {

		waitForElement(element);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		try {
			JavascriptExecutor js = (JavascriptExecutor) ldriver;

			js.executeScript("arguments[0].scrollIntoView(true);", element);

			js.executeScript("arguments[0].click()", element);

		}

		catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) ldriver;
			js.executeScript("arguments[0].click()", element);

		}
	}

	public void clickElement(WebElement element) throws InterruptedException {

		waitForElement(element);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) ldriver;
		 * 
		 * js.executeScript("arguments[0].scrollIntoView(true);", element);
		 */

		wait.until(ExpectedConditions.elementToBeClickable(element));

		try {
			element.click();

		}

		catch (Exception e) {

			clickElementJS(element);

		}
	}

	public void rightClickElement(WebElement element) throws InterruptedException {

		waitForElement(element);

		JavascriptExecutor js = (JavascriptExecutor) ldriver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		Actions actions = new Actions(ldriver);

		try {

			actions.contextClick(element).perform();

		}

		catch (Exception e) {

			actions.contextClick(element).perform();

		}
	}

	public void setText(WebElement element, String value) throws InterruptedException {

		waitForElement(element);

		clickElement(element);

		element.sendKeys(value);
	}

	public void setTextAfterClear(WebElement element, String value) throws InterruptedException {

		waitForElement(element);

		clickElement(element);

		Thread.sleep(1000);

		element.clear();

		Thread.sleep(1000);

		setText(element, value);

		Thread.sleep(1000);

		KeyboardAction("Tab");

	}

	public void setTextAfterDelete(WebElement element, String value) throws InterruptedException {

		waitForElement(element);
		
		scrollIntoView(element);
		
		clickElement(element);

		Thread.sleep(2000);

		element.sendKeys(Keys.CONTROL, "a");

		Thread.sleep(2000);

		element.sendKeys(Keys.DELETE);

		Thread.sleep(2000);

		element.sendKeys(value);

		Thread.sleep(2000);

		KeyboardAction("Tab");

		Thread.sleep(2000);

	}

	public String getText(WebElement element) throws InterruptedException {

		// waitForElement(element);

		JavascriptExecutor js = (JavascriptExecutor) ldriver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);

		String Text = element.getText();

		return Text;

	}

	public String getValue(WebElement element) throws InterruptedException {

		scrollIntoView(element);

		waitForElement(element);

		String Value = element.getAttribute("value");

		System.out.println("value" + Value);

		return Value;

	}

	public void clickUsingActions(WebElement element) throws InterruptedException {

		Actions act = new Actions(ldriver);

		act.moveToElement(element).click().build().perform();

	}

	@FindBy(xpath = "//*[@type='email']")
	WebElement inputusername;
	@FindBy(xpath = "//*[@id='passwordInput']")
	WebElement inputPassword;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement btnsigninfirst;
	@FindBy(xpath = "//span[@id='submitButton']")
	WebElement btnsignin;
	@FindBy(xpath = "//*[@id='idBtn_Back']")
	WebElement btnno;
	@FindBy(xpath = "(//*[text()='Finance and Operations'])[2]")
	WebElement labelfinanceandoperaions;

	public void PCM_Login() throws InterruptedException {

		clickElement(inputusername);
		setText(inputusername, pcmusername);
		clickElement(btnsigninfirst);

		Thread.sleep(3000);

		String encodedpassword = rd.getXl_PCM_Password();
		// System.out.println("Password used is: "+encodedpassword);
		byte[] decodedpassword = Base64.decodeBase64(encodedpassword.getBytes());
		String pwd = new String(decodedpassword);
		setText(inputPassword, pwd);

		clickElement(btnsignin);
		clickElement(btnno);
		isTextDisplayed(labelfinanceandoperaions);
		logger.info("User Successfully Logged in");
	}

	// SearchText IFrame
	public void searchtxtIFrame() throws InterruptedException {

		ldriver.switchTo().frame("AppLandingPage");
		Thread.sleep(2000);
	}

	// switch to iframe

	public void switchToIframe(WebElement element) throws InterruptedException {

		waitForElement(element);

		ldriver.switchTo().frame(element);
	}

	public void switchToDefaultContent() throws InterruptedException {

		ldriver.switchTo().defaultContent();
	}

	// Scroll as per pixel
	public void scrollaspixel() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
	}

	// Random for Alphabets
	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	// Random for Integers
	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	// Current Date and Time
	public String currentdateandtime(String dateandtime) {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");
		Date date = new Date();
		return dateandtime = dateFormat.format(date);
	}

	// Switch to Browser tab
	public void SwitchestoNewTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(ldriver.getWindowHandles());
		ldriver.switchTo().window(tabs.get(1)); // switches to new tab
		Thread.sleep(2000);
	}

	public void SwitchbacktoMainTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(ldriver.getWindowHandles());
		ldriver.switchTo().window(tabs.get(0)); // switch back to main screen
		Thread.sleep(2000);
	}

	public void SwitchbacktoSubTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(ldriver.getWindowHandles());
		ldriver.switchTo().window(tabs.get(1)); // switch back to main screen
		Thread.sleep(2000);
	}

	public void SwitchtoThirdTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(ldriver.getWindowHandles());
		ldriver.switchTo().window(tabs.get(2)); // switch back to main screen
		Thread.sleep(3000);
	}

	public void RefreshPage() throws InterruptedException {

		ldriver.navigate().refresh();
		Thread.sleep(20000);
	}

	public void NavigateBack() throws InterruptedException {

		ldriver.navigate().back();
		Thread.sleep(15000);
	}

	public void CloseBrowser() throws InterruptedException {

		ldriver.close();
		Thread.sleep(2000);
	}

	// Wait Time
	public long WaitTime(String arg) throws InterruptedException {

		/*
		 * if (arg.equals("1")) { Thread.sleep(1000); } else if (arg.equals("2")) {
		 * Thread.sleep(2000); } else if (arg.equals("3")) { Thread.sleep(3000); } else
		 * if (arg.equals("4")) { Thread.sleep(4000); } else if (arg.equals("5")) {
		 * Thread.sleep(5000); } else if (arg.equals("6")) { Thread.sleep(6000); } else
		 * if (arg.equals("7000")) { Thread.sleep(7000); } else if (arg.equals("8")) {
		 * Thread.sleep(8000); } else if (arg.equals("9")) { Thread.sleep(9000); } else
		 * if (arg.equals("10")) { Thread.sleep(10000); } else if (arg.equals("15")) {
		 * Thread.sleep(15000); } else if (arg.equals("20")) { Thread.sleep(20000); }
		 * else if (arg.equals("25")) { Thread.sleep(25000); } else if
		 * (arg.equals("30")) { Thread.sleep(30000); } else if (arg.equals("35")) {
		 * Thread.sleep(35000); } else if (arg.equals("40")) { Thread.sleep(40000); }
		 * else if (arg.equals("45")) { Thread.sleep(45000); } else if
		 * (arg.equals("50")) { Thread.sleep(50000); } else if (arg.equals("55")) {
		 * Thread.sleep(55000); } else if (arg.equals("60")) { Thread.sleep(60000); }
		 * return arg;
		 */

		Thread.sleep(Long.parseLong(arg) * 1000);

		return Long.parseLong(arg) * 1000;
	}

	// Keyboard Actions
	public String KeyboardAction(String arg1) throws InterruptedException {

		if (arg1.equals("Enter")) {
			Actions act = new Actions(ldriver);
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
		} else if (arg1.equals("Tab")) {
			Actions act = new Actions(ldriver);
			act.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
		}

		else if (arg1.equals("Down")) {
			Actions act = new Actions(ldriver);
			act.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
		}
		
		else if (arg1.equals("Up")) {
			Actions act = new Actions(ldriver);
			act.sendKeys(Keys.UP).build().perform();
			Thread.sleep(2000);
		}
		
		return arg1;
	}

	// Open New Tab
	public void OpenNewTab() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);

		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(15000);
	}

	// ***************************Ram**********************************//

	public boolean isMenuExpanded(WebElement element) {

		waitForElement(element);

		if (element.getAttribute("class").contains("isExpanded")) {

			return true;
		}

		else {

			return false;

		}

	}

	public boolean isSectionExpanded(WebElement element) {

		waitForElement(element);

		if (element.getAttribute("aria-expanded").contains("true")) {

			return true;
		}

		else {

			return false;

		}
	}

	public void selectDropDownValue(String value) throws InterruptedException {

		Thread.sleep(2000);

		By dropdownvalue = By.xpath("//li[normalize-space()='" + value + "']");

		wait = new WebDriverWait(ldriver, 30);
		
		//wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownvalue));

		wait.until(ExpectedConditions.elementToBeClickable(dropdownvalue));

		ldriver.findElement(dropdownvalue).click();
	}

	public String generateUniqueID(String text) throws InterruptedException {

		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		String ID = "AT" + text + date1;
		return ID;
	}

	public String getValueWithoutScroll(WebElement element) throws InterruptedException {

		waitForElement(element);

		String Value = element.getAttribute("value");

		System.out.println("value" + Value);

		return Value;

	}

	public void doubleClickElement(WebElement element) throws InterruptedException {

		waitForElement(element);

		JavascriptExecutor js = (JavascriptExecutor) ldriver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// wait.until(ExpectedConditions.elementToBeClickable(element));

		Actions actions = new Actions(ldriver);

		try {

			actions.doubleClick(element).perform();

		}

		catch (Exception e) {

			actions.contextClick(element).perform();

		}
	}

	public String getCurrentMonthEndDate() {

		YearMonth currentYearMonth = YearMonth.now();

		LocalDate currentMonthEndDate = currentYearMonth.atEndOfMonth();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

		return currentMonthEndDate.format(formatter);
	}

	public String getNextMonthEndDate() {

		YearMonth nextMonth = YearMonth.now().plusMonths(1);

		LocalDate nextMonthEndDate = nextMonth.atEndOfMonth();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

		return nextMonthEndDate.format(formatter);

	}

	// arthi
	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

}