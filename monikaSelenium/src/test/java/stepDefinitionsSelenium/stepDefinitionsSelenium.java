package stepDefinitionsSelenium;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionsSelenium {
	private WebDriver driver;
	private Random rand;
	private String emailString;
	private String password;
	private String noEmailString;

	@Given("I am directed to MailChimp")
	public void browser() {
		DriveCreator creator = new DriveCreator();  
		driver = creator.createBrowser("chrome");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
	}
	//Sends a correct Email
	@And("I have entered email") 
	public void enterEmail() {
		sendEmail(By.id("email"));
	}
	//Sends no Email
	@And("I have entered noEmail")
	public void noEmail() {
		sendNoEmail(By.id("email"));
	}
	//Sends a username
	@And("I enter a userName")
	public void enterUserName() {
		sendUserName(By.id("new_username"));
	}
	//Sends a username longer than 100 characters
	@And("I enter a longUserName")
	public void longUserName() {
		sendLong(By.id("new_username"));
	}
	//Sends an existing username
	@And("I enter a usedUserName")
	public void usedUserName() {
		sendUsedUserName(By.id("new_username"));
	}
	//Sends a username when no email is inserted
	@And("I enter a newUserName")
	public void noEmailUser() {
		newUserName(By.id("new_username"));
	}
	
	@And("I enter a password")
	public void enterPassword() {
		sendPassword(By.id("new_password"));
	}

	@When("I press signUp")
	public void pressSignUp() {
		click(By.id("create-account"));
	}
	//Verifies that no email has been inserted
	@Then("I verify the failNoEmail in step")
	public void verifyNoEmail() {
		WebElement sentNoEmail = driver.findElement(By.cssSelector("span[class=invalid-error]"));
		assertEquals("Please enter a value", sentNoEmail.getText());
		driver.quit();
	}
	//Verifies that the account is created successfully
	@Then("I verify the success in step")
	public void verifySuccess() {
		WebElement emailSent = driver.findElement(By.cssSelector("h1[class*=margin-bottom--lv3]"));
		assertEquals("Check your email", emailSent.getText());
		driver.quit();
	}
	//Verifies that the username cannot be more than 100 characters
	@Then("I verify the failLong in step")
	public void verifyFailLong() {
		WebElement sentLong = driver.findElement(By.cssSelector("span[class=invalid-error]"));
		assertEquals("Enter a value less than 100 characters long", sentLong.getText());
		driver.quit();
	}
	//Verifies that the username already exists
	@Then("I verify the failUsed in step")
	public void verifyFailUsed() {
		WebElement sentUsed = driver.findElement(By.cssSelector("span[class=invalid-error]"));
		assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.",
				sentUsed.getText());
		driver.quit();
	}

	private void click(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	//Sends a random email
	private void sendEmail(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		rand = new Random();
		int randomInt = rand.nextInt(1000000);
		emailString = "username" + randomInt + "@yahoo.com";
		driver.findElement(by).sendKeys(emailString);
	}
	//Sends an empty String as email
	private void sendNoEmail(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys("");
	}
	//Uses the random email as username
	private void sendUserName(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(emailString);
	}
	//Creates and sends a username that is over 100 characters
	private void sendLong(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		String longUserName = "";
		for(int i = 0; i<102; i++) {
			longUserName = longUserName.concat("1");					
		}
		driver.findElement(by).sendKeys(longUserName);
	}
    //Sends an existing username
	private void sendUsedUserName(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys("dragon");
	}
	//Sends a username when no email is inserted
	private void newUserName(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		rand = new Random();
		int randomInt = rand.nextInt(1000000);
		noEmailString = "noemail" + randomInt + "@yahoo.com";
		driver.findElement(by).sendKeys(noEmailString);
	}
	//Sends a password
	private void sendPassword(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		password = "ThisIs@Password1"; 
		driver.findElement(by).sendKeys(password);
	}

}
