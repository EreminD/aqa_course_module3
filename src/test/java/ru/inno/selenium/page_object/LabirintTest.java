package ru.inno.selenium.page_object;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.page_object.pom.pages.CartPage;
import ru.inno.selenium.page_object.pom.pages.MainPage;
import ru.inno.selenium.page_object.pom.pages.SearchResultPage;


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


}
