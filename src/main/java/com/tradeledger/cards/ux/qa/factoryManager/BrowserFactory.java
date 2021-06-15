package com.tradeledger.cards.ux.qa.factoryManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class BrowserFactory {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null)
            driver = startDriver();
        return driver;
    }

    private WebDriver startDriver() {
        String driverType = System.getProperties().getProperty("browser.type");
        if (driverType.toLowerCase(Locale.ROOT).equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        } else if (driverType.toLowerCase(Locale.ROOT).equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }

}