package stepDefinitionsSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionsSelenium {
	private WebDriver driver;

	

	@Given("I have used {string} as browser")
	public void i_have_used_as_browser(String browser) {
		DriveCreator creator = new DriveCreator();
		driver = creator.createBrowser(browser);
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 
	@Given("I have logged in at Mailchimp")
	public void i_have_logged_in_at_mailchimp() {

	}

	@Given("I have entered {string}")
	public void i_have_entered(String email) {

	}

	@Given("I enter an username {string}")
	public void i_enter_an_username(String userName) {

	}

	@Given("I enter a password {string}")
	public void i_enter_a_password(String password) {

	}

	@When("I press signUp")
	public void i_press_signUp() {

	}

	@Then("I verify the success in step")
	public void i_verify_the_success_in_step() {

		
	}
	
	
}
