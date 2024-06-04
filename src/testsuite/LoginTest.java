package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 4. Write down the following test into ‘LoginTest’
 * class
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */
public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        multiBrowser(browser);
    }

    /**
     * 1. userSholdLoginSuccessfullyWithValidCredentials
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “PRODUCTS”
     */
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the text “PRODUCTS”
        Assert.assertEquals("user is not login successfully", "Products", getTextFromElement(By.xpath("//span[@class='title']")));
    }

    /**
     * 2. verifyThatSixProductsAreDisplayedOnPage
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify that six products are displayed on
     * page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        System.out.println("Total Number of products are on page: " + productList.size());
        Assert.assertEquals("Number of product did not match!", 6, productList.size());
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
