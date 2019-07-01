# new feature
# Tags: optional
@Account
Feature: Manage Account
    As User
    I want to Manage my account
    So that i can make Transaction

  Background: 
    Given the list of accounts is:
      | accountId | accountOwner | balance  |
      |         1 | user1        |  1500.99 |
      |         2 | user2        | 12000.12 |

 @admin
 Scenario:
 	Given I'm connected as Admin
 	When T want to list all accounts
 	Then I get the following list:
      | accountId | accountOwner | balance  |
      |         1 | user1        |  1500.99 |
      |         2 | user2        | 12000.12 |


  @credit
  Scenario: 
    Given I'm connected as user1
    When I try to deposit 500.00 to the account id 1
    Then the amount of account becomes as bellow 2000.99
    
  @debit
  Scenario:
 	Given I'm connected as user2
 	When I try to retreive 2000.12 fromthe account id 2
 	Then the amount will become 10000.00
 	
  @unauthorizeRequest
  Scenario: unsatisfactory balance
 	Given I'm connected as user2
 	When I try to retreive 12000.13 from the account id 2
 	Then i get the following error : "unsatisfactory balance to perform this operation"

  
 
