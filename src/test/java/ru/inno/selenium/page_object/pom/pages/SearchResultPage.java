package ru.inno.selenium.page_object.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.page_object.pom.elements.BookCard;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    public final HeaderElement header;
    @FindBy(css = ".search-error h1")
    private WebElement searchErrorText;
    @FindBy(css = ".product-card")
    private List<WebElement> books;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.header = new HeaderElement(driver);
    }

    public String getErrorText() {
        return searchErrorText.getText();
    }

    @Step("добавить в корзину {0} товаров")
    public void addBooksToCart(int count) {
        List<BookCard> bookCards = getBooks();
        for (int i = 0; i < count; i++) {
            bookCards.get(i).addToCart();
        }
    }

    public List<BookCard> getBooks() {
        List<BookCard> result = new ArrayList<>();
        books.forEach(e -> result.add(new BookCard(e)));

        return result; // 60
    }
}
