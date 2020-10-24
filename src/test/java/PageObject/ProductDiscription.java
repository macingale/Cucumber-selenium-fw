package PageObject;

import static org.junit.Assert.fail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import junit.framework.Assert;


public class ProductDiscription {
	
	private static final Logger logger = LogManager.getLogger(ProductDiscription.class);
	private WebDriver driver;
	
	private By Product_title = By.id("producttitle");
	private By add_tocart_button = By.id("add_tocart_button");
	private org.junit.Assert Asseert;
	
	public ProductDiscription(WebDriver driver){
		
		this.driver = driver;
	
	}
	
	public void ValidateProductTileIsCorrectlyDisplayed() {
		
		if(driver.findElement(Product_title).isDisplayed()) {
			
			Assert.assertTrue(true);
			logger.info("Product Title is Displayed");
			
		} else
		{
			logger.fatal("Add to cart is not displayed");
			Assert.fail("Product id not displayed");
			}
		}
		
		
		public void ValidateAddToCartButtonIsCorrectlyDisplayed() {
			
			if(driver.findElement(add_tocart_button).isDisplayed()) {
				
				Asseert.assertTrue(true);
				logger.info("Add to cart bitton is displayed");
	       }
			else
			{
				logger.fatal("Add to cart button is not displayed");
				Assert.fail("Add to cart button is not displayed");
			}
		}
	}
