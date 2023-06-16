import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Loginsparametarization {
    WebDriver driver = null;

    @DataProvider(name = "data-set")
    public static Object[][] DataSet() {
        Object[][] obj = {
                {"valid", "standard_user", "secret_sauce"},
             {"Invalid", "locked_out_user", "secret_sauce"},
                {"valid", "problem_user", "secret_sauce"},
              {"valid", "performance_glitch_user", "secret_sauce"},
                {"Invalid", "ratnam", "radha"}
        };
        return obj;
    }

    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        //System.out.println("\n\n \t Iam inside setUp method");
        //String url = "https://www.saucedemo.com/";
        String chromeDriverPath = "C:\\software\\chromedriver_win32 (3)\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        String LoginDataPath = "src/main/resources/userlogins.json";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        String url = (String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10);
        driver.quit();
    }

    @Test(dataProvider = "data-set")
    public void search(String type, String username, String password) throws IOException, ParseException, InterruptedException {
        System.out.println("type=" + type + " " + "username= " + username + " " + "password=" + password);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String TestCases = "src/main/resources/LoginTestCases.json";
        FileReader fr = new FileReader(TestCases);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        Thread.sleep(1000);
//        JSONObject jsonObject = (JSONObject) obj;
//        JSONObject tc = (JSONObject) jsonObject.get("tc01");
//        String username1 = (String) tc.get("username");
//        System.out.println(username1);
        if (type.equals("valid")) {
            System.out.println("login successfully");
        } else {
            System.out.println("Invalid login");
        }

    }
}