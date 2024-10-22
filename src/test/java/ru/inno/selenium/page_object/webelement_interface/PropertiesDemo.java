package ru.inno.selenium.page_object.webelement_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PropertiesDemo {

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
    public void clickLogin() {
        driver.get("http://habr.com/ru/feed");

        // получаем только id элемента
        WebElement logo = driver.findElement(By.cssSelector(".tm-header__logo"));

        // font-size -> CSS
        String propName = "font-family";

        String val1 = logo.getCssValue(propName);
        String val2 = logo.getDomAttribute(propName);
        String val3 = logo.getDomProperty(propName);

        System.out.println("val1 = " + val1);
        System.out.println("val2 = " + val2);
        System.out.println("val3 = " + val3);

    }

}
