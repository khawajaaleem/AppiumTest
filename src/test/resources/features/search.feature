Feature: Hospital Search
  As an user
  On searching for hospitals
  The application lists the hospitals matching the search text

  Scenario Outline: Search for hospital "<hospitalname>"
    Given user launches the application
    When user searches for "<hospitalname>"
    Then user sees "<hospitalname>" in the results
    When user selects "<hospitalname>" from the results
    Then user sees name as "<hospitalname>", subtype as "<type>", sector as "<sector>" and phone number as "<number>"

    Examples:
      | hospitalname                               | type                   | sector             | number       |
      | Milford Specialist Rehabilitation Hospital | Hospital               | Independent Sector | 01483 782500 |
      | East Riding Community Hospital             | Mental Health Hospital | NHS Sector         | 01482 886600 |
      | BMI The Saxon Clinic                       | UNKNOWN                | Independent Sector | 01908 665533 |
