Feature: Purchase the order from the Ecommerce Website

  Background:
    Given I landed on ecommerce page

  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <username> and password <password>
    When I add product <productName> to the cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER" message is displayed on the confirmation page
    Examples:
      | username              | password    | productName |
      | soniaraju04@gmail.com | Santhu@7558 | ZARA COAT 3 |