import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
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
