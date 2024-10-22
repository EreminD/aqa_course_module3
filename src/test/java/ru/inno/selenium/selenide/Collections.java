package ru.inno.selenium.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.inno.selenium.selenide.HasChildCondition.hasChild;

public class Collections {

    @Test
    public void test() {
        open("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
        SelenideElement button = $("#my-dropdown-1");

        button.click();

        ElementsCollection lis = button.sibling(0).findAll("li"); //ul li
        
        lis.shouldHave(size(5))
                .filter(hasChild("a"))
                .shouldHave(size(4));
    }
}
