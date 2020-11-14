package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {
    public static void main(String[] args) {
        userShouldBeAbleToClickOnSignInButtonAndRegister();
    }
    private static WebDriver driver;

    public static void userShouldBeAbleToClickOnSignInButtonAndRegister(){
        //open the browser
        setupDriver();
        navigateToURL("https://www.ebay.com");
        //wait 2 seconds
        sleepFor(2);
        clickOnElement("(//a[text()='Sign in'])[1]");

        sleepFor(2);
        navigateBack();
        sleepFor(2);

        clickOnElement("//a[text()='register']");;
        sleepFor(2);

        navigateBack();
        sleepFor(2);
        closeDriver();

    }

    public static void clickOnElement(String element){
        driver.findElement(By.xpath(element)).click();
    }
    public static void navigateBack(){
        driver.navigate().back();
    }

        public static void setupDriver() {

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

       public static void navigateToURL(String url) {
           driver.get(url);
       }
        public static void sleepFor(int seconds) {
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public static void closeDriver() {
            driver.close();
        }


}