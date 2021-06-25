package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTextForFirstProductInCart() {
        WebElement productFromCart = driver.findElement(By.cssSelector("#tbodyid tr"));
        return productFromCart.getText();
    }
}
