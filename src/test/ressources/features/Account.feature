# new feature
# Tags: optional
@Account
Feature: Manage Account
    As User
    I want to Manage my account
    So that i can make Transaction

  Background: 
    Given the list of accounts is:
      | accountId | accountOwner | balance  | creationDate        |
      |         1 | user1        |  1500.99 | 2019-01-12T21:19:52.642 |
      |         2 | user2        | 12000.12 | 2018-11-12T21:19:52.642 |

  Scenario: 
    Given I'm connected as user1
    When I try to deposit 500.00 to the account id 1
    Then the amount of account becomes as bellow 2000.00
