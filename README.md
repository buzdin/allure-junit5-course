# README #

This is a guideline for JUnit 5 & Allure 2 Workshop  

### Repository contents ###

There are following top level directories in the repository:

* "examples" - code examples to copy-paste from if you are stuck
* "gradle" - build scripts, do not modify!
* "sut" - system under test, sample system to play with
* "testware" - this is where you could put your new test cases

### How to run tests ###

In order to run tests simply execute:

Linux or MacOS

```./gradlew testware:test```

Windows

```gradlew.bat  testware:test```

This command will do the following:

* download necessary Gradle version
* retrieves all project dependencies
* compiles the source code
* executes tests
* generates test reports

After this command succeeds you are all set for performing exercises.

### About System under Test (SUT) ###

You are provided with a simple system under test to write your exercises.
SUT represents a typical Internet Shop.

There are following users and passwords registered:
admin/admin
user1/pwd
user2/pwd

Main class for Internet Shop implementation is 

```org.tapost.ws.sut.InternetShop```

It has a lot of functionality to test. All of the methods are documented.
The task would be to write a test suite for this SUT quality assurance. 

```
login();
logout();
listItems();
viewItem();
searchItems();
addToCart();
viewShoppingCart();
checkout();
balance();
topUpBalance();
```

### Lab 1 - JUnit 5 Basics ###

* Go to testware/src/test/java directory
* Open org.tapost.ws.lab1.BasicTests class
* Take a look at the existing Internet Shop test case
* Start creating your own test cases for Internet Shop
* Use @Before and @After methods for test setup and teardown
* Change display name of test cases
* Use JUnit 5 style assertions where necessary
* Add Slf4j API and logging statements where needed
* Execute tests form IDE and observe the results

### Lab 2 - Structuring Junit 5 Test Cases ###

* Go to testware/src/test/java directory
* Add some more Internet Shop test cases
* Extract some of the test cases to a separate class
* Place two different types of tags on a test case
* Create a custom tag annotation and place it
* Create a Test Plan to execute only one tag
* Create a Test Plan, which includes only one class
* Create nested test case structure with nested Setup/Teardown methods
* Try disabling a test case
* Run everything and ensure all test cases are working

### Lab 3 - Data-Driven Testing in JUnit 5 ###

* Go to testware/src/test/java directory
* Rework some of the tests to become parametrized tests
* Use parametrized DisplayName annotation value
* Use ValueSource annotation to supply hardcoded test inputs
* Use CsvSource annotation and create a CSV data file with test inputs
* Use MethodSource annotation and supply test inputs as a Java 8 Stream
* Try RepeatedTest annotation on a test case
* Run everything and ensure tests are working

### Lab 4 – Allure Test Reports ###

* Put all basic annotations on existing test cases
* Refactor some of the test cases to invoke separate methods as test steps
* Test steps should be parametrized
* Add Allure attachment to test case execution (csv or json)
* Generate Allure report and take a look at it
* Locate the report and take a look
* Run everything and ensure tests are working
