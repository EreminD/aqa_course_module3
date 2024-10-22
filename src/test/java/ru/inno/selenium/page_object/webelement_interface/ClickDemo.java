package ru.inno.selenium.page_object.webelement_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class ClickDemo {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void clickLogin() {
        driver.get("https://habr.com/ru");

        // получаем только id элемента
        WebElement login = driver.findElement(By.cssSelector(".tm-header-user-menu__login"));
        login.click();

        String currentUrl = driver.getCurrentUrl();
        String urlStart = "https://account.habr.com/login/";
        assertTrue(currentUrl.startsWith(urlStart));
    }

    @Test
    public void clickFeedback() {
        driver.get("https://habr.com/ru");

        // получаем только id элемента
        driver.findElement(By.cssSelector("[href='/ru/feedback/']")).click();


        String currentUrl = driver.getCurrentUrl();
        String urlToBe = "https://habr.com/ru/feedback/";
        assertEquals(urlToBe, currentUrl);
    }

    @Test
    public void clickBanner() {
        driver.get("https://www.labirint.ru");

        // получаем только id элемента
        assertThrows(ElementNotInteractableException.class, () -> driver.findElement(By.cssSelector(".autobanner__center")).click());
    }
}
