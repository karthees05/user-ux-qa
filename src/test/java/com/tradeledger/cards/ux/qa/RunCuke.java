package com.tradeledger.cards.ux.qa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty",
				"html:target/cucumber-html-report.html",
				"json:target/cucumber.json",
				"rerun:target/rerun.txt"},
		features = "src/test/resources/features",
		glue= {"com.tradeledger.cards.ux.qa"},
		tags="@e2e_tests")
public class RunCuke {
}