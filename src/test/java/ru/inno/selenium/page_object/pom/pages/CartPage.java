package ru.inno.selenium.page_object.pom.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {
    public final HeaderElement header;
    private SelenideElement cartIcon = $(".b-header-b-personal-e-icon-count-m-cart");
    private ElementsCollection cartItems = $$(".main_order-container div.need-watch");
    private SelenideElement itemsList = $(".products-row");


    public CartPage() {
        this.header = new HeaderElement();
    }

    public String getCartIconCounter() {
        return cartIcon.text();
    }

    public int countBooksInCart() {
        cartItems.shouldHave(size(5));
        return cartItems.size();
    }

    @Step("Проверить, что в корзине лежит {x} товаров")
    public void checkBooksInCartNumberShouldBe(int x) {
        takeScreen(itemsList);
        assertEquals(x, countBooksInCart());
    }

    @Attachment(type = "image/png", value = "cart", fileExtension = ".png")
    private byte[] takeScreen(SelenideElement element) {
        return element.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Проверить, что счетчик товаров в корзине равен {s}")
    public void checkIconCounterShouldBe(String s) {
        assertEquals(s, getCartIconCounter());
    }
}
