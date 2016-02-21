package com.bayamp.hulu;

import com.bayamp.utls.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by naresh on 2/21/2016.
 */
public class PrivacyTest extends BaseTest {
    @Test
    public void privacyTest() throws InterruptedException {
        Thread.sleep(3000);
        String winHandleBefore = driver.getWindowHandle();
        driver.manage().window().maximize();
        WebDriverWait log = new WebDriverWait(driver, 20);
        log.until(ExpectedConditions.presenceOfElementLocated(By.linkText("LOG IN")));
        driver.findElement(By.linkText("LOG IN")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        ((JavascriptExecutor) driver).executeScript("document.getElementById('login').value='nareshreddy1439@gmail.com'");
        ((JavascriptExecutor) driver).executeScript("document.getElementById('password').value='komma1439'");
        driver.findElement(By.xpath("//div[@id='popup-body']/div/div[3]/div[5]/a/div")).click();
        Thread.sleep(4000);
        driver.switchTo().window(winHandleBefore);
        WebDriverWait user = new WebDriverWait(driver, 20);
        user.until(ExpectedConditions.presenceOfElementLocated(By.className("name")));
        WebElement menu = driver.findElement(By.className("name"));
        //Initiate mouse action using Actions class
        Actions builder = new Actions(driver);
        // move the mouse to the earlier identified menu option
        builder.moveToElement(menu).build().perform();
        // wait for max of 5 seconds before proceeding. This allows sub menu appears properly before trying to click on it
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Favorites")));
       driver.findElement(By.linkText("Favorites")).click();
        WebElement userField = driver.findElement(By.xpath("//*[@id='subscriptions']/div[2]/table/tbody/tr[1]/td[2]"));
        Assert.assertEquals(true, userField.isDisplayed());
    }
}
