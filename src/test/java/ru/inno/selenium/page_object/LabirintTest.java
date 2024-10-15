package ru.inno.selenium.page_object;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ru.inno.selenium.page_object.pom.elements.BookCard;
import ru.inno.selenium.page_object.pom.pages.CartPage;
import ru.inno.selenium.page_object.pom.pages.MainPage;
import ru.inno.selenium.page_object.pom.pages.SearchResultPage;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Онлайн-магазин книг")
@Feature("Каталог товаров")
@DisplayName("Тесты на лабиринт")
@Owner("Еремин Д")
public class LabirintTest {
    private WebDriver driver;
    MainPage mainPage;
    SearchResultPage searchResultPage;
    CartPage cartPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Позитивный сценарий, добавление товаров в корзину")
    @Tag("positive")
    @Severity(SeverityLevel.BLOCKER)
    @Link(url = "https://ya.ru", name = "Яндекс")
    @TmsLink("Proj-456")
    @Issue("jira-98765")
    @Story("Как пользователь, я могу искать книги по слову, чтобы быстрее находить интересный мне товар")
    public void addBooks() {
        mainPage.open();
        mainPage.header.searchFor("Java");
        searchResultPage.addBooksToCart(5);
        searchResultPage.header.goToCart();

        step("Проверить корзину", () -> {
            cartPage.checkBooksInCartNumberShouldBe(5);
            cartPage.checkIconCounterShouldBe("5");
        });
        cartPage.header.searchFor("JavaScript");
    }

    @Test
    @Owner("Иванов И")
    @DisplayName("Печатаем информацию по книжкам")
    @Description("В этом тесте мы парсим сайт <h1>Лабиринта</h1>")
    @Tag("positive")
    @Disabled
    @Severity(SeverityLevel.TRIVIAL)
    public void printBooks() {
        mainPage.open();
        mainPage.header.searchFor("Java");
        List<BookCard> items = searchResultPage.getBooks();
        System.out.println(items.size());
        for (BookCard card : items) {
            System.out.println(card.getTitle() + " – " + card.getPrice());
        }
    }

    @Test
    @DisplayName("Пустой результат поиска")
    @Tag("negative")
    @Story("Как пользователь, я вижу сообщение о ненайденном товаре, чтобы не зависать на странице")
    @Severity(SeverityLevel.NORMAL)
    public void emptySearch() {
        mainPage.open();
        mainPage.header.searchFor("вапвроплроавыпинртивапиваип");

        step("Проверить корректность сообщения о пустом результате", () -> assertEquals("Мы ничего не нашли по вашему запросу! Что делать?", searchResultPage.getErrorText(), "Неправильный текст ошибки"));
    }

    @Test
    public void simpleScript() {

        String textToBe = "Книги, которые создали меня. Писатели рассказывают о своем читательском опыте";
        step("Открыть главную", () -> {
            mainPage.open();
        });
        step("Кликнуть на ссылку Рекомендуем", () -> driver.findElement(By.cssSelector(".b-header-b-logo-e-discount-e-text-m-long")).click());

        String text = driver.findElement(By.cssSelector(".b-goodssets-head-e-title")).getText();

        step("Проверить, что отображается текст " + textToBe, () -> assertEquals(textToBe, text));


    }

}
