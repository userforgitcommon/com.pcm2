
package sis.pcm.stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sis.pcm.pageobjects.common_pom;
import sis.pcm.utilities.XLUtils;

public class POC1 {

	WebDriver driver;

	common_pom common;
	
	//chrome.exe –remote-debugging-port=9224
	//https://sandbox.procore.com/4268312/company/home/list
	//adevaraj@sisn.com
	//Priya.praveen84

	String FilePath = "C:\\Users\\Suresh\\Data.xlsx";

	String SheetName = "Sheet1";
	
	@Test(priority = 1)
	public void method1() throws Throwable {

		WebDriverManager.chromedriver().setup();

		ChromeOptions opt = new ChromeOptions();

		opt.setExperimentalOption("debuggerAddress", "localhost:9224");

		driver = new ChromeDriver(opt);

		List<WebElement> Labels = driver.findElements(By.xpath("//label"));
		
		System.out.printf("Array List: ",Labels);

		LinkedHashMap<String, String> Data = new LinkedHashMap<String, String>();

		for (int i = 1; i <= Labels.size(); i++) {

			String Label = driver.findElement(By.xpath("(//label)[" + i + "]")).getText();

			String Value = "";

			try {

				WebElement Frame = driver.findElement(By.xpath("((//label)["+i+"]//parent::div//following-sibling::div//child::*)[1]//textarea//following::iframe[1]"));
				
				System.out.println(i);

				driver.switchTo().frame(Frame);

				Value = driver.findElement(By.xpath("//p")).getText();

				driver.switchTo().defaultContent();

			}

			catch (Exception e) {
				
				System.out.println("Label:" + Label);

				Value = driver
						.findElement(
								By.xpath("((//label)[" + i + "]//parent::div//following-sibling::div//child::*)[1]"))
						.getText();
			}

			Data.put(Label, Value);

		}

		System.out.println("Data: " + Data);

		writeDataInExcel(Data);

	}

	public void writeDataInExcel(HashMap<String, String> Data) throws Exception {

		XLUtils.setExcelFile(FilePath, SheetName);

		for (Map.Entry<String, String> entry : Data.entrySet()) {

			int rows = XLUtils.getRowCount(FilePath, SheetName);

			System.out.println("rows: " + rows);

			int row = rows + 1;

			System.out.println("row: " + row);

			System.out.println(entry.getKey());

			XLUtils.setCellData(FilePath, SheetName, row, 0, entry.getKey());

			XLUtils.setCellData(FilePath, SheetName, row, 1, entry.getValue());

		}

	}
}
