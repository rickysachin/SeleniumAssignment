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

public class ShoppingCartStepDef extends BaseStepDef{
    private WebDriver driver;
    private String reference = "";
    private String username=null;

    public ShoppingCartStepDef()

    {
        this.driver=new Hooks().returndriver();

    }

    @When("i login to application using valid credentials")
    public void iAmAbleToLogin() {

        Boolean result=false;
        HomePage homePage = new HomePage(driver);
        Log.info("starting to login");
        if(!homePage.clickLogin())
        {
            Assert.fail("could not click Login ");
        }
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
        if(!ordercon.backToSummary())
        {
            Assert.fail("could not click back to summary");
        }
        Boolean sucess = ordercon.verifyOrder(reference);
        Assert.assertEquals(sucess, true);
        Log.info("The extracted order summary is "+reference);

    }

    @And("i change My first name to new name \"([^\"]*)\"")
    public void iChangeMyFirstName(String fname) {
        Boolean result=false;
        Authentication authen = new Authentication(driver);
        if(!authen.clickMyaccount())
        {
            Assert.fail("Not able to click My account Page");
        }
        MyAccount acct=new MyAccount(driver);
        if(!acct.clickMyPersonalInfo())
        {
            Assert.fail("Not able to click My Paersonal Info");
        }
        String user = fname.trim();

        if(!acct.setEditFirstName(user,BaseStepDef.PWD))
        {
            Assert.fail("Not able to set the first name as"+user);
        }
        username = user;
        result=acct.clickButtonSave();
        if(!result) {
            Assert.fail("Not able to update first name");
        }

    }



    @Given("i am on the page where a product can be added to cart for a signed user")
    public void iAmOnThePageWhereAProductCanBeSearchedAndAddedToCart() {
        Boolean result=false;
        String url =BaseStepDef.URL ;
        HomePage homePage = new HomePage(driver);
        homePage.openURL(url);
        Log.info("Opening the browser");

        result=homePage.IsSearchBoxPresent();
        if(!result)
        {
            Assert.fail("Not able to navigate to page where i can search a product");
        }

        Log.info("starting to login");
        if(!homePage.clickLogin())
        {
            Assert.fail("could not click Login ");
        }
        Authentication authen = new Authentication(driver);
        String user = BaseStepDef.USER;
        String pwd = BaseStepDef.PWD;
        result = authen.login(user, pwd);
        if(!result) {
            Assert.fail("Failure in Login");
            Log.error("Not able to login through application");
        }

    }

    @Given("i am on the page where a user can update info")
    public void iAmOnThePageWhereAUserCanLoginAndUpdateInfo() {
        Boolean result=false;
        String url =BaseStepDef.URL ;
        HomePage homePage = new HomePage(driver);
        homePage.openURL(url);
        Log.info("Opening the browser");

        if(!homePage.IsSearchBoxPresent())
        {
            Assert.fail("Not able to verify a search box");
        }
        Log.info("starting to login");
        homePage.clickLogin();
        Authentication authen = new Authentication(driver);
        String user = BaseStepDef.USER;
        String pwd = BaseStepDef.PWD;
        result = authen.login(user, pwd);
        if(!result)
        {
            Assert.fail("Failure in Login");
        }

    }

    @When("i add \"([^\"]*)\" in the cart")
    public void iAddInTheCart(String Product)
    {
        Boolean result=false;
        HomePage homePage = new HomePage(driver);
        CartSummary summary = new CartSummary(driver);
        if(!homePage.enterText(Product))
            Assert.fail("Could not enter in serach box "+Product);

        if(!homePage.clickSearch())
            Assert.fail("Could not click search button");

        if(!homePage.clickInStock())
           Assert.fail("Could not click product link image");

        if(!summary.addtocart())
            Assert.fail("could not click add to cart button");
        result=summary.proceedToCheckout();
        if(!result)
        {
           Assert.fail("Could not click proceed to checkout");
        }

    }

    @Then("i can view checkout page")
    public void iCanSeeCheckoutPage() {
        CartSummary summary = new CartSummary(driver);
        if(!summary.isPresentProceedCheckout())
        {
           Assert.fail("proceed to checkout page is present");
        }
    }

    @Then("i can view the userid on home page")
    public void iCanSeeTheUseridOnHomePage() {
        Authentication authen = new Authentication(driver);
        if(!authen.IsCustomerLogin())
        {
           Assert.fail("Customer is not able to Login");
        }
    }

    @When("i order a \"([^\"]*)\"")
    public void iOrderA(String product) throws IOException {
        Boolean result=false;
        CartSummary summary = new CartSummary(driver);
        if(!summary.confirmCheckout())
        {
          Assert.fail("Could not click confirm checkout on summary page");
        }
        Address address = new Address(driver);
        if(!address.Proceed())
        {
           Assert.fail("Could not click proceed on addrress page");
        }
        Shipping ship = new Shipping(driver);
        if(!ship.checkTerms())
        {
            Assert.fail("Could not click terms and conditions on shipping page");
        }

        if(!ship.clickProceed())
        {
            Assert.fail("Could not click proceed on shipping page");
        }
        Payment payment = new Payment(driver);
        if(!payment.clickBankwirePaymentMethod())
        {
            Assert.fail("Could not bankwire Payment method");
        }
        result=payment.confirmOrder();
        if(!result)
        {

            captureScreenshot(driver,BaseStepDef.snapshotFile,"ConfirmOrderError");
            Assert.fail("Could notconfirm order for"+product);
        }
    }

    @Then("i am able to check the updatedDetails")
    public void iAmAbleToCheckTheUpdatedDetails() {

        Authentication authen = new Authentication(driver);
        Boolean success = authen.getUser(username);
        Assert.assertEquals(success, true);
    }
}
