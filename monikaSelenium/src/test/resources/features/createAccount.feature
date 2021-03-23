
Feature: Create Account
  I want to use this template to create accounts.

  @tag2
  Scenario Outline: Create an account successfully
  	
    Given I have logged in at Mailchimp
    And I have entered <email>
    And I enter an username <userName> 
    And I enter a password <password>
    When I press <signUp>
    Then I verify the <status> in step

    Examples: 
      | email  | userName | password | signUp  | status  |
      | "name"   | "userName" | "word"     | signUp | success |
     
     Scenario: Browser
     Given I have used "chrome" as browser
     Given I have used "firefox" as browser
