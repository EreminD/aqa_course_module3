package ru.inno.selenium.page_object.pom.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

public class MainPage {
    private final WebDriver driver;
    public final HeaderElement header;
    protected static final String url = "https://www.labirint.ru/";

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
