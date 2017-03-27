package com.epam.tam.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.hash.HashCode;

public class MyWebDriverProvider implements WebDriverProvider {
	
	private final static Logger LOGGER = LogManager.getLogger(WebDriverProvider.class);	
	private final static WebDriver webDriver;
	
	private static final Map<Browsers, IDriver> DRIVERS = new HashMap<Browsers, IDriver>();

	static
    {
		DRIVERS.put(Browsers.CHROME, (() -> { 
			System.setProperty("webdriver.chrome.driver", Property.PATH_TO_CHROMEDRIVER);		
			return new ChromeDriver();
			}));
		
		DRIVERS.put(Browsers.FIREFOX, (() -> new FirefoxDriver()));
		
		if(DRIVERS.containsKey(Property.BROWSER)) {
			webDriver = DRIVERS.get(Property.BROWSER).get();
		}
		else {
			LOGGER.error("Browser is not supported");
			webDriver = null;
		}
    }

	public WebDriver get() {
		return webDriver;
	}

	public void initialize() {
		get();
	}
	
	public void end() {
		LOGGER.info("Clearing up the browser");
		webDriver.close();
		webDriver.quit();
	}
	
	interface IDriver {
		WebDriver get();
	}

	@Override
	public boolean saveScreenshotTo(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
