package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Frames {

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
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-bottom");
        WebElement body = driver.findElement(By.cssSelector("body"));
        System.out.println(body.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        body = driver.findElement(By.cssSelector("body"));
        System.out.println(body.getText());


    }


}
