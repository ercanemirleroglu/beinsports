Feature: Payment with Incorrect Card Number

  Scenario: Trying to subscribe by paying with wrong card number after login process
    Given Open browser and go to url
    Then Subscribe Options
    Then I choose one month
    Then Control Price
    Then I chose Monthly Pass with One Week Free Trial
    Then Login Here
    When Enter username password and click login
    Then Check Terms Condisions
    Then Click Pay Now Button
    When Enter name in Cardholdes name
    When Enter Card Number
    When Enter Expiry Month
    When Enter Expiry Year
    When Enter Veritification Code
    When Click Confirm Paymen Button
    Then Validate Error Message






