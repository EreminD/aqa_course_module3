package ru.inno.selenium.page_object.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.inno.selenium.page_object.page.SearchResultPage;

import static ru.inno.selenium.page_object.ext.WebDriverInitializr.WD_KEY;

public class SearchResultPageResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(SearchResultPage.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        WebDriver driver =
                extensionContext
                        .getStore(WebDriverInitializr.namespace)
                        .getOrComputeIfAbsent(WD_KEY, (s) -> new ChromeDriver(), WebDriver.class);

        return new SearchResultPage(driver);
    }
}
