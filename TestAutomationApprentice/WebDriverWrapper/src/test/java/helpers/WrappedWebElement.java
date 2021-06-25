package helpers;

import org.openqa.selenium.WebElement;

public class WrappedWebElement {

    private WebElement webElement;

    public WrappedWebElement(WebElement element) {
        webElement = element;
    }

    public String getText() {
        return webElement.getText();
    }

    public void click() {
        webElement.click();
    }
}
