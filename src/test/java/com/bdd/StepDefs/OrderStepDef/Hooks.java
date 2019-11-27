package com.bdd.StepDefs.OrderStepDef;
import com.bdd.StepDefs.BaseStepDef;
import com.bdd.Util.Log;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.bdd.SeleniumLibraries;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Hooks {
    private static  WebDriver driver;
    BaseStepDef baseStepDef = new BaseStepDef();
    SeleniumLibraries library=new SeleniumLibraries();
    @Before(order = 0)
    public void setup(Scenario scenario) throws Exception {
        baseStepDef.init();
        Log.info("Current scenario executing :"+scenario.getName());
        if (BaseStepDef.BROWSER.equalsIgnoreCase("chrome")) {
            driver = library.setupChrome();
        } else if (BaseStepDef.BROWSER.equalsIgnoreCase("firefox"))
        {
            driver = library.setupFireFox();
        }
    }

    public WebDriver returndriver() {
        return driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }


}
