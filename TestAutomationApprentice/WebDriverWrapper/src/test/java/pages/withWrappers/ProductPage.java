package pages.withWrappers;

import helpers.WrappedDriver;
import helpers.WrappedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WrappedDriver wrappedDriver;

//    @FindBy(css = "#tbodyid a")
//    private WebElement addToCartButton;

    public ProductPage(WrappedDriver wrappedDriver) {
        PageFactory.initElements(wrappedDriver.getDriver(), this);
        this.wrappedDriver = wrappedDriver;
    }

    public void addProductToCart() {
        WrappedWebElement addToCartButton = wrappedDriver.findElement(By.cssSelector("#tbodyid a"));
        addToCartButton.click();
    }
}
