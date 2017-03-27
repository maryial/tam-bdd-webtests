package com.epam.tam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
	private final static Logger LOGGER = LogManager.getLogger(BasePage.class);
	protected WebDriver driver;
	protected JavascriptExecutor jsExecutor;
	
	public BasePage(WebDriverProvider provider) {
		this.driver = provider.get();
		PageFactory.initElements(provider.get(), this);
		jsExecutor = (JavascriptExecutor) driver;
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
}
