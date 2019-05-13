Feature:  Checkout page
As a user, I want a simple checkout so that I can submit my purchase order

  Background:
    Given I open the catalog

  @b2c @PLAYM-3447 @checkout @cart @ordersummary @smoke @manual
  Scenario: The checkout page appears before placing the order with error handling
    Given I have an item in my cart
    When I checkout
    And I log in
    Then I can see the checkout screen
    And I should see the payment list when pressed, and select one
    And I should see the delivery address list when pressed, and select one
    And I should see the delivery method list when pressed, and select one
    Then I place the order
    And I see checkout error handling
    Then check the terms and conditions checkbox
    And I can press the terms and conditions link and see the web page
    And I place the order
    Then I see the order confirmation screen

  @b2c @PLAYM-3447 @checkout @cart @ordersummary @updating @manual
  Scenario: Total price updates when delivery method changes
    Given I have an item in my cart
    When I checkout
    When I update the delivery method my shipping cost and order total updates

  @b2c @PLAYM-3447 @checkout @cart @place_order @push_indicator @spinner @manual
  Scenario: Place order button disabled while processing after click and progress indicator
    Given I have an item in my cart
    And I checkout
    And I toggle the terms and conditions checkbox
    And the place order button is temporarily disabled when pressed
    Then I see the progress indicator

  @b2c @PLAYM-3447 @checkout @cart @disabled @smoke @manual
  Scenario: The checkout button is disabled if I have no items in my cart
    Given I have no items in the cart
    Then I should see the empty cart
    And the checkout button should be disabled

  @b2c @PLAYM-3447 @ordersummary @cart @numbered @checkout @manual
  Scenario: The checkout steps are numbered
    Given I have an item in my cart
    When I checkout
    Then my checkout steps are numbered

#  There doesn't seem to be a savings promotion for b2c
#  @PLAYM-940 @checkout @cart @savings
#  Scenario: The checkout displays savings only if order is above 500 dollars
#    When I open the catalog from the dashboard
#    And I close the catalog menu
#    And I add 1 item from list view to cart
#    And I checkout
#    And I should not see the promotion in the checkout
#    Then I open the catalog from the dashboard
#    And I close the catalog menu
#    And I add 50 item from list view to cart
#    And I toggle the cart icon
#    And I checkout
#    And I should see the promotion in the checkout

#  There doesn't seem to be a savings promotion for b2c
#  @PLAYM-1648 @checkout @cart @savings @data
#  Scenario: The checkout displays savings if the order is over $500, and promotions
#    When I have a promotional item in my cart
#    Then I checkout
#    Then I can see the checkout screen with savings and promotions



#new user with no CC number