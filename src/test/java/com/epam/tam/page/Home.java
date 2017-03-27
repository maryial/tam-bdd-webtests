package com.epam.tam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.tam.common.Property;

public class Home extends BasePage {

	private final static Logger LOGGER = LogManager.getLogger(Home.class);
	private String MAIN_APPLICATION_PAGE_URL = Property.MAIN_APPLICATION_PAGE_URL;
	
	@FindBy(id = "gh-ac")
	private WebElement search;
	
    public Home(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }
    
    public void go() {
    	LOGGER.info("Navigating to {}", MAIN_APPLICATION_PAGE_URL);
    	driver.get(MAIN_APPLICATION_PAGE_URL);    	
    }
    
    public String getUrl() {
    	return driver.getCurrentUrl();
    }
    
    public void search(String text) {
    	search.sendKeys(text);
    	search.submit();
    } 
}
