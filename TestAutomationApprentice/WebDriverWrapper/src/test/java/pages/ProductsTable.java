package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsTable {

    private WebDriver driver;

    public ProductsTable(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectProductByName(String productName) {
        String locator = "//*[@id=\"tbodyid\"]//h4[@class='card-title']/a[contains(text(),'" + productName + "')]";
        driver.findElement(By.xpath(locator)).click();
    }
}
