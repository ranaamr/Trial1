Feature: stcTvPlans
  Scenario Outline: Verify STC TV plans of <country>
    Given User navigates to base URL
    When User clicks on current country
    And User selects <codeCountry>
    Then  User should see three plans listed in the page
    Then User should see a currency of <Currency> and price of lite plan <price1>
    And User should see a currency of <Currency> and price of classic plan <price2>
  And User should see a currency of <Currency> and price of premium plan <price3>
    And Screenshot is taken of every <country>
    And Close Browser
       Examples:
         | country | codeCountry | Currency | price1 | price2 | price3 |
         | Bahrain | bh          | BHD      | 2.0    | 3      | 6      |
         | Saudi   | sa          | SAR      | 15     | 25     | 60     |
         | Kuwait  | kw          | KWD      | 1.2    | 2.5    | 4.8    |
