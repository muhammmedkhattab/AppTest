package com.khattab.maven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Testcases {

	// initializing Variables
	public WebDriver driver;
	public String baseUrl = "https://www.google.com";
	String google_driverPath = "chromedriver.exe";

	// called Data From ReadExel class
	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException {
		ReadExcel ER = new ReadExcel();
		return ER.getExcelData();

	}

	// driver = WebDriver.PhantomJS();
    //methods
	// Assert URL Title
	private void assertwindow() {
		String searchKey = "seleniumHQ";
		// Testcase One Desc. search for seleniumHQ and assert the first result link is

		WebElement email = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
		email.sendKeys(searchKey);
		email.sendKeys(Keys.RETURN);
		String expectedTitle = "Downloads - Selenium";

		// made a list to get all the URLs and assert on the first on

		List<WebElement> urlList = driver.findElements(By.xpath("//h3"));
		WebElement e = urlList.get(0);
		String ActualLinkname = e.getText();
		Assert.assertEquals(ActualLinkname, expectedTitle);
		System.out.println("Assertion passed successfully For Testcase 2");
	}
	private void assertitle() {
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Assertion passed successfully For Testcase 1");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Launching Chrome Browser");
		System.setProperty("webdriver.chrome.driver", google_driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Testcase1() {
		// Testcase One Desc. open chrome and assert correct window name is displayed

		assertitle();

	}

	@Test()
	public void Testcase2() {
		assertwindow();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
