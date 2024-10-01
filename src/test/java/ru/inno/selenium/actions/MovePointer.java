package ru.inno.selenium.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MovePointer {

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
        driver.get("https://tholman.com/cursor-effects/");

        Actions actions = new Actions(driver);
        actions.moveToLocation(50, 650).perform();

        for (int i = 0; i < 10; i++) {
            new Actions(driver)
                    .moveToLocation(50+i*10, 650+2*i).pause(50L).perform();
        }


    }
}

