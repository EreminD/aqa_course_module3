package ru.inno.selenium.page_object.webelement_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;

public class GetTextDemo {


    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void clickLogin() {
        driver.get("http://the-internet.herokuapp.com");

        // получаем только id элемента
        WebElement list = driver.findElement(By.cssSelector("ul"));
        System.out.println(list.getText());
        list.getScreenshotAs(OutputType.FILE).renameTo(Path.of("list.png").toFile());

    }

}
