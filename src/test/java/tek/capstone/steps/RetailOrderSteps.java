package tek.capstone.guardians.steps;

import tek.capstone.guardians.utilities.CommonUtility;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

import tek.capstone.guardians.pages.POMFactory;

public class RetailOrderSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	// Add Item to cart methods
	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String category) {
		selectByVisibleText(factory.retailOrderPage().allDepartmentDropDown, category);
		logger.info("Smart Home category was selected from dropdown");

	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String item) {
		click(factory.retailOrderPage().searchInputField);
		sendText(factory.retailOrderPage().searchInputField, item);
		logger.info("Item name was entered in the search box.");

	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.retailOrderPage().searchBttn);
		logger.info("Search button was clicked.");

	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.retailOrderPage().theItem);
		logger.info("Searched item was clicked.");

	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		selectByVisibleText(factory.retailOrderPage().qttyDropdown, quantity);
		logger.info("Quantity(2) was selected from dropdown");

	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.retailOrderPage().addToCartBttn);
		logger.info("Add to cart button was clicked.");

	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String cartIconQuantity) {
		Assert.assertEquals(cartIconQuantity, factory.retailOrderPage().cartIconQtty.getText());
		logger.info("Item quantity in the cart was validated successfully.");

	}

	// Delete Items from cart
	@When("User click on cart button")
	public void userClickOnCartButton() {
		click(factory.retailOrderPage().cartBttn);
		logger.info("Cart button was clicked.");

	}

	@When("User click on delete button")
	public void userClickOnDeleteButton() {
		List<WebElement> deleteBttnsList = factory.retailOrderPage().deleteBttns;
		for (int i = 0; i < deleteBttnsList.size(); i++) {
				click(factory.retailOrderPage().deleteBttns.get(i));
		}

	}

	// Place an order methods
	@When("User changes the category to {string}")
	public void userChangesTheCategoryToElectronics(String category) {
		selectByVisibleText(factory.retailOrderPage().allDepartmentDropDown, category);
		logger.info("Electronics category was selected from dropdown");

	}

	@When("User search for the item {string}")
	public void userSearchForTheItem(String item) {
		click(factory.retailOrderPage().searchInputField);
		sendText(factory.retailOrderPage().searchInputField, item);
		logger.info("Item name was entered in the search box.");

	}

	@When("User click on the Search icon")
	public void userClickOnTheSearchIcon() {
		click(factory.retailOrderPage().searchBttn);
		logger.info("Search button was clicked.");

	}

	@When("User click on the item")
	public void userClickOnTheItem() {
		click(factory.retailOrderPage().WantedItem);
		logger.info("Searched item was clicked.");

	}

	@When("User select quantity of {string}")
	public void userSelectQuantityOf(String quantity) {
		selectByVisibleText(factory.retailOrderPage().qttyDropdown, quantity);
		logger.info("Quantity(5) was selected from dropdown");

	}

	@When("User click the add to Cart button")
	public void userClickTheAddToCartButton() {
		click(factory.retailOrderPage().addToCartBttn);
		logger.info("Add to cart button was clicked.");

	}

	@Then("Cart icon quantity should change to {string}")
	public void cartIconQuantityShouldChangeTo(String cartIconQuantity) {
		Assert.assertEquals(cartIconQuantity, factory.retailOrderPage().cartIconQtty.getText());
		logger.info("Item quantity in the cart was validated successfully.");

	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.retailOrderPage().cartBttn);
		logger.info("Cart button was clicked.");

	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.retailOrderPage().proceedBttn);
		logger.info("Proceed to checkout button was clicked.");

	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.retailOrderPage().placeOrderBttn);
		logger.info("Proceed to checkout button was clicked.");

	}

	// Cancel order methods
	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.retailOrderPage().orderLinkBttn);
		logger.info("Order link was clicked.");

	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		List<WebElement> ordersList = factory.retailOrderPage().listOfOrders;
		for (int i = 0; i < ordersList.size(); i++) {
			if (ordersList.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (ordersList.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(factory.retailOrderPage().listOfOrders.get(i));
				break;
			}
		}
		logger.info("First order in the list was clicked.");

	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		if (factory.retailOrderPage().cancelOrderBttn.isDisplayed()) {
			click(factory.retailOrderPage().cancelOrderBttn);
			logger.info("Cancel The Order button was clicked.");
//			List<WebElement> cancelBttns = pomFactory.retailOrderPage().cancelOrderBttnList;
//			click(cancelBttns.get(0));
//			logger.info("Cancel order button was clicked successfully.");
		}
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String reason) {
		selectByVisibleText(factory.retailOrderPage().reasonInputDropdown, reason);
		logger.info("A reason for cancelation was selected.");

	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.retailOrderPage().orderSubmitBttn);
		logger.info("Cancel Order button was clicked.");

	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String message) {
		if (message.contains("Cancelled")) {
			waitTillPresence(factory.retailOrderPage().cancelationSuccessMsg);
			Assert.assertEquals(message, factory.retailOrderPage().cancelationSuccessMsg.getText());
			logger.info("Order was canceled successfully.");
		} else if (message.contains("Return")) {
			waitTillPresence(factory.retailOrderPage().returnSuccessMsg);
			Assert.assertEquals(message, factory.retailOrderPage().returnSuccessMsg.getText());
			logger.info(" The return was successful.");
		}
	}

	// Return the Order methods
	@When("User click the on Orders section")
	public void userClickTheOnOrdersSection() {
		click(factory.retailOrderPage().orderLinkBttn);
		logger.info("Order link was clicked.");

	}

	@When("User click on the first order in list")
	public void userClickOnTheFirstOrderInList() throws InterruptedException {
		List<WebElement> ordersList = factory.retailOrderPage().listOfOrders;
		Thread.sleep(3000);
		for (int i = 0; i < ordersList.size(); i++) {
			if (ordersList.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (ordersList.get(i).getText().equalsIgnoreCase("Show Details")) {
				Thread.sleep(3000);
				click(factory.retailOrderPage().listOfOrders.get(i));
				break;
			}
		}
		logger.info("First order in the list was clicked.");

	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() throws InterruptedException {
		Thread.sleep(3000);
		if (factory.retailOrderPage().returnOrderBttn.isDisplayed()) {
			click(factory.retailOrderPage().returnOrderBttn);
			logger.info("Return Items button was clicked.");
		}

	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String reason) throws InterruptedException {
		Thread.sleep(3000);
		selectByVisibleText(factory.retailOrderPage().reasonInputDropdown, reason);
		logger.info("A reason for return was selected.");

	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String dropOff) {
		selectByVisibleText(factory.retailOrderPage().dropOffInputDropdown, dropOff);
		logger.info("Drop off for return was selected.");

	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() throws InterruptedException {
		Thread.sleep(3000);
		click(factory.retailOrderPage().orderSubmitBttn);
		logger.info("Return Order button was clicked.");

	}

	// Write a Review methods
	@When("User clicks on Orders section")
	public void userClicksOnOrdersSection() {
		click(factory.retailOrderPage().orderLinkBttn);
		logger.info("Order link was clicked.");

	}

	@When("User clicks on first order in list")
	public void userClicksOnFirstOrderInList() {
		List<WebElement> ordersList = factory.retailOrderPage().listOfOrders;
		for (int i = 0; i < ordersList.size(); i++) {
			if (ordersList.get(i).getText().equalsIgnoreCase("Hide Details")) {
				break;

			} else if (ordersList.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(factory.retailOrderPage().listOfOrders.get(i));
			}
		}
		logger.info("First order in the list was clicked.");

	}

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.retailOrderPage().reviewBttn);
		logger.info("Review button was clicked.");

	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headLine, String description) {
		click(factory.retailOrderPage().headLineInputField);
		sendText(factory.retailOrderPage().headLineInputField, headLine);
		click(factory.retailOrderPage().descriptionInputField);
		sendText(factory.retailOrderPage().descriptionInputField, description);
		logger.info("Headline and descriptin were entered.");

	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.retailOrderPage().reviewSubmitBttn);
		logger.info("Review submit button was clicked.");

	}

	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String message) {
		waitTillPresence(factory.retailOrderPage().reviewSuccessMsg);
		Assert.assertEquals(message, factory.retailOrderPage().reviewSuccessMsg.getText());
		logger.info("Review was posted successfully.");

	}

}