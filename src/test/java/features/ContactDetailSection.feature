Feature: Eligibility Section

  Background:
    Given I login to business grant portal
    And I go to login with CorpPass page
    And I login with manual corp

  @test-1
  Scenario: Contact Detail section
    Given I go to get new grant page
    And I select sector "IT"
    And I select the development area "International Expansion"
    And I select the oversea plan "Market Readiness Assistance"
    And I click on apply button
    And I click on proceed button
    And I select menu "Contact Details" in application detail
    And I input the main contact detail with value:
      | Name      | Job Title | Contact No | Email              |
      | Kevin Luc | Director  | 89027658   | kevin.luc@test.com |
    And I click on same as registered address in Company Profile
    And I click on  as main contact person
    Then I should see main contact loaded correctly
    And I click on save button
    Then I should see the success message is displayed