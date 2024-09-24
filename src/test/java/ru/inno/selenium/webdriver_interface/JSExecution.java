package ru.inno.selenium.webdriver_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;

public class JSExecution {

    public static final String REMOVE_ADD = "document.querySelector(\".tgb-wrapper\").remove()";
    public static final String SET_BEST_SCORE = "localStorage.setItem(\"bestScore\", \"lol\")";

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
    public void removeElement() {
        driver.get("https://mail.ru/");
        ((JavascriptExecutor) driver).executeScript(REMOVE_ADD);
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).renameTo(Path.of("mail.png").toFile());
    }

    @Test
    public void editStorage(){
        driver.get("https://play2048.co/");
        ((JavascriptExecutor) driver).executeScript(SET_BEST_SCORE);
        driver.navigate().refresh();
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).renameTo(Path.of("2048.png").toFile());
    }
}



