package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Window {

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

        driver.manage().window().setPosition(new Point(-500,0));
        Point position = driver.manage().window().getPosition();

        System.out.println("position = " + position);

    }

    @Test
    public void size(){

        driver.manage().window().setSize(new Dimension(500, 500));

        driver.get("https://ya.ru");

        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);
    }

    @Test
    public void window(){
        driver.get("https://ya.ru");

        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
    }

}
