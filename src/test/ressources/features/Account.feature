# new feature
# Tags: optional
    
Feature: Manage Account
    As User
    I want to Manage my account
    So that i can make Transaction
    
  Background:
    Given  the list of accounts is:
      | accountId | accountOwner | balance      | creationDate 				|
      | 1  				| user1      	 |  1500.99			| 03/01/2019 00:00:00 |
		  | 2  				| user2        |  12000.12		| 05/03/2018 00:00:00 | 
      
	Scenario: 
    Given A user should be able to deposit a valid amount to a specific account
    When a user request to deposit 500.00 to the account id 1
    Then the amount of account become as bellow :
    	| 1  				| user1      	 |  2000.00			| 03/01/2019 00:00:00 |