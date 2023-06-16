package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginDemoSteps {
    WebDriver driver=null;

    @Given("browser is open")
    public void browser_is_open() {

        System.out.println("Inside step browser is open");
        String chromeDriverPath = "C:\\\\software\\\\chromedriver_win32 (3)\\\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }
    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://example.testproject.io/web/");

    }
    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Iswarya");
        driver.findElement(By.id("password")).sendKeys("12345");
        Thread.sleep(2000);

    }
    @And("user clicks on login")
    public void user_clicks_on_login() {
        driver.findElement(By.id("login")).click();

    }
    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() throws InterruptedException {

        driver.findElement(By.id("logout")).isDisplayed();
        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }

}
