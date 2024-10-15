package ru.inno.selenium.page_object.pom.pages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

public class MainPage {
    private final WebDriver driver;
    public final HeaderElement header;
    protected static final String url = "https://www.labirint.ru/";

    public MainPage( WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.header = new HeaderElement(driver);
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.manage().window().maximize();
        attachDataTXT();
        driver.get(url);
        Cookie cookie = new Cookie("cookie_policy", "1");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    @Attachment(value = "data", type = "text/plain", fileExtension = ".txt")
    public String attachDataTXT() {
        return "This is the file content.";
    }

}
