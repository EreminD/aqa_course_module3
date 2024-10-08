package ru.inno.selenium.page_object;

import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.inno.selenium.page_object.page.CartPage;
import ru.inno.selenium.page_object.page.MainPage;
import ru.inno.selenium.page_object.page.SearchResultPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SeleniumJupiter.class)
public class LabirintTest {

    public static final String url = "https://www.labirint.ru/";

    @DriverCapabilities
    Capabilities capabilities = new ChromeOptions().setPageLoadStrategy(PageLoadStrategy.EAGER);

    //    @Arguments("--start-maximized") TODO: ??
    @Test
    public void addBooks(WebDriver driver) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(url);
        mainPage.searchFor("Java");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.addBooksToCart(5);
        searchResultPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        assertEquals(5, cartPage.countBooksInCart());
        assertEquals("5", cartPage.getCartIconCounter());
    }

    @Test
    public void emptySearch(WebDriver driver) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(url);
        mainPage.searchFor("вапвроплроавыпинртивапиваип");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertEquals("Мы ничего не нашли по вашему запросу! Что делать?", searchResultPage.getErrorText());
    }
}
