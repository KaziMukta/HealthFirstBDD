Feature: HealthFirst Insurance

    Scenario: Verify Invalid credentials to log in
    Given user should be on the Healthfirst home page
    When user should put the cursor on log in button
    Then the system should display Provider Portal button
    And user should click on provider portal button
    And user should enter invalid Username
    And user should enter invalid Password 
    And user should click on Sign In button
    Then the system should displays error