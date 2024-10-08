package ru.inno.selenium.page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchResultPage {
    private final By searchErrorText = By.cssSelector(".search-error h1");
    private final By books = By.cssSelector(".search-result .btn-tocart");
    private final By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");

    private final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorText() {
        return driver.findElement(searchErrorText).getText();
    }

    public void addBooksToCart(int count) {
        List<WebElement> buyButtons = driver.findElements(books);
        for (int i = 0; i < count; i++) {
            buyButtons.get(i).click();
        }
    }

    public void goToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.textToBe(cartIconLocator, "5"));
        driver.get("https://www.labirint.ru/cart/");
    }


}
