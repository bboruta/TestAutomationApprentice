package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrappedDriver {

    private WebDriver driver;

    public WrappedDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WrappedWebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        return new WrappedWebElement(element);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
