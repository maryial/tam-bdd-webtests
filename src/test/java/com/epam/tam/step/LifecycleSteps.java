package com.epam.tam.step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.After;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriverException;

import com.epam.tam.common.Property;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LifecycleSteps {

	private final static Logger LOGGER = LogManager.getLogger(LifecycleSteps.class);
    private final WebDriverProvider webDriverProvider;

    public LifecycleSteps(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    @BeforeStories
    public void runBeforeAllStories() {
        try {
            LOGGER.info("Story execution is started");
            webDriverProvider.get().manage().window().maximize();
            webDriverProvider.get().manage().timeouts().pageLoadTimeout(Property.TIMEOUT, TimeUnit.SECONDS);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    @AfterStories
    public void runAfterAllStories() {
    	LOGGER.info("Story execution is finished");
    }
}
