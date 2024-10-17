package ru.inno.selenium.selenide.demos;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OpenLabirintAndAddBooks {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://www.labirint.ru";
        Configuration.browser = "firefox";
    }

    @Test
    public void addBooks() {
        SelenideElement form = $("#searchform input");
        ElementsCollection buttons = $$(".search-result .btn-tocart");
        SelenideElement icon = $(".b-header-b-personal-e-icon-count-m-cart");
        ElementsCollection cartItems = $$(".main_order-container div.need-watch");

        open("/");

        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("cookie_policy", "1"));
        refresh();

        form.setValue("Java").pressEnter();

        for (int i = 0; i < 5; i++) {
            buttons.get(i).click();
        }

        icon.shouldHave(text("5")).click();
        cartItems.shouldHave(size(5));
    }
}