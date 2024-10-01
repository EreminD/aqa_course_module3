package ru.inno.selenium.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.Keys.*;

public class KeyboardActions {
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
        driver.get("http://uitestingplayground.com/textinput");

        Keys command = Platform.getCurrent().is(Platform.MAC) ? COMMAND : CONTROL;

        WebElement input = driver.findElement(By.cssSelector("#newButtonName"));

        long pause = 1000L;

        new Actions(driver)
                .keyDown(LEFT_SHIFT)
                .sendKeys(input, "h")
                .pause(pause)
                .keyUp(LEFT_SHIFT)
                .pause(pause)
                .sendKeys(input, "ello!")
                .pause(pause)
                .keyDown(LEFT_SHIFT)
                .sendKeys(ARROW_UP)
                .keyUp(LEFT_SHIFT)
                .keyDown(command)
                .sendKeys("c")
                .pause(pause)
                .sendKeys("v")
                .sendKeys("v")
                .sendKeys("v")
                .pause(pause)
                .keyUp(command)
                .perform();

    }
}
