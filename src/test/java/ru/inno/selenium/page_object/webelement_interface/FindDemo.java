package ru.inno.selenium.page_object.webelement_interface;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class FindDemo {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findSubElement() {
        driver.get("https://the-internet.herokuapp.com/");

        //1
        WebElement footer = driver.findElement(By.xpath("//body/div[@id='page-footer']"));
        List<WebElement> divs = footer.findElements(By.xpath(".//div"));

        //2
        List<WebElement> footerDivs = driver.findElements(By.xpath("//body/div[@id='page-footer']//div"));

        System.out.println(divs.size());
        System.out.println(footerDivs.size());

    }
}