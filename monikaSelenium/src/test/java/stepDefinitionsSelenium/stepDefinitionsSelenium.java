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
import io.cucumber.core.cli.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionsSelenium {
	private WebDriver driver;
	private Random rand;
	private String emailString;
	private String password;

	@Given("I am directed to MailChimp")
	public void browser() {
		DriveCreator creator = new DriveCreator();
		driver = creator.createBrowser("chrome");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
	}

	@And("I have entered email")
	public void enterEmail() {
		sendEmail(By.id("email"));

	}

	@And("I have entered NoEmail")
	public void noEmail() {
		
	}

	@When("I enter an userName")
	public void enterUserName() {
		sendUserName(By.id("new_username"));
	}

	@When("I enter an longUserName")
	public void longUserName() {
		sendLong(By.id("new_username"));
	}
	@When("I enter an usedUserName")
	public void usedUserName() {
		sendUsedUserName(By.id("new_username"));
	}
	@And("I enter a password {string}")
	public void enterPassword(String password) {
		sendPassword(By.id("new_password"));
	}

	@And("I press signUp")
	public void pressSignUp() {
		click(By.id("create-account"));
	}

	@Then("I verify the success in step")
	public void verifySuccess() {
		// Check your email
		// verifyEmail();
		WebElement emailSent = driver.findElement(By.cssSelector("h1[class*=margin-bottom--lv3]"));
		assertEquals("Check your email", emailSent.getText());
		// driver.quit();
	}

	private void click(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();

	}

	private void sendEmail(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		rand = new Random();
		int randomInt = rand.nextInt(1000000);
		emailString = "username" + randomInt + "@yahoo.com";
		driver.findElement(by).sendKeys(emailString);
	}

	private void noEmail(By by, String noEmails) {
		String hej = "";
		driver.findElement(by).sendKeys(hej);
	}

	private void sendUserName(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));

		driver.findElement(by).sendKeys(emailString);
	}

	private void sendLong(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));

		driver.findElement(by).sendKeys(emailString
				+ "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
	} // felmeddelande: Your username should either be an email address or consist of
		// letters and numbers.

	private void sendUsedUserName(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));

		driver.findElement(by).sendKeys("dragon");
	} //felmeddelande:Another user with this username already exists. Maybe it's your evil twin. Spooky

	private void sendPassword(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		password = "ThisIs@Password1";
		driver.findElement(by).sendKeys(password);
	}

}
