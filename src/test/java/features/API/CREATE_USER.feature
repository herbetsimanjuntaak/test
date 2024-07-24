@api
Feature: Test Create User Automation Dummy API

  @valid
  Scenario: Create user with valid request body
    Given create user with valid request body
    When send request post user
    Then should return status code 200