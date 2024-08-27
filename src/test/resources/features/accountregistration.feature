Feature: Hotel Account registration
  As a user
  I want to register
  So that I can book hotel

  @done
  Scenario: Successfully account creation
    Given the user is on the authentication page
    When the user types a random email into the create account email input
    And the user clicks on the create an account button
    And the user fills the required fields on the create account form
    And the user clicks the register button
    Then the user should be logged in their account page
    And the account page should display welcome message "Your account has been created."

  @done
  Scenario: Email already taken
    Given the user is on the authentication page
    When the user types an existing email "foo@bar.com" into the create account email input
    And the user clicks on the create an account button
    Then the page should display error "An account using this email address has already been registered. Please enter a valid password or request a new one."

  @done
  Scenario: Email empty
    Given the user is on the authentication page
    And the user clicks on the create an account button
    Then the page should display error "Invalid email address."

  @done
  Scenario: Email without monkey char
    Given the user is on the authentication page
    And the user is on the authentication page
    When the user types an existing email "foobar.com" into the create account email input
    And the user clicks on the create an account button
    Then the input email contains error border


  @done
  Scenario Outline: Successfully account creation parametrized
    Given the user is on the authentication page
    When the user types a random email into the create account email input
    And the user clicks on the create an account button
    And the user fills the create account form with "<firstName>", "<last_name>", "<password>"
    And the user clicks the register button
    Then the user should be logged in their account page
    And the account page should display welcome message "Your account has been created."
    Examples:
      | firstName | last_name | password |
      | Jone      | Kowalski  | passwd   |
      | Janek     | Nowak     | passTwo  |