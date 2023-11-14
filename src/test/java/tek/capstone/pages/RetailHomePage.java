package tek.capstone.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailHomePage extends BaseSetup {

	// Constructor
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Locators of SideBar categories
	@FindBy(id = "hamburgerBtn")
	public WebElement allBttn;

	@FindBy(xpath = "//div[@class='sidebar__content']//div")
	public List<WebElement> sideBarOptionsList;

	// Locators of SideBar All options
	@FindBy(xpath = "//div[@class='sidebar_content-item']//span")
	public List<WebElement> sideBarAllOptionsList;
}
