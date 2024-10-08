package ru.inno.selenium.page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    protected static final String url = "https://www.labirint.ru/";
    private final By searchInput = By.cssSelector("#search-field");
    private final By formLocator = By.cssSelector("#searchform");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    public void searchFor(String term) {
        WebElement form = driver.findElement(formLocator);
        form.findElement(searchInput).sendKeys(term);
        form.submit();
    }
}
