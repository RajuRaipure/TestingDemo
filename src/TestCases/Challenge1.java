package TestCases;

import java.awt.AWTException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import WebElements.webElements;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Challenge1 implements webElements
{


	public static  WebDriver driver;
	@BeforeTest
	public static void setup()
	{

		driver=WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();

	}
	@org.testng.annotations.Test
	public void Test1() throws AWTException
	{

		driver.get("http://www.belong.com.au/");
		System.out.println("Navigating to :http://www.belong.com.au/ ");
		driver.findElement(see_nbn_plan).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(enterAddress).sendKeys("UNIT 201, LEVEL 2, BUILDING 1, 77 COLLINS STREET, MELBOURNE VIC 3000");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele=driver.findElement(By.xpath("//ul[@id='queryList']/li"));
		Actions ac=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ac.moveToElement(ele).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ac.moveToElement(driver.findElement(checkAddress)).click().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("selectedAddressId")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select sel=new Select(driver.findElement(By.id("selectedAddressId")));
		sel.selectByVisibleText("UNIT 201, LEVEL 2, BUILDING 1, 77 COLLINS STREET");
		driver.findElement(checkAddress).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]//h1[contains(text(),'Great! We can connect you to NBN internet')]")).isDisplayed());

	}

	@AfterTest
	public static void tearDown()
	{
		driver.quit();
	}


}

