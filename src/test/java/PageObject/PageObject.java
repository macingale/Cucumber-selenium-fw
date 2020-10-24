package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	
		private static final Logger Logger = LogManager.getLogger(PageObject.class);

		WebDriver Driver;
		
		//private By search_text_box = By.id("twotabsearchtextbox");
		//private By search_button = By.xpath("//input[@value='Go']");
		//private By hamburger_menu_link =  By.id("nav-hamburger-menu");
		//private By nav_link_logo =  By.xpath("//a[@class='nav-logo-link']");
		//private By nav_link_cart =  By.id("nav-cart");
		//private By nav_link_prime =  By.id("nav-link-prime");
		//private By nav_link_orders =  By.id("nav-orders");
		//private By nav_link_acount =  By.id("nav-link-accountList");
		
		private By search_text_box = By.id("twotabsearchtextbox");
		private By search_button = By.xpath("//inpunt[@value='GO']");
		private By hamburger_menu_link = By.id("nav-humburger-menu");
		private By nav_link_logo = By.xpath("//a[@class='nav-logo-link']");
		private By nav_link_cart = By.id("nav-cart");
		private By nav_link_prime = By.id("nav-link-prime1");
		private By nav_link_orders = By.id("nav-orders");
		private By nav_link_acount1 = By.id("nav-link-accountlist");
		
		
		private String hamburger_menu_category_link_xpath =  "//div[@id='hmenu-content']//div[text()='%s']";
		private String hamburger_menu_sub_category_link_xpath =  "//div[@id='hmenu-content']//a[text()='%s']";

		private By nav_link_acount;
		
		public PageObject(WebDriver Driver) {
		
		this.Driver = Driver;
}
		
		//public void SetSearchTextBox(String text) {
		//	WebDriverWait webDriverWait = new WebDriverWait(driver,20);
			//WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(search_text_box));
			//elementSearchBox.sendKeys(text);
			//logger.info("Value entered in search box: " + text);
		//}
		
		public void SetSearchTextBox1(String text) {
			WebDriverWait webDriverWait = new WebDriverWait(Driver,20);
			WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable (search_text_box));
			elementSearchBox.sendKeys(text);
			Logger.info("Value entered in the search Box: " + text);
			
		}
		public void ClickOnSearchButton() {
			Driver.findElement(search_button).click();
			Logger.info("Clicked on Search Button");
		}

		public void ClickOnHamburgerMenuButton() {
			Driver.findElement(hamburger_menu_link).click();
			Logger.info("Clicked on Hamburger Menu Button");
		}

		public void ClickOnHamburgerMenuProductCategoryLink(String linkText) {
			By byElement = By.xpath(String.format(hamburger_menu_category_link_xpath,linkText));
			Driver.findElement(byElement);
			Logger.info("Clicked on Hamburger Menu Category link: " + linkText);
		}
		
		public void ClickOnHamburgerMenuProductSubCategoryLink(String linkText) {
			By byElement = By.xpath(String.format(hamburger_menu_sub_category_link_xpath,linkText));
			Driver.findElement(byElement).click();
			Logger.info("Clicked on Hamburger Menu SubCategory link: " + linkText);
		}

		public void validateHamBurgerMenuIsDisplayed() {
			boolean b = Driver.findElement(hamburger_menu_link).isDisplayed();
			Assert.assertEquals("Hamburger menu Link",true, b);
		}

		public void validateAmazonLogo() {
			boolean b = Driver.findElement(nav_link_logo).isDisplayed();
			Assert.assertEquals("Navigation link logo",true, b);
		}
		
		public void validatePageTitleMatch(String expectedTitle) {
			WebDriverWait wait = new WebDriverWait(Driver, 30);
			Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
			Assert.assertEquals("Title Validation",true, b);
			Logger.info("Page title matched: " + expectedTitle );
		}
		

		public void validateElementPresentInHeaderSection(String text) throws Exception {
			boolean b=false;

			switch(text.toLowerCase().trim()) {

			case "hamburger menu":
				b = Driver.findElement(hamburger_menu_link).isDisplayed();
				break;
			case "amazon prime logo":
				b = Driver.findElement(nav_link_logo).isDisplayed();
				break;
			case "accounts and list link":
				b = Driver.findElement(nav_link_acount1).isDisplayed();
				break;
			case "return and orders":
				b = Driver.findElement(nav_link_orders).isDisplayed();
				break;
			case "your prime link":
				b = Driver.findElement(nav_link_prime).isDisplayed();
				break;
			case "cart link":
				b = Driver.findElement(nav_link_cart).isDisplayed();
				break;
			case "search text box":
				b = Driver.findElement(search_text_box).isDisplayed();
				break;
			default:
				Logger.fatal("Header Link Description is not present in the case. Please add link description first.");
				throw new Exception("Header Link Description is not present in the case. Please add link description first.");
			}

			if (b) {
				Logger.info("Header Link is displayed: " + text);
				Assert.assertEquals("Header Link displayed",true, b);
			}else {
				Logger.fatal("Header Link is not displayed: " + text);
				Assert.fail("Header Link is not displayed: " + text);
			}
				
}
}