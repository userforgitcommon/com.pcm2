
package sis.pcm.pageobjects;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sis.pcm.stepdefinitions.baseclass;
import sis.pcm.stepdefinitions.projectcostmanagement;
import sis.pcm.utilities.Formulas;
import sis.pcm.utilities.XLUtils;

public class test extends baseclass {

	WebDriver driver;

	common_pom common;

	@FindBy(xpath = "(//*[@aria-label='Project ID' and not(contains(@id,'ProjTable'))])[1]")
	WebElement ProjectID_CommittedCost;

	@Test(priority = 1)
	public void method1() throws Throwable {

	/*
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * ChromeOptions opt = new ChromeOptions();
	 * 
	 * opt.setExperimentalOption("debuggerAddress", "localhost:9224");
	 * 
	 * driver = new ChromeDriver(opt);
	 * 
	 * pcm_pom pcmpom = new pcm_pom(driver);
	 * 
	 * common = new common_pom(driver);
	 * 
	 * projectcostmanagement pcm = new projectcostmanagement();
	 * 
	 * common.scrollIntoView(pcmpom.TransactionID_CommittedCost);
	 * 
	 * pcmpom.getCommittedCostTable();
	 */


		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy h:mm:ss aa");

		String LastAtivityDate_Project = "6/7/2023 07:15:55 PM";

		System.out.println(dateFormat.format(dateFormat.parse(LastAtivityDate_Project)));
	
	}
}
