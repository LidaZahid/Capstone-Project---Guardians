package tek.capstone.guardians.steps;

import tek.capstone.guardians.utilities.CommonUtility;

import java.util.List;
//import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import tek.capstone.guardians.pages.POMFactory;

public class HomeSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.retailhomePage().allBttn);
		logger.info("All section button was clicked.");

	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> sideBarDepartments = dataTable.asLists(String.class);

		for (int i = 0; i < sideBarDepartments.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath(
					"//div[@class='sidebar__content']//span[text()='" + sideBarDepartments.get(0).get(i) + "']"))));
		}
		logger.info("SideBar departments are displayed.");
	}

	// All options methods

	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> optionsList = factory.retailhomePage().sideBarOptionsList;
		for (int i = 0; i < optionsList.size(); i++) {
			if (optionsList.get(i).getText().equalsIgnoreCase(department)) {
				optionsList.get(i).click();
				break;
			}
//			else {
//				logger.info("Department was not found!");
//			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> allOptionsList = dataTable.asLists(String.class);// Categories options
																			// from dataTable of
																			// feature file
		List<WebElement> allOptions = factory.retailhomePage().sideBarAllOptionsList;// Categories options from UI

		for (int i = 0; i < allOptionsList.size(); i++) {
			for (WebElement elements : allOptions) {
				if (elements.getText().equalsIgnoreCase(allOptionsList.get(0).get(i))) {
					Assert.assertTrue(elements.isDisplayed());
					logger.info("Sub menus are diplayed.");

				}

			}

		}

	}

}
