@Test111
Feature: SearchPage

Scenario: Validate selected item details on the checkout page
When User enters '65 inch TV' to search 
Then User selects '65 inch TV' from the suggested list
And  User selects 'LG' brand
When User scrolls 'up'
And  User clicks on the 3 rd item 
Then User captures all the details of the selected item
And  User clicks Buy It Now button on buy out page
When User logins using 'google' button


Scenario Outline: Validate selected item details on the checkout page
When User enters '<item>' to search 
Then User selects '<item>' from the suggested list
And  User selects '<brand>' brand
When User scrolls by coordinates
And  User clicks on the 1 st item 
Then User captures all the details of the selected item
And  User clicks Buy It Now button on buy out page
When User logins using 'google' button

Examples:
|item      |brand      |
|65 inch TV|Samsung	   |
