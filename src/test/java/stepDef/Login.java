package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target {

    @Given("User is on login page")
    public void onLoginPage() {
        System.setProperty("web.driver.chromedriver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Launch website
        driver.get(loginPage);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("root"))
        );
    }

    @When("User fill email and password")
    public void fillData() {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("User click login button")
    public void clickLoginButton() {
        driver.findElement(By.cssSelector("button[class='ladda-button btn btn-primary block full-width mb-4']")).submit();
    }

    @Then("User verify login result")
    public void verifyLoginResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wrapper")));

        driver.quit();
    }
}