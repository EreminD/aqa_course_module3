package ru.inno.selenium.page_object.pom.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

public class MainPage {
    public final HeaderElement header;

    public MainPage() {
        this.header = new HeaderElement();
    }

    @Step("Открыть главную страницу")
    public void open() {
        attachDataTXT();
        Selenide.open("/");
        WebDriver webDriver = WebDriverRunner.getWebDriver();
        webDriver.manage().addCookie(new Cookie("cookie_policy", "1"));
        webDriver.manage().window().maximize();
        Selenide.refresh();
    }

    @Attachment(value = "data", type = "text/plain", fileExtension = ".txt")
    public String attachDataTXT() {
        return "This is the file content.";
    }

}
