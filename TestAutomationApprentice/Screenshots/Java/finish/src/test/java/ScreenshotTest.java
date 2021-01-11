import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotTest {

    private WebDriver driver;

    @Test
    public void getScreenshotTest() throws IOException {
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

        // we can take a screenshot now
        // we start with creating file name with path
        String targetPath = "C://screenshots//myscreenshot.png";
        // and now we can make a screenshot
        saveScreenshot(driver, targetPath);

        // screenshot of an element - we do it before whole page screenshot
        // as it will move our viewport to the bottom :)
        WebElement searchbox = driver.findElement(By.id("sb_form_q"));
        String ashotElementTargetPath = "C://screenshots//ashot_myelement.png";
        saveWebElementScreenshot(driver, searchbox, ashotElementTargetPath);

        // screenshot with AShot library
        String ashotTargetPath = "C://screenshots//ashot_myscreenshot.png";
        saveWholePageScreenshot(driver, ashotTargetPath);

        driver.quit();
    }

    private void saveScreenshot(WebDriver driver, String filePath) {
        // cast driver to TakeScreenshotObject
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        // create new file which will keep our screenshot
        File takenScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        // save srcFile as file on drive in filePath folder, C://screenshots for example
        // (or use any other other, depending on your operating system and preferences)
        // remember to import FileUtils in Maven! - https://mvnrepository.com/artifact/commons-io/commons-io/2.6
        File savedScreenshot = new File(filePath);
        try {
            // copyFile must be surrounded with try/catch as it is a managed exception
            // it could be also handled with throws clause in the function signature
            FileUtils.copyFile(takenScreenshot, savedScreenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveWholePageScreenshot(WebDriver driver, String filePath) throws IOException {
        // capture a screenshot as AShot object
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        // write an image to file
        ImageIO.write(screenshot.getImage(), "PNG", new File(filePath));
    }

    private void saveWebElementScreenshot(WebDriver driver, WebElement element, String filePath) throws IOException {
        // capture a screenshot as AShot object
        Screenshot screenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, element);
        // write an image to file
        ImageIO.write(screenshot.getImage(), "PNG", new File(filePath));
    }
}
