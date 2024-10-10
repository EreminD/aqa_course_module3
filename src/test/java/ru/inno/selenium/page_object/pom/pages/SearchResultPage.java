package ru.inno.selenium.page_object.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.inno.selenium.page_object.pom.elements.BookCard;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    private final WebDriver driver;
    public final HeaderElement header;
    private final By searchErrorText = By.cssSelector(".search-error h1");
    private final By books = By.cssSelector(".product-card");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.header = new HeaderElement(driver);
    }

    public String getErrorText() {
        return driver.findElement(searchErrorText).getText();
    }

    public void addBooksToCart(int count) {
        List<BookCard> bookCards = getBooks();
        for (int i = 0; i < count; i++) {
            bookCards.get(i).addToCart();
        }
    }

    public List<BookCard> getBooks() {
        List<BookCard> result = new ArrayList<>();

        List<WebElement> elements = driver.findElements(books); // 60
        elements.forEach(e -> result.add(new BookCard(e)));

        return result; // 60
    }
}
