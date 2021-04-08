package stepDefinitionsSelenium;

import static org.junit.Assert.assertEquals;

import java.util.Random;

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

	@Given("I am directed to MailChimp")
	public void browser() {
		DriveCreator creator = new DriveCreator();
		driver = creator.createBrowser("chrome");

		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
	}

	// Sends a correct Email
	@And("I have entered email")
	public void enterEmail() {
		rand = new Random();
		int randomInt = rand.nextInt(3000000);
		emailString = "thisIsAnEmail" + randomInt + "@yahoo.com";
		sendKeys(By.id("email"), emailString);
	}

	// Sends no Email
	@And("I have entered noEmail")
	public void noEmail() {
		sendKeys(By.id("email"), "");
	}

	// Sends a username longer than 100 characters
	@And("I enter a longUserName")
	public void longUserName() {
		String longUserName = "";
		for (int i = 0; i < 102; i++) {
			longUserName = longUserName.concat("1");
		}
		sendKeys(By.id("new_username"), longUserName);
	}

	// Sends an existing username
	@And("I enter a usedUserName")
	public void usedUserName() {
		sendKeys(By.id("new_username"), "dragon");
	}

	@And("I enter a userName")
	public void noEmailUser() {
		rand = new Random();
		int randomInt = rand.nextInt(1000000);
		emailString = "email" + randomInt + "@yahoo.com";
		sendKeys(By.id("new_username"), emailString);
	}

	@And("I enter a password")
	public void enterPassword() {
		sendKeys(By.id("new_password"), "ThisIs@Password1");
	}

	@When("I press signUp")
	public void pressSignUp() {
		click(By.id("create-account"));
	}

	@Then("I verify the {string} in step")
	public void verifyStatus(String status) {

		if (status.equals("success")) {
			WebElement emailSent = driver.findElement(By.cssSelector("h1[class*=margin-bottom--lv3]"));
			assertEquals("Check your email", emailSent.getText());
		} else if (status.equals("failLong")) {
			WebElement sentLong = driver.findElement(By.cssSelector("span[class=invalid-error]"));
			assertEquals("Enter a value less than 100 characters long", sentLong.getText());
		} else if (status.equals("failUsed")) {
			WebElement sentUsed = driver.findElement(By.cssSelector("span[class=invalid-error]"));
			assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.",
					sentUsed.getText());
		} else {
			WebElement sentNoEmail = driver.findElement(By.cssSelector("span[class=invalid-error]"));
			assertEquals("Please enter a value", sentNoEmail.getText());
		}
		driver.quit();
	}

	private void click(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	private void sendKeys(By by, String keys) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(keys);
	}

}
