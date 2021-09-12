package stepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import junit.framework.Assert; 

public class Steps {
	public WebDriver driver;
	public LoginPage lp; 
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.gecko.driver","D:\\Driver\\geckodriver.exe");
		driver= new ChromeDriver();
	    lp=new LoginPage(driver);
	    throw new io.cucumber.java.PendingException();
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(url);
	    throw new io.cucumber.java.PendingException();
	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
		lp.setUserName(email);
		lp.setPassword(password);
	    throw new io.cucumber.java.PendingException();
	}

	@When("Click on Login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
		lp.clickLogin();
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}

}
