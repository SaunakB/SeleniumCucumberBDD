package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
    
    WebDriver driver= null;
	boolean valid=true;
	
	@Before
	public void browserSetup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:/Driver12345/chromedriver.exe");
		driver= new ChromeDriver();
		Thread.sleep(20000);
		driver.manage().window().maximize();
	}
	
	
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
	    driver.get("https://www.growthengineering.co.uk/");
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User Navigate to Menu Link")
	public void user_Navigate_to_Menu_Link() throws Exception {
		
	    driver.findElement(By.id("sm-161622947940247-1")).click();
	    Thread.sleep(3000);
	    valid=driver.findElement(By.xpath("//b[text()='ACADEMY LMS']")).isDisplayed();
	    //driver.navigate().back();
	    Thread.sleep(2000);
	    driver.findElement(By.id("sm-16162298423042139-3")).click();
	    Thread.sleep(3000);
	    valid=driver.findElement(By.xpath("//b[text()='BEHAVIOUR CHANGE']")).isDisplayed();
	    Thread.sleep(2000);
	    driver.findElement(By.id("sm-16162298423042139-5")).click();
	    Thread.sleep(3000);
	    valid=driver.findElement(By.xpath("//b[text()='DOWNLOADS']")).isDisplayed();
	    Thread.sleep(2000);
	    driver.findElement(By.id("sm-16162298423042139-7")).click();
	    Thread.sleep(3000);
	    valid=driver.findElement(By.xpath("//b[text()='ENGAGEMENT HEROES']")).isDisplayed();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='GET IN TOUCH']")).click();
	    Thread.sleep(3000);
	    valid=driver.findElement(By.xpath("//b[text()='CONTACT US TODAY!']")).isDisplayed();
	    Thread.sleep(2000);
	}

	@Then("User Navigated Successfully")
	public void user_Navigated_Successfully() {
	    if (valid==true)
	    {
	    	System.out.println("Navigation is correct");
	    }
	}

	@Given("User is on Contact Page")
	public void user_is_on_Contact_Page() {
		driver.get("https://www.growthengineering.co.uk/contact/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User enters Invalid Data")
	public void user_enters_Invalid_Data() throws InterruptedException {
		valid=true;
		driver.findElement(By.id("firstname-63c6168e-e30a-4c79-ab68-77cedae08dfe")).sendKeys("  ");;
    	Thread.sleep(3000);
    	valid=driver.findElement(By.xpath("//label[text()='Please complete this required field.']")).isDisplayed();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("email-63c6168e-e30a-4c79-ab68-77cedae08dfe")).sendKeys("ABCD");;
    	Thread.sleep(3000);
    	valid=driver.findElement(By.xpath("//label[text()='Email must be formatted correctly.']")).isDisplayed();
	    Thread.sleep(2000);
	}

	@Then("Validation Error Message Displayed Successfully")
	public void validation_Error_Message_Displayed_Successfully() {
		if (valid==true)
	    {
	    	System.out.println("Form validation is correct");
	    }
	}
	
	@After
	public void browserClose() {
		driver.close();
		driver.quit();
	}

}
