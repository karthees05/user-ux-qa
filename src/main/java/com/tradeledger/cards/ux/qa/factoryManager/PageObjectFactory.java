package com.tradeledger.cards.ux.qa.factoryManager;

import com.tradeledger.cards.ux.qa.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;


public class PageObjectFactory {

    private final WebDriver driver;
    private HomePage homePage;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getCardsHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}