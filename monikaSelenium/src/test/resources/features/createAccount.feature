
Feature: Create Account
  I want to use this template to create accounts.

  @tag2
  Scenario Outline: Create an account successfully
  	Given I have used <browser> as browser
    And I am directed to MailChimp
    And I have entered <email>
    And I enter an username <userName> 
    And I enter a password <password>
    When I press <signUp>
    Then I verify the <status> in step

    Examples: 
      |browser  | email    | userName   | password   | signUp | status  |
      |"chrome" |"name"    | "userName" | "word"     | signUp | success |
      |"firefox"|"name"    | "userName" | "word"     | signUp | success |
      |"edge"   |"name"    | "userName" | "word"     | signUp | success |

  Scenario Outline: Create a username with more than 100 signs
    Given I have used <browser> as browser
    And I am directed to MailChimp
    And I have entered <email>
    And I enter a long username <userName> 
    And I enter a password <password>
    When I press <signUp>
    Then I verify the <status> in step 
    
    Examples: 
      |browser  | email    | userName   | password   | signUp | status  |
      |"chrome" |"name"    | "userName" | "word"     | signUp | success |
      |"firefox"|"name"    | "userName" | "word"     | signUp | success |
      |"edge"   |"name"    | "userName" | "word"     | signUp | success |