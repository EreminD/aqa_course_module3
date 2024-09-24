package ru.inno.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Start {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        if (driver != null) {
            driver.quit();
        }
    }
}
