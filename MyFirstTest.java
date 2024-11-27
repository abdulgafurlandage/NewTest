package testcases;

import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MyFirstTest {

	static WebDriver driver=null;


	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Nyamat\\chromedriver-win64\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}


	@After

	public void teardown() {

		driver.close();
	}

	@Test
	public void Test() throws InterruptedException {
		//Nevigate to homepage
		driver.get("https://www.fitpeo.com/home");

		//Nevigate to Revenue calculate Page
		driver.findElement(By.linkText("Revenue Calculator")).click();

		// scroll down untill condition mate	
		WebElement slider=driver.findElement(By.xpath("/html/body"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider);


		Thread.sleep(1500);

		//adjust slider to 820 
		WebElement slider1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]"));
		Actions action = new Actions(driver);
		Thread.sleep(2000);

		action.clickAndHold(slider1).moveByOffset(-20, 00).release().perform();	

		Thread.sleep(2000);


		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down by 1000 pixels
		js.executeScript("window.scrollBy(0, 300);");
		Thread.sleep(1500);
		//======================================================================================================

		//Validate that the text field updates to 820
		Thread.sleep(1500);
		WebElement sliderValueField=driver.findElement(By.xpath("//input[contains(@class, 'MuiInputBase-input')]"));

		System.out.println();


		String sliderValue = sliderValueField.getAttribute("value");
		WebElement slv=driver.findElement(By.id(":r9:"));
		//assert sliderValue.equals("820") : "Slider value should be 820";

		// update the text field by 560
		driver.findElement(By.id("//input[contains(@class, 'MuiInputBase-input')]")).clear();
		driver.findElement(By.id(":R57alklff9da:")).sendKeys("560");

		//Validate Slider Value updates to reflect 560
		WebElement updatedSliderValue = driver.findElement(By.id(":R57alklff9da:"));
		updatedSliderValue.getText();
		assert updatedSliderValue.equals("560") : "Slider value should be updated to 560";


		//select the checkboxes
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input")).click();


		//validate total recurring reimbursment
		WebElement totalReimbursementHeader = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]/p[2]"));

		String totalReimbursementValue = totalReimbursementHeader.getText();

		if (totalReimbursementValue.contains("$110700")) {
			System.out.println("Total Recurring Reimbursement is correctly displayed as $110700");
		} else {
			System.out.println("Total Recurring Reimbursement value is incorrect. Current value: " + totalReimbursementValue);



		}

	}}
