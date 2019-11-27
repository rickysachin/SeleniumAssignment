package com.bdd.StepDefs.OrderStepDef;

import com.bdd.StepDefs.BaseStepDef;
import com.bdd.Webpages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.bdd.Util.Log;

import java.io.IOException;
import java.util.List;


public class ShoppingCartStepDef {
    private WebDriver driver;
    private String reference = "";
    private String username=null;

    public ShoppingCartStepDef()

    {
        this.driver=new Hooks().returndriver();

    }


    @Given("The website to order is available")
    public void theWebsiteToOrderIsAvailable(List<List<String>> paramsList) throws Exception {

        String url =BaseStepDef.URL ;
        driver.get(url);
        Log.info("Opening the browser");
        BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"BrowserHomePage");
        Assert.assertEquals(paramsList.get(1).get(0), driver.getTitle());
        Log.info("Able to open website");
    }

    @When("i enter \"([^\"]*)\" in Search Box")
    public void iClickOnTshirtLink(String Product) throws IOException {
        Boolean result=false;
        HomePage homePage = new HomePage(driver);
        result= homePage.enterText(Product);

        if(!result)
        {
            Log.error("Could not enter text in search Button");
            BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"HomePage_SearchBox_Error");
            Assert.fail("Could not enter text in search button");
        }
    }
    @When("i check Tshirt is inStock")
    public void iCheckTshirtIsInStock() throws IOException {
        Boolean result=false;
        HomePage homePage = new HomePage(driver);
        homePage.clickSearch();
        result=homePage.clickInStock();
        if(!result)
        {
            Log.error("Could not click product selected");
            BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"HomePage_click_Error");
            Assert.fail("Could not click product selected");
        }
        Log.info("Able to verify product selected is in stock");

    }

    @And("i click Add to cart button")
    public void iClickAddToCartButton() throws IOException {
        Boolean result=false;
        CartSummary summary = new CartSummary(driver);
        summary.addtocart();
        result=summary.proceedToChecout();
        if(!result)
        {
            Log.error("Could not click proceed to checkout");
            BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"CartSummary_ProceedToCheckout_Error");
            Assert.fail("Could not click proceed to checkout");
        }

    }


    @Then("i get shopping cart summary and tshirt ordered")
    public void iGetShoppingCartSummaryAndTshirtAddedInCart() throws IOException {
        Boolean result=false;
        CartSummary summary = new CartSummary(driver);
        summary.confirmCheckout();
        Address address = new Address(driver);
        address.Proceed();
        Shipping ship = new Shipping(driver);
        ship.checkTerms();
        ship.clickProceed();
        Payment payment = new Payment(driver);
        payment.clickPaymentMethod();
        result=payment.confirmOrder();
        if(!result)
        {
            Log.error("Could not confirm order");
            BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"ConfirmOrderError");
            Assert.fail("Could notconfirm order");
        }
    }

    @When("i am able to login using valid credentials")
    public void iAmAbleToLogin() {

        Boolean result=false;
        HomePage homePage = new HomePage(driver);
        Log.info("starting to login");
        homePage.clickLogin();
        Authentication authen = new Authentication(driver);
        String user = BaseStepDef.USER;
        String pwd = BaseStepDef.PWD;
        result = authen.login(user, pwd);
        if(!result) {
            Assert.fail("Failure in Login");
            Log.error("Not able to login through application");
        }
    }
    @And("i verify order details on order confirmation page")
    public void iVerifyOrderDetailsOnOrderConfirmationPage() throws IOException {

        Boolean result=false;
        OrderConfirmation ordercon = new OrderConfirmation(driver);
        reference = ordercon.extractOrderReference();
        ordercon.backToSummary();
        Boolean sucess = ordercon.verifyOrder(reference);
        Assert.assertEquals(sucess, true);
        Log.info("The extracted order summary is "+reference);
        BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"orderhistory_Sucess");
    }

    @And("i click on MyAccountPage Link")
    public void iClickOnMyAccountPageLink() {

        Boolean result=false;
        Authentication authen = new Authentication(driver);
        result=authen.clickMyaccount();
        if(!result) {
            Assert.fail("Failure in clicking my account");
            Log.error("Not able to click MyAccount");
        }
    }

    @When("i click on My personalinfo Page")
    public void iClickOnMyPersonalinfoPage() throws IOException {
        Boolean result=false;
        MyAccount acct=new MyAccount(driver);
        result=acct.clickMyPersonalInfo();
        if(!result) {
            BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"MyAccount_PersonalInfo_failed");
            Log.error("Not able to click My personal info");
            Assert.fail("Failure in My Personal Info");

        }
    }

    @And("i change My first name")
    public void iChangeMyFirstName(List<List<String>> paramsList) {
        Boolean result=false;
        String user = paramsList.get(1).get(0).trim();
        MyAccount acct = new MyAccount(driver);
        acct.setEditFirstName(user);
        username = user;
        result=acct.clickButtonSave();
        if(!result) {
            Assert.fail("Not able to save first name");
            Log.error("Not able to save first name");
        }

    }

    @Then("i am able to saveInfo")
    public void iAmAbleToSaveInfo() throws IOException {

        Authentication authen = new Authentication(driver);
        Boolean success = authen.getUser(username);
        Assert.assertEquals(success, true);
        BaseStepDef.captureScreenshot(driver,BaseStepDef.snapshotFile,"AuthenticationPage_SaveInfo_Sucess");

    }

}
