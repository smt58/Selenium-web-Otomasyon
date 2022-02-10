package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class SearchResultsPage extends BasePage {

    public Hashtable<String, By> searchResultsElements;

    public SearchResultsPage() {
        this.searchResultsElements = new Hashtable<>();
        searchResultsElements.put("director",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[1]/div/ul/li/a"));
        searchResultsElements.put("writer1",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div/ul/li[1]/a"));
        searchResultsElements.put("play",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div/ul/li[1]/span"));

        searchResultsElements.put("writer2",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div/ul/li[2]/a"));

        searchResultsElements.put("adaptation",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div/ul/li[2]/span"));

        searchResultsElements.put("writer3",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div/ul/li[3]/a"));

        searchResultsElements.put("titles",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[2]/div/ul/li[3 ]/span"));

        searchResultsElements.put("star1",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[3]/div/ul/li[1]/a"));
        searchResultsElements.put("star2",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[3]/div/ul/li[2]/a"));
        searchResultsElements.put("star3",By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[1]/div[3]/ul/li[3]/div/ul/li[3]/a"));



        searchResultsElements.put("all sellers button", By.xpath("//a[@class='optionsLength unVisible']"));
        searchResultsElements.put("add to cart button", By.xpath("//button [@class='add-to-basket button']"));
        searchResultsElements.put("continue to cart button", By.xpath("//*[(text()='Sepete Ekle')]//parent::button//parent::div"));
        searchResultsElements.put("my cart button", By.xpath("//*[contains(text(),'Sepetim') and (//span [@class='sf-OldMyAccount-2cv9i sf-OldMyAccount-mWelr'])]//parent::a"));
        this.pageElements = searchResultsElements;
    }
}