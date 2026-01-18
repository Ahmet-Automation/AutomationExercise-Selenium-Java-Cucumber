@Regression
Feature: Add products to Cart
  As a user, I want to add products to my cart so that I can purchase them later

  Background: Navigation to Products Page
    Given I launch the browser
    And I navigate to url "https://automationexercise.com/"
    Then I verify that home page is visible successfully
    When I click on "Products" link from the header menu

  @AddProducts
  Scenario: Add multiple products to cart and verify
    And I hover over first product and click "Add to cart"
    And I click on "Continue Shopping" button in the modal
    And I hover over second product and click "Add to cart"
    And I click on "View Cart" button in the modal
    Then I verify both products are added to Cart
    And I verify their prices, quantity and total price