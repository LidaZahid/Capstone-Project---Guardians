package tek.capstone.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {

	// Constructor
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Locators of Add Items to the cart
	@FindBy(id = "search")
	public WebElement allDepartmentDropDown;

	@FindBy(id = "searchInput")
	public WebElement searchInputField;

	@FindBy(id = "searchBtn")
	public WebElement searchBttn;

	@FindBy(xpath = "//p[text()='Kasa Outdoor Smart Plug']")
	public WebElement theItem;

	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement qttyDropdown;

	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBttn;

	@FindBy(id = "cartQuantity")
	public WebElement cartIconQtty;
	
	// Locators of delete items from cart
	@FindBy(xpath = "//span[text()='Delete']")
	public List<WebElement> deleteBttns; 
	
	@FindBy(xpath = "//h1[text()='Your Shopping Cart is Empty']")
	public WebElement deleteItemsSuccessMsg;

	// Locators of Place an Order
	@FindBy(xpath = "//img[starts-with(@alt, 'Apex Legends')]")
	public WebElement WantedItem;

	@FindBy(id = "cartBtn")
	public WebElement cartBttn;

	@FindBy(id = "proceedBtn")
	public WebElement proceedBttn;

	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;

	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlacedSuccessMsg;

	// Locators of Cancel Order
	@FindBy(id = "orderLink")
	public WebElement orderLinkBttn;

	@FindBy(xpath = "//div[@class = 'order']//descendant::p[7]")
	public List<WebElement> listOfOrders;

//	@FindBy(id = "cancelBtn")
//	public List<WebElement> cancelOrderBttnList;
	@FindBy(id = "cancelBtn")
	public WebElement cancelOrderBttn;

	@FindBy(id = "reasonInput")
	public WebElement reasonInputDropdown;

	@FindBy(id = "orderSubmitBtn")
	public WebElement orderSubmitBttn;

	@FindBy(xpath = "//p[text() = 'Your Order Has Been Cancelled']")
	public WebElement cancelationSuccessMsg;

	// Locators of Return the Order
	@FindBy(id = "returnBtn")
	public WebElement returnOrderBttn;

	@FindBy(id = "dropOffInput")
	public WebElement dropOffInputDropdown;

//	@FindBy(xpath = "//div[@class='return__confirm-message']")
	@FindBy(xpath = "//p[text() = 'Return was successfull']")
	public WebElement returnSuccessMsg;

	// Locators of Write a Review
	@FindBy(id = "reviewBtn")
	public WebElement reviewBttn;

	@FindBy(id = "headlineInput")
	public WebElement headLineInputField;

	@FindBy(id = "descriptionInput")
	public WebElement descriptionInputField;

	@FindBy(id = "reviewSubmitBtn")
	public WebElement reviewSubmitBttn;

	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement reviewSuccessMsg;

}
