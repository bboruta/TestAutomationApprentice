package pages.withWrappers;

import helpers.WrappedDriver;
import helpers.WrappedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WrappedDriver wrappedDriver;

    // we cannot use PageFactory with this implementation :(
//    @FindBy(id = "cartur")
//    private WrappedWebElement cartLink;

    public Header(WrappedDriver wrappedDriver) {
        //PageFactory.initElements(wrappedDriver.getDriver(), this);
        this.wrappedDriver = wrappedDriver;
    }

    public void goToCart() {
        WrappedWebElement cartLink = wrappedDriver.findElement(By.id("cartur"));
        cartLink.click();
    }
}
