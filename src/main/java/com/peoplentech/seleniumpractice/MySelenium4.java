package com.peoplentech.seleniumpractice;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class MySelenium4 extends TestBase{

    private static Logger LOGGER = Logger.getLogger(MySelenium4.class);


    @Test
    public void validateDragAndDrop(){
        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/drag_drop.html");
        sleepFor(2);

        //this is where you get the element to drag from
        WebElement source = driver.findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));

        //this is where you get the element to drag to
        WebElement destination = driver.findElement(By.xpath("//ol[@id=\"amt8\"]"));

        //line 27 and 28 is required to perform the drag and drop action
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,destination).build().perform();

        sleepFor(2);
        closeDriver();

    }

    @Test(enabled = false)  //this (enabled = false) is used to disable this @Test so it won't run when running the whole class
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


    @Test //this is another way of doing DropDown than Selenium3 class
    public void validateDropDown(){
        setupDriver("chrome");
        navigateToURL("https://ebay.com");
        sleepFor(2);

        //3 lines of code to pick a category from the "All Categories" list
        WebElement element = driver.findElement(By.id("gh-cat"));
        Select select = new Select(element);
        select.selectByVisibleText("Music");

        sleepFor(3);
        closeDriver();
    }

    @Test //this is the other DropDown from Selenium3 class, different code than the one right on top
    public static void validateProductDropDown() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        // print the data directly
        String data = driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();
        LOGGER.info(data);

        //get all the element in the list
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        LOGGER.info(dropDown.size());

        dropDown.get(22).click();

        sleepFor(3);
        closeDriver();
    }

    @Test
    public void validateMouseHover() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        //this is to hover over Motor but it won't hover until line 107 and 108
        WebElement motors = driver.findElement(By.linkText("Motors"));
        //To click on Motor you wite   driver.findElement(By.linkText("Motors")).click();

        //line 107 and 108 is to perform the hover over
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();

        //with out line 111, line 114 will fail
        sleepFor(2);

        //this is to print from the Motors options
        driver.findElement(By.linkText("Cars & Trucks")).click();

        sleepFor(3);
        closeDriver();
    }
    @Test
    public static void myMacyMouseHover1() {

        setupDriver("chrome");
        navigateToURL("https://www.macys.com");
        sleepFor(2);

        WebElement shopByDepartment = driver.findElement(By.linkText("SHOP BY DEPARTMENT"));

        Actions actions = new Actions(driver);
        actions.moveToElement(shopByDepartment).build().perform();



        sleepFor(2);
        closeDriver();

    }

    @Test
    public static void myMacyMouseHover1part2() {

        setupDriver("chrome");
        navigateToURL("https://www.macys.com");
        sleepFor(2);

        driver.manage().window().maximize();

      //driver.findElement(By.id("showByDepartmentCaret"));
       //driver.findElement(By.id("shopByDepartmentLabelText"));

       // driver.findElement(By.id("shopByDepartmentDropdownList"));

        sleepFor(2);

     // driver.findElement(By.xpath("//button[@id='showByDepartmentCaret']")).click();

      driver.findElement(By.id("shopByDepartmentLabelText")).click();

       //driver.findElement(By.xpath("//span[@id='shopByDepartmentLabelText']")).click();

        //driver.findElement(By.xpath("//div[@id=\"shopByDepartmentDropdownList\"]")).click();


        // driver.findElement(By.id("shopByDepartmentDropdownList")).click();

        sleepFor(2);
        closeDriver();
    }

    @Test
    public static void myJCPenneyMouseHover2() {

        setupDriver("chrome");
        navigateToURL("https://www.jcpenney.com/");
        sleepFor(2);
        driver.manage().window().maximize();
        sleepFor(2);


        WebElement men = driver.findElement(By.linkText("Men"));

        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();

        sleepFor(2);
        closeDriver();

    }

    @Test
    public void validateScroll() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        //line 128 and 129 is the code for scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        sleepFor(2);

        //this is to scroll back up
        js.executeScript("window.scrollBy(0,-1000)");

        sleepFor(2);

        //scroll to the bottom of a page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        sleepFor(2);

        //scroll to the top of a page
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

        sleepFor(2);
        closeDriver();
    }


    @Test
    public void validateScrollToElement() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        //this is to say which elenment to find, in this case "Announcements"
        WebElement element = driver.findElement(By.linkText("Announcements"));

        //line 145 and 146 is to scroll down to the element "Announcements"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        sleepFor(2);
        closeDriver();
    }
    @Test
    public static void mySlickDeals() {

        setupDriver("chrome");
        navigateToURL("https://www.slickdeals.net");
        sleepFor(2);

        WebElement shopByDepartment = driver.findElement(By.linkText("Deals"));

        Actions actions = new Actions(driver);
        actions.moveToElement(shopByDepartment).build().perform();



        sleepFor(2);
        closeDriver();

    }

}
