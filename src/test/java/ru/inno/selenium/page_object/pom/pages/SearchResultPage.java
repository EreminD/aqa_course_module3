package ru.inno.selenium.page_object.pom.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.inno.selenium.page_object.pom.elements.BookCard;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    public final HeaderElement header;
    private final SelenideElement searchErrorText = $(".search-error h1");
    private ElementsCollection books = $$(".product-card");

    public SearchResultPage() {
        this.header = new HeaderElement();
    }

    public String getErrorText() {
        return searchErrorText.text();
    }

    @Step("добавить в корзину {0} товаров")
    public void addBooksToCart(int count) {
        List<BookCard> bookCards = getBooks();
        for (int i = 0; i < count; i++) {
            bookCards.get(i).addToCart();
        }
    }

    public List<BookCard> getBooks() {
        List<BookCard> result = new ArrayList<>();
        books.forEach(e -> result.add(new BookCard(e)));

        return result; // 60
    }
}
