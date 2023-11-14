package tek.capstone.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {

	// Constructor
	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Locators of RetailSignInPage
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement retailLogo;

	@FindBy(id = "signinLink")
	public WebElement signInBttn;

	@FindBy(id = "email")
	public WebElement emailInput;

	@FindBy(id = "password")
	public WebElement passwordInput;

	@FindBy(id = "loginBtn")
	public WebElement loginBttn;

	@FindBy(id = "logoutBtn")
	public WebElement logoutBttn;

	// Locators of Create Account (Register)
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountBttn;

	@FindBy(id = "nameInput")
	public WebElement nameInput;

	@FindBy(id = "emailInput")
	public WebElement mailInput;

	@FindBy(id = "passwordInput")
	public WebElement passInput;

	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPassInput;

	@FindBy(id = "signupBtn")
	public WebElement signUpBttn;

	@FindBy(xpath = "//h1[text()='Your Profile']")
	public WebElement accountPageTitle;

}