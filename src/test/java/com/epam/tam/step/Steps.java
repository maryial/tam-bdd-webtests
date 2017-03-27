package com.epam.tam.step;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.*;
import org.junit.Assert;

import com.epam.tam.common.Property;
import com.epam.tam.page.Home;
import com.epam.tam.page.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;

public class Steps {

    private Home home;

    public Steps(PageFactory pageFactory){
        home = pageFactory.newHome();
    }

    @Given("I am on the main application page")
    public void openMainApplicationPage() {
        home.go();
        Assert.assertTrue(home.getUrl().equals(Property.MAIN_APPLICATION_PAGE_URL));
    }
    
    @When("I search for <goods>")
    public void specifySearchLocation(@Named("goods") String goods) {
        home.search(goods);
        //tbd
    }
}
