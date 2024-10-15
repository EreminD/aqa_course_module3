package ru.inno.selenium.page_object;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.page_object.pom.elements.BookCard;
import ru.inno.selenium.page_object.pom.pages.CartPage;
import ru.inno.selenium.page_object.pom.pages.MainPage;
import ru.inno.selenium.page_object.pom.pages.SearchResultPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LabirintTest {
    private WebDriver driver;
    MainPage mainPage;
    SearchResultPage searchResultPage;
    CartPage cartPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addBooks() {
        mainPage.open();
        mainPage.header.searchFor("Java");
        searchResultPage.addBooksToCart(5);
        searchResultPage.header.goToCart();
        cartPage.checkBooksInCartNumberShouldBe(5);
        cartPage.checkIconCounterShouldBe("5");
        cartPage.header.searchFor("JavaScript");
    }

    @Test
    public void printBooks() {
        mainPage.open();
        mainPage.header.searchFor("Java");
        List<BookCard> items = searchResultPage.getBooks();
        System.out.println(items.size());
        for (BookCard card : items) {
            System.out.println(card.getTitle() + " – " + card.getPrice());
        }
    }

    @Test
    public void emptySearch() {
        mainPage.open();
        mainPage.header.searchFor("вапвроплроавыпинртивапиваип");

        assertEquals("Мы ничего не нашли по вашему запросу! Что делать?", searchResultPage.getErrorText());
    }

}
