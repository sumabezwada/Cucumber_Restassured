Feature: Api verifications

  Scenario Outline: Verify api validations
    Given hit the api with post call"<url>"
   Examples:
     |url|
   |http://api.openweathermap.org/data/3.0/stations/5e7d9056cca8ce0001f1a99d?appid=59f9976a07d3a1217d26a43b5dbea6b5|



  Scenario: login with username and password using data table
    Given I navigate tologin page
    When I enter the login credentials
    |username |password|
    |admin| adminpassword|
    And I click the login button
    Then I should see the user form page


  Scenario: login with username and password using data table
    Given I navigate tologin page
    When I enter login credentials
      |username |password|
      |admin| adminpassword|
    And I click the login button
    Then I should see the user form page