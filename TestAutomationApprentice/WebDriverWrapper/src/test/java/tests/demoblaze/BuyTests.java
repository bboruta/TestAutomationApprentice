package tests.demoblaze;

import helpers.WrappedDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.withWrappers.CartPage;
import pages.withWrappers.Header;
import pages.withWrappers.ProductPage;
import pages.withWrappers.ProductsTable;
//import pages.CartPage;
//import pages.Header;
//import pages.ProductPage;
//import pages.ProductsTable;

import java.util.concurrent.TimeUnit;

public class BuyTests {

    private static WebDriver driver;
    private static WrappedDriver wrappedDriver;

    @BeforeAll
    public static void ClassSetup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        wrappedDriver = new WrappedDriver(driver);
    }

    @AfterAll
    public static void ClassTeardown() {
        driver.quit();
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"Samsung galaxy s6"})
//    public void WhenProductAddedToCart_ThenItIsVisibleInTheCart(String productName) {
//        // arrange
//        ProductsTable productsTable = new ProductsTable(driver);
//        ProductPage productPage = new ProductPage(driver);
//        Header header = new Header(driver);
//        CartPage cartPage = new CartPage(driver);
//
//        // act
//        productsTable.selectProductByName(productName);
//        productPage.addProductToCart();
//
//        // assert
//        header.goToCart();
//        String firstItemFromCartText = cartPage.getTextForFirstProductInCart();
//
//        Assertions.assertTrue(firstItemFromCartText.contains(productName));
//    }

    @ParameterizedTest
    @ValueSource(strings = {"Samsung galaxy s6"})
    public void WRAPPED_WhenProductAddedToCart_ThenItIsVisibleInTheCart(String productName) {
        // arrange
        ProductsTable productsTable = new ProductsTable(wrappedDriver);
        ProductPage productPage = new ProductPage(wrappedDriver);
        Header header = new Header(wrappedDriver);
        CartPage cartPage = new CartPage(wrappedDriver);

        // act
        productsTable.selectProductByName(productName);
        productPage.addProductToCart();

        // assert
        header.goToCart();
        String firstItemFromCartText = cartPage.getTextForFirstProductInCart();

        Assertions.assertTrue(firstItemFromCartText.contains(productName));
    }
}
