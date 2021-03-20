Feature: To Test The Mentioned Scenarios

	@Test
  Scenario: Successful Navigation For All Menu Links
    Given User is on Home Page
    When User Navigate to Menu Link
    Then  User Navigated Successfully
	
	@Test
  Scenario: Successful Form Validation In Contact Page 
  	Given User is on Contact Page
    When User enters Invalid Data
    Then Validation Error Message Displayed Successfully
