package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SwitchTabs {
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
    public void screenshot() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("#content a")).click();

        String windowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        String theSecondTab = null;

        for (String handle : windowHandles) {
            if (!handle.equalsIgnoreCase(windowHandle)) {
                theSecondTab = handle;
            }
        }

        // title == name
        driver.switchTo().window(theSecondTab);

        String text = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println("text = " + text); //New Window


    }

}
