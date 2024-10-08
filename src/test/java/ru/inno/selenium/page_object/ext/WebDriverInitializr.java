package ru.inno.selenium.page_object.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInitializr implements TestInstancePreConstructCallback , AfterEachCallback {

    public static final ExtensionContext.Namespace namespace = ExtensionContext.Namespace.create("my_store");
    public static final String WD_KEY = "driver";

    @Override
    public void preConstructTestInstance(TestInstanceFactoryContext factoryContext, ExtensionContext context) throws Exception {
//        driver = new ChromeDriver();
//        context.getStore(namespace).put(WD_KEY, driver);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        WebDriver d = context.getStore(namespace).get(WD_KEY, WebDriver.class);
        if (d != null){
            d.quit();
            context.getStore(namespace).remove(WD_KEY);
        }
    }
}
