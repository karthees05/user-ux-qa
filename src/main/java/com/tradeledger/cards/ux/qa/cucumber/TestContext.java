package com.tradeledger.cards.ux.qa.cucumber;

import com.tradeledger.cards.ux.qa.factoryManager.PageObjectFactory;
import com.tradeledger.cards.ux.qa.factoryManager.BrowserFactory;

public class TestContext {
    private final BrowserFactory browserFactory;
    private final PageObjectFactory pageObjectFactory;

    public TestContext() {
        browserFactory = new BrowserFactory();
        pageObjectFactory = new PageObjectFactory(browserFactory.getDriver());
    }

    public BrowserFactory getWebDriverManager() {
        return browserFactory;
    }

    public PageObjectFactory getPageObjectManager() {
        return pageObjectFactory;
    }

}