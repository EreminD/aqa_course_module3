package ru.inno.selenium.page_object.ext;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

public class WebDriverShutter implements AfterEachCallback {

    public static final ExtensionContext.Namespace namespace = ExtensionContext.Namespace.create("my_store");
    public static final String WD_KEY = "driver";

    @Override
    public void afterEach(ExtensionContext context) {
        WebDriver d = context.getStore(namespace).get(WD_KEY, WebDriver.class);
        if (d != null){
            d.quit();
            context.getStore(namespace).remove(WD_KEY);
        }
    }
}
