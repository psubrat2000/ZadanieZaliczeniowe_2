Feature: Buy Hummingbird Printed Sweater

  Scenario: a logged in user can purchase Hummingbird Printed Sweaters
    Given an user logged into My Store
    When user chooses Hummingbird Printed Sweater
    Then discount is 20%
    When user chooses size "M"
    And user chooses 5 pieces
    And user adds the product to the cart
    And user proceeds to checkout
    And user confirms address
    And user chooses shipping method to pick up in store
    And user chooses the way of payment
    And user clicks "order with an obligation to pay"
    Then a confirmation screenshot is made and price is saved for comparison
    When user enters order history
    Then the most recent order is "Awaiting check payment" and the total price is equal to price saved earlier