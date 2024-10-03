package ru.inno.selenium.labirint;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenLabirintAndAddBooks {
    private WebDriver driver;
    private WebDriverWait wait;
    private long pause = 5000L;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addBooks() throws InterruptedException {
        String url = "https://www.labirint.ru/";
        By formLocator = By.cssSelector("#searchform");
        By searchInput = By.cssSelector("#search-field");
        By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");
        By cartItemsLocator = By.cssSelector(".main_order-container div.need-watch");

        driver.get(url);

        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        WebElement form = driver.findElement(formLocator);
        form.findElement(searchInput).sendKeys("Java");
        form.submit();

        // form.findElement(By.cssSelector("#search-field")).sendKeys("Java", Keys.RETURN);

        List<WebElement> buyButtons = driver.findElements(By.cssSelector(".search-result .btn-tocart"));

        for (int i = 0; i < 5; i++) {
            buyButtons.get(i).click();
        }

        wait.until(ExpectedConditions.textToBe(cartIconLocator, "5"));
        driver.findElement(cartIconLocator).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(cartItemsLocator, 5));
        int countBooksInBasket = driver.findElements(cartItemsLocator).size();

        Thread.sleep(2000L);

        assertEquals(5, countBooksInBasket);
        assertEquals("5", driver.findElement(cartIconLocator).getText());
    }
}