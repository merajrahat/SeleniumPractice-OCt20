package com.peoplentech.seleniumpractice;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MySelenium3 extends TestBase {

    private static Logger LOGGER = Logger.getLogger(MySelenium3.class);

    @Test //pick org.testing.annotation
    public static void searchBar() {

        setupDriver("firefox"); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("https://www.amazon.com"); //will go to amazon.com website

        //search bar --> this is searcing by id, findElement not findElements
        driver.findElement(By.id("twotabsearchtextbox")); //test pass, next put something on search bar

        //sendkeys is to put "note 20 ultra case" on the search bar
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("note 20 ultra case");

        //wait 2 seconds
        sleepFor(2);
        closeDriver();

    }

    @Test //pick org.testing.annotation
    public static void searchBarThenClickSearch() {

        setupDriver("chrome"); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("https://www.ebay.com"); //will go to ebay website


        //using id ---> sendkeys is to put "note 20 ultra case" on the search bar
        driver.findElement(By.id("gh-ac")).sendKeys("note 20 ultra case");

        //Bottom comment is to send using textname,, same result
        // driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("note 20 ultra case");

        //this is to click search after writing "note 20 ultra case" on the search bar
        driver.findElement(By.xpath("//input[@id=\"gh-btn\"]")).click();

        //or you can use by just using id below, gives same result
        //driver.findElement(By.id("gh-btn")).click();

        //wait 2 seconds
        sleepFor(2);
        closeDriver();

    }

    @Test //pick org.testing.annotation
    public static void MySearchBarThenClickSearch() {

        setupDriver("chrome"); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("https://www.ebay.com"); //will go to ebay website


        //using id ---> sendkeys is to put "note 20 ultra case" on the search bar
        driver.findElement(By.id("gh-ac")).sendKeys("note 20 ultra case");

       //this is to click search after writing "note 20 ultra case" on the search bar
       // driver.findElement(By.xpath("//input[@id=''gh-btn']")).click();

        //or you can click by just using id below, gives same result
        driver.findElement(By.id("gh-btn")).click();

        //wait 2 seconds
        sleepFor(2);
        closeDriver();

    }

    @Test
    public static void listOfSearchOptions() {

        setupDriver("firefox"); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("http:www.ebay.com"); //will go to ebay website

        //this prints all the options from next to search, the Categories. NOTE: findElement
        String printDirectly = driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();
        LOGGER.info(printDirectly);

        //this is to count how many options/elements. NOTE: findElements
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        LOGGER.info(dropDown.size());

        //this is to select the 5th option on the categories
        dropDown.get(7).click();

        sleepFor(2);
        closeDriver();

    }

    @Test
    public static void typeOnSearchAndChoose() {

        setupDriver("chrome"); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("https://www.ebay.com"); //will go to ebay website

        //using id ---> sendkeys is to put "note 20 ultra case" on the search bar
        driver.findElement(By.id("gh-ac")).sendKeys("note 20 ultra case");

        //this is to press search after putting "note 20 ultra case" on the search bar
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        sleepFor(2);

        //this is for line 96, without this line, you can't print "note 20 ultra case, in InteliJ result
        WebElement searchedItem = driver.findElement(By.xpath("//span[text()='note 20 ultra case']"));

        //this is to write "note 20 ultra case" in the InteliJ result
        String actualText = searchedItem.getText();
        LOGGER.info(actualText);

        //this is to make sure what you type in the search and the result match, if it doesn't the test will fail
        //this is where you write what to expect
        Assert.assertEquals(actualText, "note 20 ultra case");


        //boolean is to see search item match displayed item
        boolean validate = searchedItem.isDisplayed();

        //this is to print true or false when the search item and dispalyed item match or not
        //and it will say true or false on the InteliJ result
        LOGGER.info(validate);

        closeDriver();

    }

    @Test
    public static void seleniumMethods() {
        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");

        //this is to go to search box, then line 122 is to click

        //this is to just click on the search button, without anything on the search box
        WebElement clickElement = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        clickElement.click();
        sleepFor(2);

        //line 125 gives same result as line 122. Just writing differently
        //driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        //this is to go click on eBay Motors
        driver.findElement(By.xpath("//h2[text()='eBay Motors']")).click();
        sleepFor(2);

        //this is you print the url in the InteliJ result
        String currentUrl = driver.getCurrentUrl();
        LOGGER.info(currentUrl);

        //where you get "Auto-Parts-and-Vehicles"
        Assert.assertTrue(currentUrl.contains("Auto-Parts-and-Vehicles"));


        //if the actual url doesn't match the expected url, the test will fail, here you write what to expect
        Assert.assertEquals(currentUrl, "https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334");


        sleepFor(2);
        closeDriver();

    }

    @Test
    public static void myMacysSearchMenShoes() {

        setupDriver("chrome");
        navigateToURL("https://macys.com");
        sleepFor(2);

        driver.findElement(By.id("globalSearchInputField")).sendKeys("men shoes");

        sleepFor(2);

        driver.findElement(By.xpath("//button[@id='searchSubmit']")).click();


        sleepFor(2);
        closeDriver();
    }
}
