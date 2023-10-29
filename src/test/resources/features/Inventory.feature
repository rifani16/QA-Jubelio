@All
Feature: Inventory

  Background: User Login
    Given Login process

  @inventory
  Scenario: Update Inventory
    Given Navigate to Inventory Page
    When Search a product
    And Click on Checkbox
    And Click on Inventory Adjustment button
    And Update quantity by fill update column
    And Click on save button
