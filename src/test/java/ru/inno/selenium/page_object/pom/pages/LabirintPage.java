package ru.inno.selenium.page_object.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.labirint.ru/
public class LabirintPage {
    @FindBy(css = "input[id=\"search-field\"]")
    public WebElement searchFieldHeaderInput;

    @FindBy(css = "span[class*=\"b-header-b-personal-e-icon-m-close-m-cart\"]")
    public WebElement element;

    public LabirintPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}