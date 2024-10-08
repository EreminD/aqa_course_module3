package ru.inno.selenium.page_object;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.inno.selenium.page_object.ext.CartPageResolver;
import ru.inno.selenium.page_object.ext.MainPageResolver;
import ru.inno.selenium.page_object.ext.SearchResultPageResolver;
import ru.inno.selenium.page_object.ext.WebDriverInitializr;
import ru.inno.selenium.page_object.page.CartPage;
import ru.inno.selenium.page_object.page.MainPage;
import ru.inno.selenium.page_object.page.SearchResultPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CartPageResolver.class)
@ExtendWith(MainPageResolver.class)
@ExtendWith(SearchResultPageResolver.class)
@ExtendWith(WebDriverInitializr.class)
public class LabirintTest {


    // наследование vs композиции
    @Test
    public void addBooks(MainPage mainPage, SearchResultPage searchResultPage, CartPage cartPage) {
        mainPage.open();

        mainPage.header.searchFor("Java");
        searchResultPage.addBooksToCart(5);
        searchResultPage.header.goToCart();

        cartPage.checkBooksInCartNumberShouldBe(5);
        cartPage.checkIconCounterShouldBe("5");

        cartPage.header.searchFor("JavaScript");

//        assertEquals(5, cartPage.countBooksInCart());
    }

    @Test
    public void emptySearch(MainPage mainPage, SearchResultPage searchResultPage) {
        mainPage.open();
        mainPage.header.searchFor("вапвроплроавыпинртивапиваип");

        assertEquals("Мы ничего не нашли по вашему запросу! Что делать?", searchResultPage.getErrorText());
    }
}
