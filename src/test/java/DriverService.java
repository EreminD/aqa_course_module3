import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverService {
    private WebDriver driver;

    // Singleton
    public WebDriver getDriver() {

        if (this.driver == null){
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER);
            this.driver = new ChromeDriver(options);
        }

        return this.driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
