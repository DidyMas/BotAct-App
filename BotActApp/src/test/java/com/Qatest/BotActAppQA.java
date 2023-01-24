package com.Qatest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class BotActAppQA {

	private WebDriver driver;

	@Before
	public void setUp() {

		String QAportal = "https://appstestbc.com:8180/apps/#!/cliente\\";
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("w3c", true);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get(QAportal);

		try {
			String Customer = "025106001";
			String Status = "1";

			Thread.sleep(1000);
			// Block of code to try
			driver.findElement(By.id("cliente")).click();
			WebElement Cpcustomer = driver.findElement(By.id("num_cliente_estatus"));
			Cpcustomer.clear();
			Cpcustomer.sendKeys(Customer);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/button")).click();
			Thread.sleep(2000);
			Select Statuscliente = new Select(driver.findElement(By.id("estatus_nuevo_cte")));
			Statuscliente.selectByValue(Status);
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/button")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// Block of code to handle errors
			System.out.println("El error es:" + e.getMessage());
			driver.quit();
		}
		driver.quit();
		System.out.println("Termine el proceso de actualización de estatus cliente activación App");
	}

	@Test

	@After
	public void tearDown() {
		driver.quit();
	}
}
