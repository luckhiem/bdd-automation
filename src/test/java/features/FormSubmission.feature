Feature: Eligibility Section

  Background:
    Given I login to business grant portal
    And I go to login with CorpPass page
    And I login with manual corp

  @test-2
  Scenario: Contact Detail section
    Given I go to get new grant page
    And I select sector "IT"
    And I select the development area "International Expansion"
    And I select the oversea plan "Market Readiness Assistance"
    And I click on apply button
    And I click on proceed button

    #Add the information in Eligibility section
    And I select menu "Eligibility" in application detail
    And I answer the questions in eligibility question:
      | register check | global hq check | turnover check | target market check | started project check |
      | Yes            | No              | Yes            | No                  | Yes                   |
    And I click on next button

    #Add the information in Contact Detail section
    And I input the main contact detail with value:
      | Name      | Job Title | Contact No | Email              |
      | Kevin Luc | Director  | 89027658   | kevin.luc@test.com |
    And I click on same as registered address in Company Profile
    And I click on  as main contact person
    And I click on next button

    #Add the information in Proposal section
    And I input the proposal information with:
      | Project Title | Start Date  | End Date    | Project Description |
      | Car luxury    | 31 Jul 2022 | 31 Aug 2022 | This is car project |
    And I select activity "FTA Consultancy" in proposal
    And I select the project first time expand "Yes" in proposal
    And I click on next button

    #Add the information in Business Impact section
    And I input project FY date "31 Jul 2022" in business impact
    And I input overseas sale "100000" and "200000" and "300000" and "400000" in business impact
    And I input overseas investment "100000" and "200000" and "300000" and "400000" in business impact
    And I input rationale for projections "This is test" in business impact
    And I input non tangible benefits "This is test" in business impact
    And I click on next button

    #Add the information in Cost section
    And I add new item in third party vendor
    And I select the vendor registered check "Overseas" in cost section
    And I input the vendor name "Apple" in cost section
    And I upload supporting document in cost section
    And I input vendor amount billing "100000" in cost section
    And I click on next button

    #Add information in Declare & Review section
    And I answer the questions in Declare & Review section:
      | Criminal Liability | Civil Proceeding | Insolvency Proceeding | Incentives | Other Incentives | Commence | Related Party | Debarment | Covid Safe | Covid Safe Ques |
      | No                 | No               | No                    | No         | No               | No       | No            | No        | Yes        | Yes             |
    And I check on acknowledges and consents to the above
    And I click on review button

    #Input the mandatory fields is missing
    And I select market "Vietnam" in proposal
    And I select menu "Declare & Review" in application detail
    And I click on review button
    And I check on info truthfulness in company profile section
    And I click on submit button
    Then I should see the form submit successfully