package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MySelenium3 extends TestBase{



    @Test //pick org.testing.annotation
    public static void searchBar(){

        setupDriver();
        navigateToURL("https://www.amazon.com");

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

        setupDriver();
        navigateToURL("https://www.amazon.com");


        //using id ---> sendkeys is to put "note 20 ultra case" on the search bar
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("note 20 ultra case");

        //Bottom comment is to send using textname,, same result
        // driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("note 20 ultra case");

        //this is to click search after writing "note 20 ultra case" on the search bar
        driver.findElement(By.id("twotabsearchtextbox")).click();

        //wait 2 seconds
        sleepFor(2);
        closeDriver();

    }

}
