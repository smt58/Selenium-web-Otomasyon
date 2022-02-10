import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class WebSteps implements MainSteps {
    public WebDriver driver;
    public BasePage page;
    protected Logger log = Logger.getLogger(this.getClass().getName());


    static List<String> list = new ArrayList<String>(); // Good, List of String
    static List<String> liste2 = new ArrayList<String>(); // Good, List of String

    public void initializeDriver(String browser) {
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            System.setProperty("webdriver.chrome.driver", FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }


    public void saved(String by, int listesayi) {
        WebElement object;
        log.info("saved element");

        By elem = page.pageElements.get(by);
        object = driver.findElements(elem).get(0);


        if(listesayi==0){
            String text= object.getText();

            list.add(text);
            System.out.println(list);

        }else{
            String text= object.getText();

            liste2.add(text);
            System.out.println(liste2);
        }


    }



    public void compare() {
        log.info("compare list");

        Assert.assertEquals(list, liste2);

    }


    public void brokenimagefind() {
        for(int i=1;i<45;i++){
            WebElement broken=driver.findElement(By.xpath("//*[@id='media_index_thumbnail_grid']/a["+i+"]/img"));
            String brokenurl=broken.getAttribute("src");
            CloseableHttpClient client= HttpClientBuilder.create().build();
            HttpRequest request=new HttpGet(brokenurl);
            try {
                HttpResponse response= null;

                response = client.execute((HttpUriRequest) request);
                int statuscode=response.getStatusLine().getStatusCode();
                System.out.println(statuscode);
                if (statuscode != 200)
                {
                    log.info("is broken ımage.");
                    System.out.println("is broken ımage.");

                }else{
                    log.info("is broken ımage.");

                    System.out.println("is not broken ımage.");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
           // int statuscode=response.getStatusLine().getStatusCode();



        }
    }

    public void seePage(String pageName) {
        log.info("see page");

        switch (pageName) {

            case "home":
                page = new HomePage();
                break;
            case "search":
                page = new SearchPage();
                break;
            case "search results":
                page = new SearchResultsPage();
                break;
            default:
                break;
        }
    }

    public void openUrl(String url) {
        this.driver.navigate().to(url);
        System.out.println(url + " address was reached.");
    }

    public WebElement findElement(String element, int index) {
        try {
            WebElement object;

            By elem = page.pageElements.get(element);

            if (elem == null) {
                elem = page.commonElements.get(element);
            }
            object = driver.findElements(elem).get(index);
            System.out.println("Object found : " + element);
            return object;
        } catch (Exception e) {
            Assert.fail("Element is not found!");
            return null;
        }
    }

    public WebElement waitElement(String element, int timeout) throws InterruptedException {
        WebElement object;
        for (int i = 0; i < timeout; i++) {

            object = findElement(element, 0);
            if (object != null) {
                Thread.sleep(2000);
                return object;
            } else {
                Thread.sleep(2000);
            }
        }
        Assert.fail("Waiting element is not found!");
        return null;
    }

    public void clickElement(String element, int index) throws InterruptedException {
        WebElement object = waitElement(element, 30);

        if (object != null) {

            findElement(element, index).click();

            System.out.println("Clicked on object-->" + element);
        } else {
            System.out.println("Could not click on object-->" + element);
        }
    }

    public void enterText(String text, String element) {
        WebElement object;
        object = findElement(element, 0);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

    public void clickKeyboard(String key) {
        Actions action = new Actions(driver);
        switch (key) {
            case "ENTER":
                action.sendKeys(Keys.ENTER).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "TAB":
                action.sendKeys(Keys.TAB).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "PAGE_DOWN":
                action.sendKeys(Keys.PAGE_DOWN).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "PAGE_UP":
                action.sendKeys(Keys.PAGE_UP).build().perform();
                System.out.println(key + " clicked.");
                break;
            default:
                break;
        }
    }

    public void clickKeyboardWithElement(String key, String element) {
        WebElement object = findElement(element, 0);
        if (object != null) {
            switch (key) {
                case "ENTER":
                    object.sendKeys(Keys.ENTER);
                    break;
                case "TAB":
                    object.sendKeys(Keys.TAB);
                    break;
                case "PAGE_DOWN":
                    object.sendKeys(Keys.PAGE_DOWN);
                    break;
                case "PAGE_UP":
                    object.sendKeys(Keys.PAGE_UP);
                    break;
                default:
                    break;
            }
        }
    }
}
