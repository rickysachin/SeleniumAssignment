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
        Log.info("Able to click back to summary on order confirmation page");
        result = ordercon.verifyOrder(reference);
        Assert.assertEquals(result, true);
        Log.info("Able to succesfully order and The extracted order summary is "+reference);

    }

    @And("i change My first name to new name \"([^\"]*)\"")
    public void iChangeMyFirstName(String fname) {
        Boolean result=false;
        Authentication authen = new Authentication(driver);
        if(!authen.clickMyaccount())
        {
            Assert.fail("Not able to click My account Page");
        }
        Log.info("Able to click view my account page");
        MyAccount acct=new MyAccount(driver);
        if(!acct.clickMyPersonalInfo())
        {
            Assert.fail("Not able to click My Personal Info");
        }
        Log.info("Able to click My personal info page");
        String user = fname.trim();

        if(!acct.setEditFirstName(user,BaseStepDef.PWD))
        {
            Assert.fail("Not able to set the first name as"+user);
        }
        Log.info("Able to set the first name as "+user);
        username = user;
        result=acct.clickButtonSave();
        if(!result) {
            Assert.fail("Not able to update first name");
        }
        Log.info("Able to save the updated info");
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
            Assert.fail("Not able to navigate to page where a product can be searched");
        }
        Log.info("able to navigate to page where a product can be searched");

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
        }
        Log.info("Able to login succesfully in application for user "+user);

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
        Log.info("Able to login succesfully in application for user "+user);


    }

    @When("i add \"([^\"]*)\" in the cart")
    public void iAddInTheCart(String Product)
    {
        Boolean result=false;
        HomePage homePage = new HomePage(driver);
        CartSummary summary = new CartSummary(driver);
        if(!homePage.enterText(Product))
            Assert.fail("Could not enter in serach box "+Product);
        Log.info("Able to enter product name in search box");

        if(!homePage.clickSearch())
            Assert.fail("Could not click search button");
        Log.info("Able to click serach button for product");

        if(!homePage.clickInStock())
            Assert.fail("Could not click product link image");
        Log.info("Able to click the product link image");

        if(!summary.addtocart())
            Assert.fail("could not click add to cart button");
        Log.info("Able to click Add to cart Button on summary page");
        result=summary.proceedToCheckout();
        if(!result)
        {
            Assert.fail("Could not click proceed to checkout");
        }
        Log.info("Able to click proceed to checkout on summary page");

        if(!summary.isPresentProceedCheckout())
        {
            Assert.fail("proceed to checkout page is present");
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
        Log.info("Able to click confirm checkout");
        Address address = new Address(driver);
        if(!address.Proceed())
        {
            Assert.fail("Could not click proceed on addrress page");
        }
        Log.info("Able to click proceed button address page");
        Shipping ship = new Shipping(driver);
        if(!ship.checkTerms())
        {
            Assert.fail("Could not click terms and conditions on shipping page");
        }
        Log.info("Able to click terms and conditions on shipping page");

        if(!ship.clickProceed())
        {
            Assert.fail("Could not click proceed on shipping page");
        }
        Log.info("Able to click proceed on shipping Page");
        Payment payment = new Payment(driver);
        if(!payment.clickBankwirePaymentMethod())
        {
            Assert.fail("Could not bankwire Payment method");
        }
        Log.info("Able to select payment method bankwire");
        result=payment.confirmOrder();
        if(!result)
        {
            captureScreenshot(driver,BaseStepDef.snapshotFile,"ConfirmOrderError");
            Assert.fail("Could notconfirm order for"+product);
        }
        Log.info("Able to click confirm order on payments page");
    }

    @Then("i am able to check the updatedDetails as \"([^\"]*)\" under Personal Information")
    public void iAmAbleToCheckTheUpdatedDetailsAsUnderPersonalInformation(String expFname) {
        String fName;
        Authentication authen = new Authentication(driver);
        Boolean success = authen.getUser(username);
        Assert.assertEquals(success, true);
        Log.info("Able to verify the details on authenticatioon page");

        if(!authen.clickMyaccount())
        {
            Assert.fail("Not able to click My account Page");
        }
        Log.info("Able to click view my account page");
        MyAccount acct=new MyAccount(driver);
        if(!acct.clickMyPersonalInfo())
        {
            Assert.fail("Not able to click My Personal Info");
        }
        Log.info("Able to click My personal info page");
        fName=acct.getFirstNameText();
        Assert.assertEquals(expFname.trim().toUpperCase(),fName.trim().toUpperCase());
    }
}
