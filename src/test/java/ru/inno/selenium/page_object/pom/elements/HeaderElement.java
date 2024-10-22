package ru.inno.selenium.page_object.pom.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HeaderElement {
    private final SelenideElement form = $("#searchform");
    private final SelenideElement searchInput = $("#searchform #search-field");
    private final SelenideElement cartIcon = $(".b-header-b-personal-e-icon-count-m-cart");

    @Step("Выполнить поиск по слову {term}")
    public void searchFor(String term) {
        typeTermIn(term);
        submitForm();
    }

    @Step("Ввести поисковый запрос {term}")
    private void typeTermIn(String term) {
        searchInput.setValue(term);
    }

    @Step("Нажать Enter")
    private void submitForm() {
        form.submit();
    }


    @Step("Перейти в корзину")
    public void goToCart() {
        cartIcon.shouldHave(text("5"));
        open("/cart/");
    }
}
