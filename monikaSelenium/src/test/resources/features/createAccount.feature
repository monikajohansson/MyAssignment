
Feature: Methods
  I want to use this template to create accounts.

  @tag2
  Scenario Outline: Create an account

		
    Given I am directed to MailChimp 
    And I have entered <email>
    When I enter a <userName>
    And I enter a password <password>
    And I press <signUp>
    Then I verify the <status> in step

    Examples: 
      | email     | userName       | password    | signUp | status  |
  		| noEmail   | newUserName    | "word"   | signUp | failNoEmail |
      | email     | userName       | "word"       | signUp | success |
      | email     | longUserName   | "word"      | signUp | failLong |
      | email     | usedUserName   | "word"      | signUp | failUsed |
      
 