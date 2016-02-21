package com.bayamp.utls;

/**
 * Created by naresh on 2/20/2016.
 */

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
    protected String url;
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"webmail.url"})
    public void init(@Optional String url) {
        if (!StringUtils.isEmpty(url))
            this.url = url;
        else {
            this.url = PropertiesUtil.getProperty("webmail.url");
        }
        String driverType = PropertiesUtil.getProperty("selenium.browser.type");
        if ("firefox".equalsIgnoreCase(driverType)) {
            driver = new FirefoxDriver();
        } else if ("chrome".equalsIgnoreCase(driverType))
            driver = new ChromeDriver();
        driver.get(this.url);
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}


