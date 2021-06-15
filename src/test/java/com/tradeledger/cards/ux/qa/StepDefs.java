package com.tradeledger.cards.ux.qa;

import com.tradeledger.cards.ux.qa.cucumber.TestContext;
import com.tradeledger.cards.ux.qa.pageObjects.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;


public class StepDefs {
    TestContext testContext;
    HomePage homePage;

    @Before
    public void BeforeSteps() {
    }

    @After
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }

    public StepDefs(TestContext context) {
        testContext = context;

        homePage = testContext.getPageObjectManager().getCardsHomePage();
    }

    @Given("^user navigates to Home Page$")
    public void goToHomePage() {
        homePage.navigateToHomePage();
    }

    @When("^user enters the registration details (.*) , (.*) , (.*)$")
    public void enterRegistrationDetails(final String name, final String email, final String address) {
        homePage.enterName(name);
        homePage.enterEmail(email);
        homePage.enterAddress(address);
    }

    @And("^user submits the registration form$")
    public void submitDetails() {
        homePage.submitApplication();
    }

    @Then("^user is able to see the following message$")
    public void validateMessage(final DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        String expectedMessage = data.get(0).get(0);
        assertThat(homePage.getRegistrationSuccessMessage(), equalTo(expectedMessage));
    }

    @And("^user is able to see their eligible cards (.*)$")
    public void validateEligibleCardText(final String cardType) throws Exception {
        if (cardType.equalsIgnoreCase("C1")) {
            assertThat("Eligibility of card C1 is not displayed", homePage.assertEligibleCard(1));
        } else if (cardType.equalsIgnoreCase("C2")) {
            assertThat("Eligibility of card C2 is not displayed", homePage.assertEligibleCard(2));
        } else if (cardType.equalsIgnoreCase("C1, C2")) {
            assertThat("Eligibility of card C1 is not displayed", homePage.assertEligibleCard(1));
            assertThat("Eligibility of card C2 is not displayed", homePage.assertEligibleCard(2));
        }
    }

    @Then("^user is able to see the error message (.*)$")
    public void validateErrorMessages(final String errorMessage) {
        assertThat(homePage.getErrorMessage(), equalToIgnoringWhiteSpace(errorMessage));
    }
}
