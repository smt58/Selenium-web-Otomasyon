package pages;

import org.openqa.selenium.By;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class BasePage {
    public Dictionary<String, By> pageElements;
    public Dictionary<String, By> commonElements;

    public BasePage() {
        this.pageElements = new Hashtable<>();
        this.commonElements = new Hashtable<>();
        commonElements.put("menu bar", By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(4) > a"));
//yeni

    }
}