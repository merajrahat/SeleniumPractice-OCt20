package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySelenium2 {

    private static WebDriver driver;  //WebDriver imported, driver named so setUpDriver method
    //driver isn't red anymore

    public static void main(String[] args) {
        userSignInAndRegistration();


    }

    //     //a[text()='Sign in']
    //      //a[text()='register']
    //      //tagName[text()='______']
    //      (//a[text()='Sign in'])[1]


    public static void userSignInAndRegistration() {
        //open the browser
        setUpDriver();

        //navigate to the url
        navigateToURL("http://www.tesla.com");

        //wait two seconds
        sleepFor(2);

        //click on Order now for solar
        clickOnElement("(//a[text()='Order Now'])[1]");

        //wait 2 seconds
        sleepFor(2);

        //navigateBack
        navigateBack();

        //wait 2 seconds
        sleepFor(2);

        //click on Order now for Model S
        clickOnElement("(//a[text()='Learn More'])[1]");

        //wait 2 seconds
        sleepFor(2);

        //navigateBack
        navigateBack();

        //wait 2 seconds
        sleepFor(2);

        //close the browser
        closeDriver();
    }

    public static void navigateBack(){
        driver.navigate().back();
    }
    public static void setUpDriver() {
        //set up data as chrome driver needs
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(); //from last line in the method,
        //driver red util private construction is made on top

        //create object for chrome driver
        //last line --> WebDriver driver = new ChromeDriver(); //only open chrome (just white page)
    }

    public static void navigateToURL(String url) {
        //tell chrome driver to go to url
        // driver.get("http://ebay.com"); //google page stays open
        driver.get(url);
    }
    public static void sleepFor(int seconds) {
        //tell the chrome to say open for 2 seconds before closing
        try {
            Thread.sleep(seconds*1000); //sleep is red until making a try and catch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void clickOnElement(String element){
        driver.findElement(By.xpath(element)).click();
    }
    public static void closeDriver() {
        //close the chrome
        driver.close();  //opens but closes right away if Thread.sleep isn't added
    }
}
