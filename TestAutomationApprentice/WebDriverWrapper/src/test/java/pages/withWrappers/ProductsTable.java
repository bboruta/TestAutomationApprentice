package pages.withWrappers;

import helpers.WrappedDriver;
import helpers.WrappedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsTable {

    private WrappedDriver wrappedDriver;

    public ProductsTable(WrappedDriver wrappedDriver) {
        PageFactory.initElements(wrappedDriver.getDriver(), this);
        this.wrappedDriver = wrappedDriver;
    }

    public void selectProductByName(String productName) {
        String locator = "//*[@id=\"tbodyid\"]//h4[@class='card-title']/a[contains(text(),'" + productName + "')]";
        wrappedDriver.findElement(By.xpath(locator)).click();
    }
}
