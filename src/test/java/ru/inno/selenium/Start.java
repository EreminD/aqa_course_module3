package ru.inno.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Start {

    public static void main(String[] args) {
        WebDriver driver_1 = new ChromeDriver();
        WebDriver driver_2 = new ChromeDriver();

        WebElement sendMessageToMax = driver_1.findElement(By.cssSelector(""));
        WebElement sendMessageToSam = driver_2.findElement(By.cssSelector(""));

        Class2.clickButton(sendMessageToMax);
        Class2.clickButton(sendMessageToSam);

        if (driver_1 != null) {
            driver_1.quit();
            driver_2.quit();
        }
    }
}
