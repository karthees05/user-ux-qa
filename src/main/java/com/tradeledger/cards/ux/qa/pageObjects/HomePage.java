package com.tradeledger.cards.ux.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "address")
    private WebElement addressField;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(@data-testid,'FINISHED')]/following-sibling::div[1]/h1")
    private WebElement registrationSuccessMessage;

    @FindBy(xpath = "//*[contains(@data-testid,'FINISHED')]/following-sibling::div/*[contains(text(),'C1')]")
    private WebElement cardC1EligibilityMessage;

    @FindBy(xpath = "//*[contains(@data-testid,'FINISHED')]/following-sibling::div/*[contains(text(),'C2')]")
    private WebElement cardC2EligibilityMessage;

    @FindBy(xpath = "//*[@data-testid='ERROR']/form/h3")
    private WebElement errorMessage;

    public void navigateToHomePage() {
        driver.get(System.getProperties().getProperty("app.uri"));
    }

    public void enterName(final String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterEmail(final String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterAddress(final String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void submitApplication() {
        submitButton.click();
    }

    public String getRegistrationSuccessMessage() {
        return registrationSuccessMessage.getText();
    }

    public boolean assertEligibleCard(final int cardDisplayPosition) throws Exception {
        boolean isDisplayed = false;
        switch (cardDisplayPosition) {
            case 1:
                isDisplayed = cardC1EligibilityMessage.isDisplayed();
                break;
            case 2:
                isDisplayed = cardC2EligibilityMessage.isDisplayed();
                break;
            default:
                throw new Exception("Invalid Card");
        }
        return isDisplayed;
    }

    public String getErrorMessage() {
        return errorMessage.getText().trim();
    }


}

