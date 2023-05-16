Feature:This feature file is aimed to test the registration flow


  Scenario:Register page URL is accessible from Home Page
    Given "https://demo.opencart.com/" is accessed
    When My account button is clicked
    And Register button is clicked
    Then The new Url contains the following string"register"

    Scenario:Register button is displayed on HomePage
      Given "https://demo.opencart.com/" is accessed
      When My account button is clicked
      Then register account button is displayed