package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class SearchPage  extends BasePage {

    public Hashtable<String, By> searchElements;

    public SearchPage() {
        super();
        this.searchElements = new Hashtable<>();
        searchElements.put("oscars",By.cssSelector("#imdbHeader > div.ipc-page-content-container.ipc-page-content-container--center.navbar__inner > aside > div > div._3bRJYEaOz1BKUQYqW6yb29 > div > div:nth-child(3) > span > div > div > ul > a:nth-child(1) > span"));
        searchElements.put("1929",By.xpath("//*[@id='right-5-react']/div/div[2]/div[16]/span[4]/a"));
        searchElements.put("the jazz singer",By.xpath("//a[contains(@href,'/title/tt0018037/?ref_=ev_nom')]"));

        this.pageElements = searchElements;
    }
}
