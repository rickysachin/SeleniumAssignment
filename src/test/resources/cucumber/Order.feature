Feature: Shoppingcart
        @OrderTshirt
        Scenario: Validate the addition of tshirt in shopping cart
                Given The website to order is available
                        | Title   |
                        | My Store|
                When i am able to login using valid credentials
                And i enter "T-Shirt" in Search Box
                When i check Tshirt is inStock
                And i click Add to cart button
                Then i get shopping cart summary and tshirt ordered
                And i verify order details on order confirmation page



        @ChangeFisrtName
        Scenario: Validate the change of First Name
                Given The website to order is available
                        | Title   |
                        | My Store|
                When i am able to login using valid credentials
                And i click on MyAccountPage Link
                When i click on My personalinfo Page
                And i change My first name
                        |firstName|
                        |Updated|
                Then i am able to saveInfo