$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:cucumber/Order.feature");
formatter.feature({
  "name": "Shoppingcart",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate the addition of tshirt in shopping cart",
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
  "name": "The website to order is available",
  "rows": [
    {
      "cells": [
        "Title"
      ]
    },
    {
      "cells": [
        "My Store"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "ShoppingCartStepDef.theWebsiteToOrderIsAvailable(String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i am able to login using valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingCartStepDef.iAmAbleToLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i enter \"T-Shirt\" in Search Box",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingCartStepDef.iClickOnTshirtLink(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i check Tshirt is inStock",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingCartStepDef.iCheckTshirtIsInStock()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i click Add to cart button",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingCartStepDef.iClickAddToCartButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i get shopping cart summary and tshirt ordered",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingCartStepDef.iGetShoppingCartSummaryAndTshirtAddedInCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i verify order details on order confirmation page",
  "keyword": "And "
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
  "name": "Validate the change of First Name",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ChangeFisrtName"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "The website to order is available",
  "rows": [
    {
      "cells": [
        "Title"
      ]
    },
    {
      "cells": [
        "My Store"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "ShoppingCartStepDef.theWebsiteToOrderIsAvailable(String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i am able to login using valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingCartStepDef.iAmAbleToLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i click on MyAccountPage Link",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingCartStepDef.iClickOnMyAccountPageLink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i click on My personalinfo Page",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingCartStepDef.iClickOnMyPersonalinfoPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i change My first name",
  "rows": [
    {
      "cells": [
        "firstName"
      ]
    },
    {
      "cells": [
        "Updated"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingCartStepDef.iChangeMyFirstName(String\u003e\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "i am able to saveInfo",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingCartStepDef.iAmAbleToSaveInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});