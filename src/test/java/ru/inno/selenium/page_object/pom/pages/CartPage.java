package ru.inno.selenium.page_object.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {

    private final WebDriver driver;
    public final HeaderElement header;
    private final By cartIcon = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");
    private final By cartItemsLocator = By.cssSelector(".main_order-container div.need-watch");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.header = new HeaderElement(driver);
    }

    public String getCartIconCounter() {
        WebElement element = driver.findElement(cartIcon);
        return element.getText();
    }

    public int countBooksInCart() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.numberOfElementsToBe(cartItemsLocator, 5));
        return driver.findElements(cartItemsLocator).size();
    }

    public void checkBooksInCartNumberShouldBe(int x) {
        assertEquals(x, countBooksInCart());
    }

    public void checkIconCounterShouldBe(String s) {
        assertEquals("5", getCartIconCounter());
    }
}
