package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;

public class SignInSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		Assert.assertTrue(factory.retailSignInPage().retailLogo.isDisplayed());
		logger.info("You are on Tek Retail website.");

	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.retailSignInPage().signInBttn);
		logger.info("Sign in button was clicked.");

	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.retailSignInPage().emailInput, email);
		sendText(factory.retailSignInPage().passwordInput, password);
		logger.info("Email and password were enetered.");

	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.retailSignInPage().loginBttn);
		logger.info("Login button was clicked.");

	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(factory.retailSignInPage().logoutBttn.isDisplayed());
		logger.info("You are signed in into Tek Retail website successfully.");

	}
	// Create New Account methods

	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.retailSignInPage().newAccountBttn);
		logger.info("Create New Account button was clicked.");

	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> signUpInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.retailSignInPage().nameInput, signUpInfo.get(0).get("name"));
		sendText(factory.retailSignInPage().mailInput, signUpInfo.get(0).get("email"));
		sendText(factory.retailSignInPage().passInput, signUpInfo.get(0).get("password"));
		sendText(factory.retailSignInPage().confirmPassInput, signUpInfo.get(0).get("confirmPassword"));
		logger.info("Signup information was entered.");

	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.retailSignInPage().signUpBttn);
		logger.info("Signup button was clicked.");

	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(factory.retailSignInPage().accountPageTitle.isDisplayed());
		logger.info("You have registered to Tek Retail website successfully.");

	}

}