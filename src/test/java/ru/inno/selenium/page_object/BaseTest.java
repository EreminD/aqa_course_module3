package ru.inno.selenium.page_object;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.inno.selenium.page_object.pom.pages.CartPage;
import ru.inno.selenium.page_object.pom.pages.MainPage;
import ru.inno.selenium.page_object.pom.pages.SearchResultPage;

import java.time.Duration;

public abstract class BaseTest {

    // config


    protected WebDriver driver;

    // pages
    protected MainPage mainPage;
    protected SearchResultPage searchResultPage;
    protected CartPage cartPage;

    // Db Helper

    // Api Helper

    // Config

    // Test Data

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        mainPage = new MainPage();
        searchResultPage = new SearchResultPage();
        cartPage = new CartPage();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
