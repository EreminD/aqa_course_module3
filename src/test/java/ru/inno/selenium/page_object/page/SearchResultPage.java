package ru.inno.selenium.page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    private final WebDriver driver;
    public final HeaderElement header;
    private final By searchErrorText = By.cssSelector(".search-error h1");
    private final By books = By.cssSelector(".search-result .btn-tocart");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.header = new HeaderElement(driver);
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
}
