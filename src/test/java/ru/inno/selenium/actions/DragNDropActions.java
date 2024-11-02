package ru.inno.selenium.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DragNDropActions {

    public static final String token = System.getProperty("trelloToken", "noToken");
    public static final String cookieName = "cloud.session.token";


    private WebDriver driver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "128");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            put("enableVNC", true);
            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});


        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void sendKeysAndGetText() throws InterruptedException {
        driver.get("https://trello.com/b/wEDviEAC/selenium");
        driver.manage().window().maximize();

        Cookie cookie = new Cookie(cookieName, token);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        new Actions(driver)
                .clickAndHold(driver.findElements(By.cssSelector("li[data-testid=list-card]")).get(0))
                .moveToElement(driver.findElements(By.cssSelector("li[data-testid=list-wrapper]")).get(1))
                .pause(200L)
                .release()
                .perform();

        new Actions(driver)
                .dragAndDrop(
                        driver.findElements(By.cssSelector("li[data-testid=list-card]")).get(0),
                        driver.findElements(By.cssSelector("li[data-testid=list-wrapper]")).get(1)
                )
                .perform();

    }
}


