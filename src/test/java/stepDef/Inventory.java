package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Inventory extends env_target {

    @Given("Login process")
    public void loginProcess() {
        System.setProperty("web.driver.chromedriver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //Launch website
        driver.get(loginPage);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("root"))
        );

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.cssSelector("button[class='ladda-button btn btn-primary block full-width mb-4']")).submit();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wrapper")));
    }

    @Given("Navigate to Inventory Page")
    public void toInventory() {
        driver.get(inventoryPage);
    }

    @When("Search a product")
    public void searchProduct() {
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/input")).sendKeys("sapu");
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
    }

    @And("Click on Checkbox")
    public void clickCheckbox() {
        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/div/div[2]/div[1]/div/div[6]/div/div/span/div/label"));

        if (!checkBox.isSelected()) {
            checkBox.click();
        } else {
            System.out.println("Check box is toggled on");
        }
    }

    @And("Click on Inventory Adjustment button")
    public void clickAdjustment() {
        driver.findElement(By.cssSelector("button[class='ladda-button btn btn-primary m-l-xs']")).click();
    }

    @And("Update quantity by fill update column")
    public void updateQuantity() {

        Actions act = new Actions(driver);

        WebElement qField = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div[2]"));

        act.doubleClick(qField).perform();

        //driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[6]/div/input")).sendKeys("10");
    }

    @And("Click on save button")
    public void saveButton() {
        driver.findElement(By.className("ladda-button btn btn-primary std-btn-width")).submit();
    }

}