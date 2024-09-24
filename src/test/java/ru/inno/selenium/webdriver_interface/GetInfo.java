package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetInfo {
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
        String url = "https://ya.ru";
        driver.get(url);

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        String source = driver.getPageSource();

        System.out.println(title);
        System.out.println(currentUrl);
        System.out.println(source);
    }

    @Test
    public void getUrl() {
        String url = "https://ya.ru";
        driver.get(url);

        for (int i = 0; i < 100; i++) {
            System.out.println(driver.getCurrentUrl());
        }
    }
}
