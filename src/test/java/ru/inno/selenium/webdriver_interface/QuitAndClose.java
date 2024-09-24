package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitAndClose {

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
    public void getDemo() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("#content a")).click();

        driver.close();
        driver.quit();
    }

}
