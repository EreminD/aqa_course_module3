package ru.inno.selenium.page_object.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.selenium.page_object.page.MainPage;

public class MainPageResolver implements ParameterResolver, BeforeEachCallback, AfterEachCallback {

    private WebDriver driver;
    public static final org.junit.jupiter.api.extension.ExtensionContext.Namespace namespace = ExtensionContext.Namespace.create("my_store");

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(MainPage.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new MainPage(driver);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (driver != null) {
            driver.quit();
            context.getStore(namespace).remove("driver");
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        driver = new ChromeDriver();
        context.getStore(namespace).put("driver", driver);
    }
}
