package ru.inno.selenium.page_object.pom.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderElement {
    private final By cartIconLocator = By.cssSelector(".b-header-b-personal-e-icon-count-m-cart");
    private final By searchInput = By.cssSelector("#search-field");
    private final By formLocator = By.cssSelector("#searchform");
    private final WebDriver driver;

    public HeaderElement(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement form;
    @Step("Выполнить поиск по слову {term}")
    public void searchFor(String term) {
        form = driver.findElement(formLocator);
        typeTermIn(term);
        submitForm();
    }

    @Step("Ввести поисковый запрос {term}")
    private void typeTermIn(String term){
        form.findElement(searchInput).sendKeys(term);
    }

    @Step("Нажать Enter")
    private void submitForm(){
        form.submit();
    }

    @Step("Перейти в корзину")
    public void goToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.textToBe(cartIconLocator, "5"));
        driver.get("https://www.labirint.ru/cart/");
    }
}
