package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class MySelenium3 extends TestBase{



    @Test //pick org.testing.annotation
    public static void searchBar(){

        setupDriver(); //this is chromedriver.exe  --> telling which browser to use
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
    public static void searchBarThenClickSearch(){

        setupDriver(); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("https://www.ebay.com"); //will go to ebay website


        //using id ---> sendkeys is to put "note 20 ultra case" on the search bar
        driver.findElement(By.id("gh-ac")).sendKeys("note 20 ultra case");

        //Bottom comment is to send using textname,, same result
        // driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("note 20 ultra case");

        //this is to click search after writing "note 20 ultra case" on the search bar
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

       //or you can use by just using id below, gives same result
        //driver.findElement(By.id("gh-btn")).click();

        //wait 2 seconds
        sleepFor(2);
        closeDriver();

    }

    @Test
    public static void listOfSearchOptions(){

        setupDriver(); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("http:www.ebay.com"); //will go to ebay website

        //this prints all the options from next to search, the Categories. NOTE: findElement
        String printDirectly = driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();
        System.out.println(printDirectly);

        //this is to count how many options/elements. NOTE: findElements
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(dropDown.size());

        //this is to select the 5th option on the categories
        dropDown.get(7).click();

        sleepFor(2);
        closeDriver();

    }

    @Test
    public static void typeOnSearchAndChoose(){

        setupDriver(); //this is chromedriver.exe  --> telling which browser to use
        navigateToURL("https://www.ebay.com"); //will go to ebay website




    }



}
