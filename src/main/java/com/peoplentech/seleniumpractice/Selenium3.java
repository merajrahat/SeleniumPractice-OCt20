package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium3 extends TestBase{





    @Test
    public static void validateUserCanTypeOnSearchBar() {
        setupDriver();
        navigateToURL("https://www.ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        // driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");

        sleepFor(2);
        closeDriver();
    }


    @Test
    public static void validateUserCanTypeOnSearchBarAndClickSearchButton() {
        setupDriver();
        navigateToURL("https://www.ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        // driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");

        //to click search button
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        sleepFor(2);
        closeDriver();
    }
    @Test
    public static void validateProductDropDown() {
        setupDriver();
        navigateToURL("https://www.ebay.com");

      String data = driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();
        //print the data
        System.out.println(data);

        //get all the element in the list
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(dropDown.size());

        dropDown.get(5).click();

        sleepFor(5);
        closeDriver();
    }

    public static void validateUserCanTypeOnSearchBarAndChooseFromDropDown() {

        //try later: search Java Books, option Books and click search

        // also try expect Java Books and actual Java Books

        setupDriver();
        navigateToURL("https://www.ebay.com");

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");

        //get all the element in the list
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(dropDown.size());
        dropDown.get(4).click();

        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();


        sleepFor(5);
        closeDriver();
    }

    @Test
    public static void seleniumMethods(){

        setupDriver();
        navigateToURL("https://www.ebay.com");

        WebElement clickElements = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        clickElements.click();

        driver.findElement(By.xpath("h2[text()='eBay Motors']")).click();

        sleepFor(5);
        closeDriver();



    }

}
