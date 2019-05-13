Feature: Login Feature

  Background:
    Given I am logged out

  @b2c @PLAYM-3446 @login @logout @manual
  Scenario: Login and logout
    Given I click Login from the main menu
    And the login fields have placeholder text
    And the login field placeholder text disappears when text is entered
    When I login with valid credentials
    Then I logout
    Given I login with invalid credentials
    Then I should not be logged in

  @b2c @PLAYM-3446 @login @error @correct @smoke @manual
  Scenario: Login with wrong format and correct login error after mistake
    Given I click Login from the main menu    
    And I login with invalid credentials
    Then I close the dialog
    And the password has been cleared
    Then I login with valid credentials
    Then I logout
    And I click Login from the main menu
    And the password has been cleared

  @b2c @PLAYM-3446 @login @button @manual
  Scenario: Active login button only when username and password fields populated
    When I enter a valid username
    Then the Sign In button should be inactive
    When I enter a valid password
    Then the Sign In button should be active

  @b2c @PLAYM-3446 @manual @push_indicator
  Scenario: login with invalid credentials to see progress indicator
    When I enter a valid username
    And I enter a invalid password
    Then I see the progress indicator.
    When I enter a valid username
    And I enter a valid password
    Then I see the progress indicator

  @b2c @PLAYM-3446 @login @logout @remember_email @manual
  Scenario: Remember last successful login email, forget when reinstalling
    Given I login with valid credentials
    Then I logout
    And I click login from the main menu
    Then the username is prefilled with valid credentials
    And I login with different credentials
    Then I logout
    And I click login from the main menu
    Then the username is prefilled with different credentials
    Then I restart the application
    And I click login from the main menu
    And the username is prefilled with different credentials
    Then I reinstall the application
    And I click login from the main menu
    And the username is not prefilled

   @b2c @PLAYM-3446 @login @cancel @manual
   Scenario: I can cancel login process
    When I click login from the main menu
    And I click Cancel
    Then I see the dashboard
    Then I click Orders from the main menu
    When I click login from the main menu
    And I click Cancel
    Then I see the orders screen
    Then I click catalog
    When I click login from the main menu
    And I click Cancel
    Then I see the catalog
    Then I click Account from the main menu
    When I click login from the main menu
    And I click Cancel
    Then I see the Account page
    Then I click Store Locator in the main menu
    When I click login from the main menu
    And I click Cancel
    Then I see the Store Locator

  @b2c @PLAYM-3446 @login @session @swap_user @smoke @manual
  Scenario: Login with and remember valid session on restart and reinstall
    Given I login with valid credentials
    Then I reinstall the application
    And I click login from the main menu
    Then I login with different credentials
    Then I restart the application
    Then I should be logged in
