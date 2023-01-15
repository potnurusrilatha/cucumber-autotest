@smokeTest
Feature: Login Feature File
  I want to run a login feature file.

  @selenium
  Scenario: Login scenario test for saucedemo

    Given navigate to saucedemo page
    When user logs in
    Then home page should be displayed