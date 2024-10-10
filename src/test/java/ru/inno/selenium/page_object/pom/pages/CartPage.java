package ru.inno.selenium.page_object.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.inno.selenium.page_object.pom.elements.HeaderElement;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {

    private final WebDriverWait wait;
    public final HeaderElement header;

    @FindBy(css = ".b-header-b-personal-e-icon-count-m-cart")
    private WebElement cartIcon;
    @FindBy(css = ".main_order-container div.need-watch")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        this.header = new HeaderElement(driver);
    }

    public String getCartIconCounter() {
        return cartIcon.getText();
    }

    public int countBooksInCart() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".main_order-container div.need-watch"), 5));;
        return cartItems.size();
    }

    public void checkBooksInCartNumberShouldBe(int x) {
        assertEquals(x, countBooksInCart());
    }

    public void checkIconCounterShouldBe(String s) {
        assertEquals("5", getCartIconCounter());
    }
}
