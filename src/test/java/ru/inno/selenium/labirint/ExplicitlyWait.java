package ru.inno.selenium.labirint;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitlyWait {


    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void clickOn75() {

        // Как долго ждать - Duration
        // Что конкретно ждать
        // Как часто полить

        driver.get("http://uitestingplayground.com/progressbar");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ZERO);

        WebElement progressbar = driver.findElement(By.cssSelector("#progressBar"));

        driver.findElement(By.cssSelector("#startButton")).click();

        wait.until(ExpectedConditions.attributeToBe(progressbar, "aria-valuenow", "75"));

        driver.findElement(By.cssSelector("#stopButton")).click();

        String result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println("result = " + result);

        System.out.println("Finish");

    }

}
