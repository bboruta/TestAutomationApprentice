package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(css = "#tbodyid a")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addProductToCart() {
        addToCartButton.click();
    }
}
