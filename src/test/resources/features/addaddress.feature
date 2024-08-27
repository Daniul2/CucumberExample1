Feature: User Address Task 4
  As a user,
  I want to define an address,
  so that I can provide my billing details.

  @done
  Scenario: Add a new user address
    Given a logged in user is on the home page
    And the user chooses Accounts from the navbar dropdown
    And the user clicks My Addresses on my account page
    When the user click Add a new address button
    And the user fills the address form
    And the user clicks the Save button
    Then my addresses page should include the new address

  @done
  Scenario: Add a new user address with missing
    Given a logged in user is on the home page
    And the user chooses Accounts from the navbar dropdown
    And the user clicks My Addresses on my account page
    When the user click Add a new address button
    And the user clicks the Save button
    Then the MyAddresses page should display error "There are 5 errors"
