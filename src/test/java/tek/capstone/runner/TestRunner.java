package tek.capstone.guardians.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@AllScenarios", 
		features = ("classpath:features"), 
		glue = "tek.capstone.guardians", 
		dryRun = false, 
		plugin = {
		"pretty", "html:target/htmlReports/cucumber-pretty.html",
		"json:target/jsonReports/cucumber.json" }, 
		snippets = CAMELCASE, 
		monochrome = true)

public class TestRunner {

}
