package utilities;
/**
 * 2. Create the package utilities and create the class
 * with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in
 * it’.
 */

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    //************************* Alert Methods *****************************************************

    //1.switchToAlert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //2.acceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //3.dismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //4.sentTextToAlert
    public void sentTextToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
        // driver.findElement(by).sendTextToAlert(by,text);
    }

    //5.getTextFromAlert
    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();
        //  return driver.findElement(by).getText()
    }


    //*************************** Select Class Methods ***************************************//
    //1.selectByValueFromDropDown(By by,string value)
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        // Select by visible Text
        select.selectByValue(value);
    }

    //2. selectByIndexFromDropDown(By by ,int index)
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement index1 = driver.findElement(by);
        Select select = new Select(index1);
        select.selectByIndex(index);
    }

    //3. selectByVisibleTextFromDropDown(By by,string text)
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement visibleText = driver.findElement(by);
        Select select = new Select(visibleText);
        select.selectByVisibleText(text);
    }

    //***************************Action Methods************************
    // 1. mouseHoverToElement
    public void mouseHoverToElement(By by) {
        WebElement mouse1 = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouse1).click().build().perform();

    }

}
