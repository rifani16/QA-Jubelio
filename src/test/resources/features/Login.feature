@All
Feature: Login

  @Login
  Scenario: Login
    Given User is on login page
    When User fill email and password
    And User click login button
    Then User verify login result