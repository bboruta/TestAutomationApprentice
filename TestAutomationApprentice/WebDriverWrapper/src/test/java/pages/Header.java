package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToCart() {
        cartLink.click();
    }
}
