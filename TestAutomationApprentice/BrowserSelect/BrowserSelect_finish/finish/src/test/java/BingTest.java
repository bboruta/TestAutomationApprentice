import helpers.ConfigProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BingTest {

    private WebDriver driver;
    private ConfigProvider configProvider;

    @Before
    public void setUp() {

        configProvider = new ConfigProvider();
        String browserName = configProvider.getBrowser();
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser not recognized, using chrome as default.");
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void inputPhraseTest() {
        // arrange
        String phrase = "Robert Lewandowski";

        // act
        driver.get("https://www.bing.com/");
        WebElement searchForm = driver.findElement(By.name("q"));
        searchForm.sendKeys(phrase);
        searchForm.submit();

        // assert
        Assert.assertTrue(driver.findElement(By.cssSelector("#nws_ht strong"))
                .getText()
                .contains(phrase));
    }
}
