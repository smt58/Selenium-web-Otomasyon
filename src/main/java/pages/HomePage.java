package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class HomePage extends BasePage {

    public Hashtable<String, By> homeElements;

    public HomePage() {
        super();
        this.homeElements = new Hashtable<>();
        commonElements.put("menu bar",By.cssSelector(".ipc-text-button.ipc-button--core-baseAlt.ipc-button--on-textPrimary:not(:enabled), .ipc-outline-button.ipc-button--core-baseAlt.ipc-button--on-textPrimary:not(:enabled)"));
        homeElements.put("anasayfa",By.xpath("//*[@id='home_img_holder']"));
        homeElements.put("search",By.xpath("//*[@id='suggestion-search']"));
        homeElements.put("ok",By.cssSelector("#iconContext-magnify"));
        homeElements.put("Caz Mugannisi",By.cssSelector("#main > div > div:nth-child(3) > table > tbody > tr:nth-child(1) > td.result_text > a"));
        homeElements.put("see all photos",By.cssSelector("a.ipc-button--on-onBase:nth-child(2) > div:nth-child(1) > div:nth-child(1)"));

        this.pageElements = homeElements;
    }
}
