package pages.withWrappers;

import helpers.WrappedDriver;
import helpers.WrappedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WrappedDriver wrappedDriver;

    public CartPage(WrappedDriver wrappedDriver) {
        PageFactory.initElements(wrappedDriver.getDriver(), this);
        this.wrappedDriver = wrappedDriver;
    }

    public String getTextForFirstProductInCart() {
        WrappedWebElement productFromCart = wrappedDriver.findElement(By.cssSelector("#tbodyid tr"));
        return productFromCart.getText();
    }
}
