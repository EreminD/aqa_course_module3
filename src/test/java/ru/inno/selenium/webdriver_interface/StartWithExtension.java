package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class StartWithExtension {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions opts = new ChromeOptions();
        opts.addExtensions(new File("src/test/resources/User-Agent-Switcher-for-Chrome-Chrome.crx"));

        driver = new ChromeDriver(opts);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void screenshot() {
        driver.get("https://mail.ru");
    }
}
