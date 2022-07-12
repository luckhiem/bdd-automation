Feature: Eligibility Section

  Background:
    Given I login to business grant portal
    And I go to login with CorpPass page
    And I login with manual corp

  @test
  Scenario: Eligibility section
    Given I go to get new grant page
    And I select sector "IT"
    And I select the development area "International Expansion"
    And I select the oversea plan "Market Readiness Assistance"
    And I click on apply button
    And I click on proceed button
    And I select menu "Eligibility" in application detail
    And I answer the questions in eligibility question:
      | register check | global hq check | turnover check | target market check | started project check |
      | Yes            | No              | Yes            | No                  | Yes                   |
    And I see the warning not meet the eligibility criteria with No answer
    And I click on save button
    Then I should see the success message is displayed