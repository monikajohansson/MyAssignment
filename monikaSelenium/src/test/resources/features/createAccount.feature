
Feature: Methods
  I want to use this template to create accounts.

  @tag2
  Scenario Outline: Create an account successfully

		
    Given I am directed to MailChimp 
    And I have entered <email>
    When I enter an <userName>
    And I enter a password <password>
    And I press <signUp>
    Then I verify the <status> in step

    Examples: 
      | email     | userName       | password    | signUp | status  |
      | NoEmail   | userName       | "word"      | signUp | success |
      | email     | longUserName   | "word"      | signUp | success |
      | email     | usedUserName   | "word"      | signUp | success |
  		| email     | userName       | "word"      | signUp | success |
      
 