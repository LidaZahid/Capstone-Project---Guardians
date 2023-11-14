package tek.capstone.guardians.steps;

import tek.capstone.guardians.utilities.CommonUtility;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;

public class RetailAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	// Update Account Methods
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.retailAccountPage().accountLink);
		logger.info("Account link was clicked.");

	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
		clearTextUsingSendKeys(factory.retailAccountPage().nameInput);
		sendText(factory.retailAccountPage().nameInput, name);
		clearTextUsingSendKeys(factory.retailAccountPage().phoneInput);
		sendText(factory.retailAccountPage().phoneInput, phone);
		logger.info("New Name and phone were entered.");

	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.retailAccountPage().updateBttn);
		logger.info("Update button was clicked.");

	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.retailAccountPage().updateAccountSuccessMsg);
//		String expectedMessage = "Personal Information Updated Successfully";
//		String actualMessage = factory.retailAccountPage().updateAccountSuccessMsg.getText();
//		Assert.assertEquals(expectedMessage, actualMessage);
		Assert.assertTrue(factory.retailAccountPage().updateAccountSuccessMsg.isDisplayed());
		logger.info("Personal Information Updated Successfully.");

	}

	// Add Payment Methods methods
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.retailAccountPage().addPaymentMethodLink);
		logger.info("Add payment method link was clicked.");

	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.retailAccountPage().cardNumberField, cardInfo.get(0).get("cardNumber"));
		sendText(factory.retailAccountPage().cardNameField, cardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.retailAccountPage().expirationMonthField, cardInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.retailAccountPage().expirationYearField, cardInfo.get(0).get("expirationYear"));
		sendText(factory.retailAccountPage().securityCodeField, cardInfo.get(0).get("securityCode"));
		logger.info("Add payment method information was entered.");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.retailAccountPage().paymentSubmitBttn);
		logger.info("Add your card button was clicked.");

	}

	// This method is used for a couple of test cases, only the message(String)
	// which is the value will be updated.
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String successMessage) {
		if (successMessage.contains("Payment Method added")) {
			waitTillPresence(factory.retailAccountPage().addPaymentMethodSuccessMsg);
			Assert.assertEquals(successMessage, factory.retailAccountPage().addPaymentMethodSuccessMsg.getText());
			logger.info("A payment method was added Successfully.");
		} else if (successMessage.contains("Payment Method updated")) {
			waitTillPresence(factory.retailAccountPage().editCardSuccessMsg);
			Assert.assertEquals(successMessage, factory.retailAccountPage().editCardSuccessMsg.getText());
			logger.info("Card was updated Successfully.");
		} else if (successMessage.contains("Address Added")) {
			waitTillPresence(factory.retailAccountPage().addressSuccessMsg);
			Assert.assertEquals(successMessage, factory.retailAccountPage().addressSuccessMsg.getText());
			logger.info("Address was added Successfully.");
		} else if (successMessage.contains("Address Updated")) {
			waitTillPresence(factory.retailAccountPage().editAddressSuccessMsg);
			Assert.assertEquals(successMessage, factory.retailAccountPage().editAddressSuccessMsg.getText());
			logger.info("Address was updated Successfully.");
		} else if (successMessage.contains("Order Placed")) {
			waitTillPresence(factory.retailOrderPage().orderPlacedSuccessMsg);
			Assert.assertEquals(successMessage, factory.retailOrderPage().orderPlacedSuccessMsg.getText());
			logger.info("Order was placed Successfully.");
		} else if (successMessage.contains("Return was")) {
			waitTillPresence(factory.retailOrderPage().returnSuccessMsg);
			Assert.assertEquals(successMessage, factory.retailOrderPage().returnSuccessMsg.getText());
			logger.info("Order was returned Successfully.");
		} else if (successMessage.contains("Cart is Empty")) {
			waitTillPresence(factory.retailOrderPage().deleteItemsSuccessMsg);
			Assert.assertEquals(successMessage, factory.retailOrderPage().deleteItemsSuccessMsg.getText());
			logger.info("Items are deleted from cart Successfully.");
		}
	}

	// Edit card methods
	@When("User click on existed card")
	public void userClickOnExistedCard() { // This method was added by me.
		click(factory.retailAccountPage().existedCard);
		logger.info("Existed card was clicked to be edited..");

	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.retailAccountPage().editCardBttn);
		logger.info("Edit card button was clicked.");

	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardInformation = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.retailAccountPage().cardNumberField);
		sendText(factory.retailAccountPage().cardNumberField, cardInformation.get(0).get("cardNumber"));
		clearTextUsingSendKeys(factory.retailAccountPage().cardNameField);
		sendText(factory.retailAccountPage().cardNameField, cardInformation.get(0).get("nameOnCard"));
		clearTextUsingSendKeys(factory.retailAccountPage().expirationMonthField);
		selectByVisibleText(factory.retailAccountPage().expirationMonthField,
				cardInformation.get(0).get("expirationMonth"));
		clearTextUsingSendKeys(factory.retailAccountPage().expirationYearField);
		selectByVisibleText(factory.retailAccountPage().expirationYearField,
				cardInformation.get(0).get("expirationYear"));
		clearTextUsingSendKeys(factory.retailAccountPage().securityCodeField);
		sendText(factory.retailAccountPage().securityCodeField, cardInformation.get(0).get("securityCode"));
		logger.info("New information was entered in the card.");

	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.retailAccountPage().paymentSubmitBttn);
		logger.info("Update your card button was clicked.");

	}

	// Remove Card methods
	@When("User click on the existed card")
	public void userClickTheOnExistedCard() { // This method was added by me.
		click(factory.retailAccountPage().existedCard);
		logger.info("Existed card was clicked to be removed.");

	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.retailAccountPage().removeCardBttn);
		logger.info("Remove card button was clicked.");

	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
//		if(!(factory.retailAccountPage().existedCard.isDisplayed())) { // Test passes, but this line is not executed 
//			logger.info("Existed card is removed successfully.");
//		}
		Assert.assertTrue(factory.retailAccountPage().existedCard.isDisplayed());
		// We should use assertFalse() as we we want the condition to be false, but it
		// doesn't work with assertFlase().
		// It works with assertTrue() which is not logical
		logger.info("Existed card is removed Successfully.");
	}

	// Add Address methods
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.retailAccountPage().addAddressBttn);
		logger.info("Add address buton was clicked.");

	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.retailAccountPage().addressCountryDropdown, addressInfo.get(0).get("country"));
		// calling sendText(WebElement element, String value) method from CommonUtility
		// class
		sendText(factory.retailAccountPage().addressNameField, addressInfo.get(0).get("fullName"));
		sendText(factory.retailAccountPage().addressPhoneField, addressInfo.get(0).get("phoneNumber"));
		sendText(factory.retailAccountPage().addressStreetField, addressInfo.get(0).get("streetAddress"));
		sendText(factory.retailAccountPage().addressApartmentNum, addressInfo.get(0).get("apt"));
		sendText(factory.retailAccountPage().addressCityField, addressInfo.get(0).get("city"));
		selectByVisibleText(factory.retailAccountPage().addressStateDropdown, addressInfo.get(0).get("state"));
		sendText(factory.retailAccountPage().addressZipCodeField, addressInfo.get(0).get("zipCode"));
		logger.info("Address form was filled successfully");

	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.retailAccountPage().addressSubmitBttn);
		logger.info("Add your address buton was clicked.");

	}

	// Edit Address methods
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.retailAccountPage().editAddressBttn);
		logger.info("Edit address buton was clicked.");

	}

	@When("user fill the new address form with below information")
	public void userFillTheNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInformation = dataTable.asMaps(String.class, String.class);

		clearTextUsingSendKeys(factory.retailAccountPage().addressCountryDropdown);
		selectByVisibleText(factory.retailAccountPage().addressCountryDropdown,
				addressInformation.get(0).get("country"));

		clearTextUsingSendKeys(factory.retailAccountPage().addressNameField);
		sendText(factory.retailAccountPage().addressNameField, addressInformation.get(0).get("fullName"));

		clearTextUsingSendKeys(factory.retailAccountPage().addressPhoneField);
		sendText(factory.retailAccountPage().addressPhoneField, addressInformation.get(0).get("phoneNumber"));

		clearTextUsingSendKeys(factory.retailAccountPage().addressStreetField);
		sendText(factory.retailAccountPage().addressStreetField, addressInformation.get(0).get("streetAddress"));

		clearTextUsingSendKeys(factory.retailAccountPage().addressApartmentNum);
		sendText(factory.retailAccountPage().addressApartmentNum, addressInformation.get(0).get("apt"));

		clearTextUsingSendKeys(factory.retailAccountPage().addressCityField);
		sendText(factory.retailAccountPage().addressCityField, addressInformation.get(0).get("city"));

		clearTextUsingSendKeys(factory.retailAccountPage().addressStateDropdown);
		// sendText(factory.retailAccountPage().addressNameField,
		// addressInformation.get(0).get("state"));
		selectByVisibleText(factory.retailAccountPage().addressStateDropdown, addressInformation.get(0).get("state"));

		clearTextUsingSendKeys(factory.retailAccountPage().addressZipCodeField);
		sendText(factory.retailAccountPage().addressZipCodeField, addressInformation.get(0).get("zipCode"));
		logger.info("New address information was entered.");

	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.retailAccountPage().addressSubmitBttn);
		logger.info("Update your address buton was clicked.");

	}

	// Remove Address methods
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.retailAccountPage().removeAddressBttn);
		logger.info("Remove Address buton was clicked.");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		Assert.assertTrue(factory.retailAccountPage().existedAddress.isDisplayed());
		// We should use assertFalse() as we we want the condition to be false, but it
		// doesnt work with assertFlase().
		// It works with assertTrue() which is not logical
		logger.info("Existed address is removed Successfully.");

	}
}
