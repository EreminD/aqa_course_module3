package ru.inno.selenium.page_object.page;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    public final HeaderElement header;
    protected static final String url = "https://www.labirint.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.header = new HeaderElement(driver);
    }

    public void open() {
        driver.get(url);
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }


}
