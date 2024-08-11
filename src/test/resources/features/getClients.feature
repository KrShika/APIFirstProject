@getClients
Feature: : user is able to get all clients

  Scenario: Testing get all clients API
    Given the user hits the API with endpoint "/api/myaccount/clients"
    Then user validates the status code is  200
    Then the user verifies if all clients ids are not empty


