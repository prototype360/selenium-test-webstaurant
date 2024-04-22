package test.util;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;

import selenium.steps.TestSteps;
import selenium.util.SeleniumConfig;


/**
 * Test case designed for WebRestaurantStore.
 */
public class RunTest extends SeleniumConfig
{
	private static Logger logger = LogManager.getLogger(RunTest.class);
	 
	@Before
	public void startUp() throws FileNotFoundException, IOException {
		startBrowser();
	}
	
    /**
     * Rigorous Test :-)
     * @throws Exception 
     */
    @Test
    public void testWebRestaurantStore() throws Exception
    {
    	logger.info("Test started for WebStaurantStore.");
    	
    	//search for stainless work table
    	TestSteps webRestStoreTest = new TestSteps();
    	webRestStoreTest.inputText("stainless work table", "//input[@name='searchval']");
    	webRestStoreTest.clickButton("//button[@value='Search']");
    	logger.info("Search for stainless work table.");
    	
    	
    	List<WebElement> searchList= webRestStoreTest.getElementList("//div/a/span[@data-testid='itemDescription']");
    	logger.info("Number of stainless work table items found: " + searchList.size());

    	//verify all items from search have "table" in the title
    	searchList.stream().forEach((c) -> {logger.info(c.getText()); assertTrue(StringUtils.containsAnyIgnoreCase(c.getText(), "table"));});
    	logger.info("All items returned from search contain the word table.");
    	
    	//add last item to cart
    	webRestStoreTest.clickButton("(//input[@name='addToCartButton'])[59]");
    	assertTrue(webRestStoreTest.waitForMessage("//h2[contains(.,'added to your cart')]"));
    	assertTrue(webRestStoreTest.waitForMessageToClear("//h2[contains(.,'added to your cart')]"));
    	logger.info("Last item found added to cart.");
    	
    	//remove item from cart
    	webRestStoreTest.clickButton("//a[@data-testid='cart-button']");
    	webRestStoreTest.clickButton("//button[contains(.,'Empty Cart')]");
    	webRestStoreTest.clickButton("//footer/button[contains(text(),'Empty')]");
    	//verify item removed from cart
    	assertTrue(webRestStoreTest.waitForMessage("//p[@class='header-1' and .='Your cart is empty.']"));
    	logger.info("Item removed from cart.");
    	logger.info("Test case passed.");
    }
    
    @After
    public void tearDown() throws IOException {
    	closeBrowser();
    }
    
}
