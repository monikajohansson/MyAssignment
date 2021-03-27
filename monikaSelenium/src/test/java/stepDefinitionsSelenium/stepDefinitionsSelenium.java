package stepDefinitionsSelenium;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;

public class stepDefinitionsSelenium {
	private WebDriver driver;
	private Random rand;
	private String emailString;
	private String password;

	@Given("I have used {string} as browser")
	public void browser(String browser) {
		DriveCreator creator = new DriveCreator();
		driver = creator.createBrowser(browser);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@And("I am directed to MailChimp")
	public void mailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
	}

	@And("I have entered {string}")
	public void enterEmail(String email) {
		sendEmail(By.id("email"), "keys");

	}

	@And("I enter an username {string}")
	public void enterUserName(String userName) {
		sendUserName(By.id("new_username"), "keys");
	}

	@And("I enter a password {string}")
	public void enterPassword(String password) {
		sendPassword(By.id("new_password"), "keys");
	}

	

	@When("I press signUp")
	public void pressSignUp() {
		click(By.id("create-account"));
	}

	

	@Then("I verify the success in step")
	public void verifySuccess() {
     // Check your email
		
		WebElement emailSent = driver.findElement(By.cssSelector("h1[class*=margin-bottom--lv3]"));
		assertEquals("Check your email", emailSent.getText());
		driver.quit();
	}

	@Given("I enter a long username {string}")
	public void longUserName(String longUserName) {

	}

	private void click(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();

	}

	private void sendEmail(By by, String keys) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		rand = new Random();
		int randomInt = rand.nextInt(10000);
		emailString = "username" + randomInt + "@yahoo.com";
		driver.findElement(by).sendKeys(emailString);
	}

	private void sendUserName(By by, String keys) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));

		driver.findElement(by).sendKeys(emailString);
	}
	
	private void sendPassword(By by, String keys) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		password = "ThisIs@Password1";
		driver.findElement(by).sendKeys(password);
	}

	
	}
