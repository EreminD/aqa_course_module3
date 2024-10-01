package ru.inno.selenium.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    // hover
    // scroll
    // context
    //

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
        driver.get("https://jspaint.app/");

        WebElement canvas = driver.findElement(By.cssSelector(".main-canvas"));
        WebElement tools = driver.findElement(By.cssSelector(".tools"));
        WebElement brush = tools.findElement(By.cssSelector("[title='Кисть']"));
        WebElement zoom = tools.findElement(By.cssSelector("[title='Масштаб']"));
        WebElement paint = tools.findElement(By.cssSelector("[title='Заливка']"));
        WebElement rect = tools.findElement(By.cssSelector("[title='Прямоугольник']"));
        WebElement color = driver.findElement(By.cssSelector("[data-color='rgb(128,128,255)']"));


        long pause = 50L;

//        Actions actions = new Actions(driver);
//        actions.click(canvas).perform();
//        actions.moveByOffset(-300, -190);
//
//        for (int i = 0; i < 1; i++) {
//            actions.clickAndHold()
//                    .pause(pause)
//                    .moveByOffset(150+i+10, i+10)
//                    .pause(pause)
//                    .moveByOffset(i+10, 150+i+10)
//                    .pause(pause)
//                    .moveByOffset(-150+i+10, i+10)
//                    .pause(pause)
//                    .moveByOffset(i+10, -150+i+10)
//                    .release()
//                    .perform();
//        }



        // hover
//        driver.navigate().refresh();
//
//        WebElement view = driver.findElements(By.cssSelector(".menus [role=menuitem]")).get(2);
//        new Actions(driver)
//                .moveToElement(view)
//                .pause(200L)
//                .click()
//                .pause(200L)
//                .moveToElement(driver.findElements(By.cssSelector(".menu-hotkey")).get(5))
//                .pause(2000000L)
//                .perform();


        new Actions(driver)
                .contextClick(color)
                .click(brush)
                .moveToElement(canvas, -10, 0)
                .click()
                .moveToElement(canvas, 10, 0)
                .contextClick()
                .click(zoom)
                .doubleClick(canvas)
                .perform();

    }
}
