package ru.inno.selenium.page_object.pom.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookCard {
    private final By titleLocator = By.cssSelector("a.product-card__name");
    private final By priceLocator = By.cssSelector("div.product-card__price-current");
    private final By likeLocator = By.cssSelector("a.btn-like");
    private final By tocartLocator = By.cssSelector("a.btn-tocart");

    private final WebElement context;

    public BookCard(WebElement whereToSearch) {
        this.context = whereToSearch;
    }

    public void addToCart() {
        context.findElement(tocartLocator).click();
    }

    public String getTitle() {
        return context.findElement(titleLocator).getText();
    }

    public String getPrice() {
        return context.findElement(priceLocator).getText();
    }

}
