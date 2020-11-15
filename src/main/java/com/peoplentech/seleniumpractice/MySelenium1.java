package com.peoplentech.seleniumpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySelenium1 {

    public static void main(String[] args) throws InterruptedException {

        //set up data as chrome driver needs
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //create object for chrome driver
        WebDriver driver = new ChromeDriver(); //only open chrome (just white page)

        //tell chrome driver to go to url
        driver.get("http://tesla.com"); //google page stays open

        //tell the chrome to say open for 2 seconds before closing
        Thread.sleep(2000);

        //close the chrome
        driver.close();  //opens but closes right away if Thread.sleep isn't added


    }
}
