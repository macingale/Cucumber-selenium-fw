package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageObject {
	
	 private static final Logger logger = LogManager.getLogger(HomePageObject.class);

	    //Section1:  Declare a driver object
	    private WebDriver driver;

	    //Section 2 : Define the locators
	    private By link_sign_in_securly = By.linkText("Sign in securely");

	    //Section 3: Paratmerize the constuctor
	    public HomePageObject(WebDriver driver){
	        this.driver = driver;
	    }

	    //Section 4 : Write Business Methods (methods to be exposed) agent
	    public void clickLinkSignInSecurely(){
	        driver.findElement(link_sign_in_securly).click();
	        logger.info("Click link: link_sign_in_securly");
	    }

}
