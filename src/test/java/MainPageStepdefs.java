import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Затем;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageStepdefs {
    private final static By formLocator = By.cssSelector("#searchform");
    private final static By searchInput = By.cssSelector("#search-field");
    private WebDriver driver;

    public static final String url = "https://www.labirint.ru/";

    public MainPageStepdefs(DriverService service) {
        this.driver = service.getDriver();
    }

    @Given("я открываю главную страницу")
    public void openMainPage() {
        driver.get(url);
    }

    @When("я выполняю поиск {string}")
    public void searchTerm(String term) {
        WebElement form = driver.findElement(formLocator);
        form.findElement(searchInput).sendKeys(term);
        form.submit();
    }

    @Затем("ставлю куки {string}")
    public void setCookie(String cookiePair) {
        String[] pair = cookiePair.split("=");
        Cookie cookie = new Cookie(pair[0], pair[1]);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
