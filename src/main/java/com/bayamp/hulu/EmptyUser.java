package com.bayamp.hulu;

import com.bayamp.utls.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by naresh on 2/20/2016.
 */
public class EmptyUser extends BaseTest {
    @Test
    public void emptyUser() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebDriverWait log = new WebDriverWait(driver, 20);
        log.until(ExpectedConditions.presenceOfElementLocated(By.linkText("LOG IN")));
        driver.findElement(By.linkText("LOG IN")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        ((JavascriptExecutor) driver).executeScript("document.getElementById('login').value=''");
        ((JavascriptExecutor) driver).executeScript("document.getElementById('password').value='komma1439'");
        driver.findElement(By.xpath("//div[@id='popup-body']/div/div[3]/div[5]/a/div")).click();
        Thread.sleep(4000);
        WebElement userField = driver.findElement(By.className("login-status"));
        Assert.assertEquals(true, userField.isDisplayed());
    }
}
