package com.peoplentech.seleniumpractice;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selenium4 extends TestBase{

    //Logger has more in detail informaion than system printout in the InteliJ result
    private static Logger LOGGER = Logger.getLogger(Selenium4.class);



    @Test
    public void validateDragAndDrop() {
        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/drag_drop.html");
        sleepFor(2);

        WebElement source = driver.findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));
        WebElement destination = driver.findElement(By.xpath("//ol[@id=\"amt8\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();

        sleepFor(5);
        closeDriver();
    }

    @Test(enabled = false) //this makes this test disable when running the whole class
    public void validateiFrame() {
        setupDriver("chrome");
        navigateToURL("https://demoqa.com/frames");
        sleepFor(2);

        // frame ID
        // frame Name
        // frame Index
        driver.switchTo().frame("frame1");
        // perform all actions that required in the child page
        driver.findElement(By.xpath("xpath from child page")).click();


        driver.switchTo().defaultContent();
        // perform all actions that required in the main page
        driver.findElement(By.xpath("xpath from main page")).click();

        sleepFor(5);
        closeDriver();
    }


    @Test
    public void validateDropDown() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement element = driver.findElement(By.id("gh-cat"));
        Select select = new Select(element);
        select.selectByVisibleText("Music");

        sleepFor(5);
        closeDriver();
    }


    @Test
    public void validateMouseHover() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement motors = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Cars & Trucks")).click();

        sleepFor(5);
        closeDriver();
    }

    // class work
    // perform mouse hover to sporting goods --> click on golf
    // navigate back
    // mouse hover to toys --> click on action figures
    @Test
    public void validateMouseHover2() {
        setupDriver("firefox");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement sports = driver.findElement(By.linkText("Sporting Goods"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sports).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Golf")).click();

        sleepFor(3);

        navigateBack();

        WebElement toys = driver.findElement(By.linkText("Toys"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(toys).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Action Figures")).click();
        sleepFor(2);
        closeDriver();
    }

    @Test
    public void validateScroll(){
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        sleepFor(5);
        closeDriver();
    }

    @Test
    public void validateScrollToElement(){
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement element = driver.findElement(By.linkText("Announcements"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

        sleepFor(5);
        closeDriver();

    }

    @Test
    public void validatePopup(){
        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/delete_customer.php");
        sleepFor(2);

        driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();


        String popup1 = driver.switchTo().alert().getText();
        LOGGER.info(popup1);

        driver.switchTo().alert().dismiss();

        /*sleepFor(2);
        String popup2 = driver.switchTo().alert().getText();
        System.out.println(popup2);
        driver.switchTo().alert().accept();*/

        sleepFor(5);
        closeDriver();
    }
}
