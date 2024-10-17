package ru.inno.selenium.selenide.demos;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class GetInfo {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        Configuration.browser = "firefox";
        Configuration.headless = false;
        Configuration.timeout = 16 * 1000L;
    }

    @Test
    public void getDemo() {
        String url = "https://ya.ru";
        open(url);

        String currentUrl = WebDriverRunner.url();
        String source = WebDriverRunner.source();
        String title = WebDriverRunner.getWebDriver().getTitle();

        System.out.println(title);
        System.out.println(currentUrl);
        System.out.println(source);
    }

    @Test
    public void getText() {
        open("http://uitestingplayground.com/ajax");
        $("#ajaxButton").click();
        $("#content").shouldHave(text("Data loaded with AJAX get request!"));
    }

    @Test
    public void getTrs() {
        step("Открыть страницу", () -> open("https://sky-todo-list.herokuapp.com/"));
        step("Проверить, что записей больше 100", () -> $$("tr").shouldHave(sizeGreaterThan(100), ofSeconds(3)));
    }

}
