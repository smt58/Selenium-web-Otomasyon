import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.BasePage;

public class MySteps extends BasePage {
    WebSteps websteps;

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) websteps.driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.embed(screenshot, "image/png");
            String link ="C:\\Users\\lenovo\\Documents\\WebFunctions\\target\\cucumber-html-report\\index.html";
                    System.out.println("<a href=\"" + link + "\">" + link + "</a>");
        }
        websteps.driver.quit();
    }

    @Before
    public void beforeScenario() {
        System.out.println("*************Before Scenario is Testing Start***********");
    }



    @When("^I save (\\w+(?: \\w+)*) elementi listeye ekle:(\\d+)$")
    public void save(String by, int listesayi){

        websteps.saved(by,listesayi);

    }

    @When("I compare list$")
    public void comparelist(){
        websteps.compare();
    }

    @When("I broken image detect$")
    public void brokenimage(){
        websteps.brokenimagefind();
    }





    @When("^I see (.*) page$")
    public void seePage(String page) {

        websteps.seePage(page);
    }

    @When("^I initialize (chrome|firefox) driver$")
    public void initializeChromeDriver(String browser) {
        websteps = new WebSteps();
        websteps.initializeDriver(browser);
    }

    @When("^I go to \"([^\"]*)\" url$")
    public void gotoURL(String url) {
        websteps.openUrl(url);
    }

    @When("^I wait (.*) element (\\d+) seconds$")
    public void waitElement(String element, int timeout) throws InterruptedException {
        websteps.waitElement(element, timeout);
    }

    @When("^(?:I )?click element: (\\w+(?: \\w+)*) index: (\\d+)$")
    public void clickElement(String element,int index) {
        WebElement object = websteps.findElement(element,index-1);

        if (object != null) {
            object.click();
            System.out.println("Clicked on object-->" + element);
        } else {
            System.out.println("Could not click on object-->" + element);
        }
    }

    @When("^I enter \"([^\"]*)\" text to (.*) text area$")
    public void enterText(String text, String element) throws InterruptedException {
        mouseHover(element);
        WebElement object;
        object = websteps.findElement(element,0);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

    @When("^I click \"([^\"]*)\" keyboard button$")
    public void clickKeyboard(String key) {
        websteps.clickKeyboard(key);
    }

    @When("^I do click \"([^\"]*)\" keyboard button with \"([^\"]*)\" element$")
    public void clickKeyboardWithElement(String key, String element) {
        websteps.clickKeyboardWithElement(key, element);
    }

    @When("^(?:I )?wait for (\\d+) seconds?$")
    public void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @When("^I send text \"([^\"]*)\" to  \"([^\"]*)\" element$")
    public void sendText(String value, String element) {
        websteps.enterText(value, element);
    }

    @When("^(?:I )?focus (.*) element$")
    public void mouseHover(String element) throws InterruptedException {
        Actions actions = new Actions(websteps.driver);
        WebElement elem = null;
        elem = websteps.waitElement(element, 5);
        actions.moveToElement(elem).perform();
        Thread.sleep(2000);
    }

    @When("^(?:I )?clean (.*) then I enter \"([^\"]*)\" text$")
    public void cleanField(String element, String text) throws InterruptedException {
        By elem = websteps.page.pageElements.get(element);
        websteps.driver.findElement(elem).clear();
        waitForNSeconds(2);
        enterText(text, element);
    }

    @When("^(?:If)? exist (\\w+(?: \\w+)*)$")
    public void ifExist(String elementKey) throws InterruptedException {
        WebElement element = null;
        element = websteps.waitElement(elementKey, 5);
        try {
            if (element != null) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^(?:I )verify cargo price (included|not included) then by taking the (.*) element difference from (.*) element$")
    public void controlCargoPrice(String option, String productPrice, String totalPrice) {

        String firstText= websteps.findElement(productPrice,0).getText();
        int firstPosition=firstText.indexOf(" ");
        String firstValue = firstText.substring(0,firstPosition).replace(",",".");

        String secondText= websteps.findElement(totalPrice,0).getText();
        int secondPosition=firstText.indexOf(" ");
        String secondValue = secondText.substring(0,secondPosition).replace(",",".");

        float difference = Math.abs(Float.parseFloat(secondValue) - Float.parseFloat(firstValue));

        if (option.equals("included")) {
            Assert.assertFalse((int)difference == 0);
        } else if (option.equals("not included")) {
            Assert.assertFalse((int)difference != 0);
        }
    }
}