import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultPageStepdefs {
    private final static By cardName = By.cssSelector(".product-card__name");

    private WebDriver driver;

    public ResultPageStepdefs(DriverService service) {
        this.driver = service.getDriver();
    }

    @When("я вижу страницу с результатами")
    public void iAmOnResultPage() {
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("/search/"));
    }

    @When("и у всех книг есть слово {string} в названии")
    public void checkBookNames(String term) {
        List<WebElement> bookNames = driver.findElements(cardName);

        bookNames.forEach(bookName -> {
            String name = bookName.getText();
            System.out.println("name = " + name);
            assertTrue(name.contains(term));
        });
    }

    @When("я вижу пустую выдачу")
    public void iSeeEmptyResult() {
        String message = driver.findElement(By.cssSelector("h1")).getText();
        assertEquals("Все, что мы нашли в Лабиринте по запросу «»", message);
    }
}
