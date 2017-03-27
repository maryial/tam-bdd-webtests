Adding goods into the cart on ebay.com

Meta:
@page cart
@feature cart

Narrative:
In order to add goods into the cart
As an anonymous user
I want to browse the list of available goods and add them to the cart


Scenario: Search for goods and add them to cart
Given I am on the main application page
When I search for <goods>
Examples:
|goods			|
|plumber     	|
