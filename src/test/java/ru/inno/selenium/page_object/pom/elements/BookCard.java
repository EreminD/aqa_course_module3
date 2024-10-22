package ru.inno.selenium.page_object.pom.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookCard {
    private final By titleLocator = By.cssSelector("a.product-card__name");
    private final By priceLocator = By.cssSelector("div.product-card__price-current");
    private final By likeLocator = By.cssSelector("a.btn-like");
    private final By tocartLocator = By.cssSelector("a.btn-tocart");

    private final SelenideElement context;

    public BookCard(SelenideElement whereToSearch) {
        this.context = whereToSearch;
    }

    public void addToCart() {
        context.find(tocartLocator).click();
    }

    public String getTitle() {
        return context.find(titleLocator).text();
    }

    public String getPrice() {
        return context.find(priceLocator).text();
    }

}
