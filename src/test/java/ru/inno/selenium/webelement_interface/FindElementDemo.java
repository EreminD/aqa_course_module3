package ru.inno.selenium.webelement_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FindElementDemo {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void getElement() {
        driver.get("https://habr.com/ru");

        // получаем только id элемента

        WebElement logo = driver.findElement(By.cssSelector(".tm-header__logo"));
        assertNotNull(logo);
    }

    @Test
    public void getList() {
        driver.get("https://habr.com/ru");

        List<WebElement> links = driver.findElements(By.cssSelector("a"));
        assertTrue(links.size() > 300);
    }

    @Test
    public void getEmptyList() {
        driver.get("https://habr.com/ru");

        List<WebElement> links = driver.findElements(By.cssSelector("not_real_tag_name"));
        assertEquals(0, links.size());
    }

    @Test
    public void getNoSuchElementException() {
        driver.get("https://habr.com/ru");

        assertThrows(NoSuchElementException.class,
                () -> driver.findElement(By.cssSelector(".not_a_real_css_class")));
    }

    @Test
    public void getTheFirstLink() {
        driver.get("https://habr.com/ru");

        WebElement theFirstLink = driver.findElement(By.cssSelector("a"));
        assertNotNull(theFirstLink);
    }
}
