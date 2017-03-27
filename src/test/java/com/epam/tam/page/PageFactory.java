package com.epam.tam.page;

import org.jbehave.web.selenium.WebDriverProvider;

public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public Home newHome() {
        return new Home(webDriverProvider);
    }
}
