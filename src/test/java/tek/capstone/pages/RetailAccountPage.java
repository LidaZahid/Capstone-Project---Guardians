package tek.capstone.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	// Constructor
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Locators of RetailAccountPage
	@FindBy(id = "accountLink")
	public WebElement accountLink;

	@FindBy(id = "nameInput")
	public WebElement nameInput;

	@FindBy(id = "personalPhoneInput")
	public WebElement phoneInput;

	@FindBy(id = "personalUpdateBtn")
	public WebElement updateBttn;

	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement updateAccountSuccessMsg;

	// Locators of Add Payment Method
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement addPaymentMethodLink;

	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;

	@FindBy(id = "nameOnCardInput")
	public WebElement cardNameField;

	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthField;

	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearField;

	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeField;

	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBttn;

	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement addPaymentMethodSuccessMsg;

	// Locators of Edit card
	@FindBy(xpath = "//div[@class='false account__payment-item' or starts-with(@data-id,'77')]")
	public WebElement existedCard;

	@FindBy(xpath = "//button[contains(@class,'text-blue') and text()='Edit']")
	public WebElement editCardBttn;

	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement editCardSuccessMsg;

	// Locators of Remove card
	@FindBy(xpath = "//button[contains(@class,'text-blue') and text()='remove']")
	public WebElement removeCardBttn;

	// Locators of Add Address
	@FindBy(xpath = "//p[text()='Add Address']")
	public WebElement addAddressBttn;

	@FindBy(id = "countryDropdown")
	public WebElement addressCountryDropdown;

	@FindBy(id = "fullNameInput")
	public WebElement addressNameField;

	@FindBy(id = "phoneNumberInput")
	public WebElement addressPhoneField;

	@FindBy(id = "streetInput")
	public WebElement addressStreetField;

	@FindBy(id = "apartmentInput")
	public WebElement addressApartmentNum;

	@FindBy(id = "cityInput")
	public WebElement addressCityField;

	@FindBy(name = "state")
	public WebElement addressStateDropdown;

	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCodeField;

	@FindBy(id = "addressBtn")
	public WebElement addressSubmitBttn;

	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressSuccessMsg;

	// Locators of Edit Address
	@FindBy(xpath = "//div[@class='account__address-btn-wrapper']//button[text()='Edit']")
	public WebElement editAddressBttn;

	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement editAddressSuccessMsg;

	// Locators of Remove Address
	@FindBy(xpath = "//div[@class='account__address-btn-wrapper']//button[text()='Remove']")
	public WebElement removeAddressBttn;

	@FindBy(xpath = "//div[contains(@class,'account__address-single')]")
	public WebElement existedAddress;

}
