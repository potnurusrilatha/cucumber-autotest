import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class loginStepDefinition {
    WebDriver driver;
    @Given("^navigate to saucedemo page$")
    public void navigate(){
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @When("^user logs in$")
    public void login(){

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ; //Deprecated

        driver.findElement(By.id("login-button")).click();

    }
    @Then("^home page should be displayed$")
    public void verifySuccessful(){
        String expectedText="Swag Labs";
        String actualText = driver.getTitle();
        assertEquals(actualText, expectedText);
        driver.quit();
    }
}