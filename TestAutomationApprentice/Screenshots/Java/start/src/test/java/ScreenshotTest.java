import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTest {

    private WebDriver driver;

    @Test
    public void getScreenshotTest() {
        // arrange
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        String phrase = "Robert Lewandowski";

        // act
        driver.get("https://www.bing.com/");
        WebElement searchForm = driver.findElement(By.name("q"));
        searchForm.sendKeys(phrase);
        searchForm.submit();

        // assert
        Assertions.assertTrue(driver.findElement(By.cssSelector("#nws_ht strong"))
                .getText()
                .contains(phrase));
    }
}
