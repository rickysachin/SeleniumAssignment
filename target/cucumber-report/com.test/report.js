$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:cucumber/Order.feature");
formatter.feature({
  "name": "Shoppingcart",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Order T-Shirt and Verify in Order History",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@OrderTshirt"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "i am on the page where a product can be added to cart for a signed user",
  "keyword": "Given "
});
formatter.match({
  "location": "ShoppingCartStepDef.iAmOnThePageWhereAProductCanBeSearchedAndAddedToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i add \"T-Shirt\" in the cart",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingCartStepDef.iAddInTheCart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i can view checkout page",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingCartStepDef.iCanSeeCheckoutPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i order a \"T-Shirt\"",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingCartStepDef.iOrderA(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i verify order details on order confirmation page",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingCartStepDef.iVerifyOrderDetailsOnOrderConfirmationPage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Update Personal Information First Name in My Account",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ChangeFirstName"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "i am on the page where a user can update info",
  "keyword": "Given "
});
formatter.match({
  "location": "ShoppingCartStepDef.iAmOnThePageWhereAUserCanLoginAndUpdateInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i change My first name to new name \"Updated\"",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingCartStepDef.iChangeMyFirstName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i am able to check the updatedDetails",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingCartStepDef.iAmAbleToCheckTheUpdatedDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});