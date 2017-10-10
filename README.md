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

### Lab 1 - JUnit 5 Basics ###

* Create your first test case
* User before/after methods
* Change display name of a test case
* Use JUnit 5 assertions
* Add logging statements
* Add logback.xml from examples to enable logging

### Lab 2 - Structuring Junit 5 Test Cases ###

* Create few test cases
* Place two types of tags on a test case
* Create a custom tag and place it
* Create a Test Plan to execute only one tag
* Create a Test Plan, which includes only one class
* Create nested test case structure with Setup/Teardown methods
* Disable a test case
* Run everything and ensure all is working

### Lab 3 - Data-Driven Testing in JUnit 5 ###

*
*
*

### Lab 4 – Allure Test Reports ###

* Put all basic annotations on existing test cases
* Refactor test cases to structured test steps
* Add attachment
* Generate Allure report
* Add JavaDoc comments and generate documentation

### TODO ###

* check that default JUnit 5 report is generated before going to Allure