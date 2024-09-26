package ru.inno.selenium.webelement_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendKeysDemo {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void sendKeysAndGetText() {
        driver.get("http://uitestingplayground.com/textinput");

        String textToType = "Hello!";

        WebElement input = driver.findElement(By.cssSelector("#newButtonName"));

        input.sendKeys(textToType);
        input.sendKeys("a", "b", "c");
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(Keys.BACK_SPACE);

        WebElement button = driver.findElement(By.cssSelector("#updatingButton"));
        button.click();

        String txt = button.getText();

        assertEquals(textToType, txt);
    }

    @Test
    public void copyPasteTest() {
        driver.get("http://uitestingplayground.com/textinput");

        String textToType = "Hello!";
        String textToBe = "Hello!Hello!Hello!";

        WebElement input = driver.findElement(By.cssSelector("#newButtonName"));

        input.sendKeys(textToType);
        input.sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.ARROW_UP));
        input.sendKeys(Keys.chord(Keys.META, "c"));
        input.sendKeys(Keys.chord(Keys.META, "v"));
        input.sendKeys(Keys.chord(Keys.META, "v"));
        input.sendKeys(Keys.chord(Keys.META, "v"));

        WebElement button = driver.findElement(By.cssSelector("#updatingButton"));
        button.click();

        String txt = button.getText();

        assertEquals(textToBe, txt);
    }

    @Test
    public void game() {
        driver.get("https://www.2048.org");
        for (int i = 0; i < 100; i++) {
            WebElement body = driver.findElement(By.cssSelector("body"));
            body.sendKeys(Keys.ARROW_LEFT);
            body.sendKeys(Keys.ARROW_RIGHT);
            body.sendKeys(Keys.ARROW_DOWN);
        }
    }

    @Test
    public void inputFile() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement input = driver.findElement(By.cssSelector("#file-upload"));
        input.sendKeys("/Users/eremin/Documents/java-projects/aqa_module4/src/test/resources/User-Agent-Switcher-for-Chrome-Chrome.crx");

        driver.findElement(By.cssSelector("#file-submit")).click();



        String loadedFilename = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        assertEquals("User-Agent-Switcher-for-Chrome-Chrome.crx", loadedFilename);
    }
}
