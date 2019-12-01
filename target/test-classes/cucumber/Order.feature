Feature: Shoppingcart
        @OrderTshirt
        Scenario:Order T-Shirt and Verify in Order History
                Given i am on the page where a product can be added to cart for a signed user
                When i add "T-Shirt" in the cart
                Then i can view checkout page
                When i order a "T-Shirt"
                Then i verify order details on order confirmation page

        @ChangeFirstName
        Scenario: Update Personal Information First Name in My Account
                Given i am on the page where a user can update info
                When i change My first name to new name "Updated"
                Then i am able to check the updatedDetails