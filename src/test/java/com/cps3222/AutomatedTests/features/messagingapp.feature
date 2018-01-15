Feature: Messaging Application Feature
  Step feature file for testing the Messaging Application using a Selenium Driver

  Scenario: Successful Login
    Given I am an agent trying to log in
    When I obtain a key from the supervisor using a valid id
    Then the supervisor should give me a valid key
    When I log in using that key
    Then I should be allowed to log in

  Scenario: Login Timeout
    Given I am an agent trying to log in
    When I obtain a key from the supervisor using a valid id
    Then the supervisor should give me a valid key
    When I wait for 65 seconds
    And I log in using that key
    Then I should not be allowed to log in

  Scenario: Surpassing message limit
    Given I am a logged in agent
    When I attempt to send 25 messages
    Then the messages should be successfully sent
    When I try to send another message
    Then the system will inform me that I have exceeded my quota
    And I will be logged out

  Scenario: Blocked words
    Given I am a logged in agent
    When I attempt to send the message <message> to another agent
    Then the other agent should recieve the message <new-message>

    Examples:
    |message                  | new-message |
    |Hello there              | Hello there |
    |Send recipe now          | Send now    |
    |Nuclear recipe is ready  | ready       |
    |GinGer nuclear RECipE    | .           |

  Scenario: Logging out
    Given I am a logged in agent
    When I click on "Log out"
    Then I should be logged out