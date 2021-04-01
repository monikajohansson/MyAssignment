
Feature: Methods
  I want to use this template to create accounts.

  @tag2
  Scenario Outline: Create an account

		
    Given I am directed to MailChimp 
    And I have entered <email>
    And I enter a <userName>
    And I enter a password 
    When I press <signUp>
    Then I verify the <status> in step

    Examples: 
      | email     | userName        | signUp | status      |
  		| noEmail   | newUserName     | signUp | failNoEmail |
      | email     | userName        | signUp | success     |
      | email     | longUserName    | signUp | failLong    |
      | email     | usedUserName    | signUp | failUsed    |
      
 