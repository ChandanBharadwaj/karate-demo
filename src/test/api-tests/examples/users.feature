Feature: sample karate test script
  for help, see: https://github.com/karatelabs/karate/wiki/IDE-Support

  Background:
    * url 'https://jsonplaceholder.typicode.com'
    * def helper = new com.sai.helper.Helper()

  Scenario: get all users and then get the first user by id
    Given path 'users'
    When method get
    Then status 200

    * def first = response[0]
    * print helper.printMe("hey")

    Given path 'users', first.id
    When method get
    Then status 200
  