package ru.inno.selenium.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragNDropActions {

    public static final String token = "e";
    public static final String cookieName = "cloud.session.token";


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
    public void sendKeysAndGetText() {
        driver.get("https://trello.com/b/wEDviEAC/selenium");
        driver.manage().window().maximize();
        Cookie cookie = new Cookie(cookieName, token);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        new Actions(driver)
                .clickAndHold(driver.findElements(By.cssSelector("li[data-testid=list-card]")).get(0))
                .moveToElement(driver.findElements(By.cssSelector("li[data-testid=list-wrapper]")).get(1))
                .pause(200L)
                .release()
                .perform();

        new Actions(driver)
                .dragAndDrop(
                        driver.findElements(By.cssSelector("li[data-testid=list-card]")).get(0),
                        driver.findElements(By.cssSelector("li[data-testid=list-wrapper]")).get(1)
                )
                .perform();

    }
}


