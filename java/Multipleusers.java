import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Multipleusers {

        WebDriver driver = null;

        @DataProvider(name = "data-set")
        public static Object[][] DataSet() {
            Object[][] obj = {
                    {"milkahreddy@gmail.com", "milkahreddy@gmail.com", "Milkah@1234"},//valid
                    {"abcd@gmail.com", "abcd@gmail.com", "hAaa@123"},
                    {"radha@gmail.com","radha@gmail.com","radhaaaa@4567"}

            };
            return obj;
        }

        @BeforeMethod
        public void setUp() throws IOException, ParseException {
            //System.out.println("\n\n \t Iam inside setUp method");
            //String url = "https://www.saucedemo.com/";
            String chromeDriverPath = "C:\\software\\chromedriver_win32 (3)\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
            String signUpUrl="https://login.mailchimp.com/signup/";
            driver.get(signUpUrl);

        }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(10);
            driver.quit();
        }

        @Test(dataProvider = "data-set")
        public void search(String email, String username, String password) throws IOException, ParseException {
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
            driver.findElement(By.xpath("//input[@id='new_username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys(password);
            // WebElement eleCheckBox = driver.findElement(By.cssSelector(checkBox));
            WebElement eleSign=driver.findElement(By.xpath("//*[@id='create-account-enabled']"));
            eleSign.click();
            driver.quit();
            System.out.println("successfully created new account");

        }
    }
