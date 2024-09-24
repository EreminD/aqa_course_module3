package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieManagement {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void position() {
        driver.get("https://labirint.ru");

        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        Cookie pvid = driver.manage().getCookieNamed("PVID");
        
        driver.manage().getCookies().forEach(c -> System.out.println("c = " + c));
    }
}
