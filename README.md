# Aureum Test Automation Challenge (Daniel Nadaya)


## How to Set up this Test Automation Environment
- Download and Install Java SE Development Kit 17.0.7 --> https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Configure JAVA PATH --> https://www.java.com/en/download/help/path.html
- Download Maven --> https://maven.apache.org/download.cgi
- Install Maven --> https://maven.apache.org/install.html
- Configure Maven PATH --> https://stackoverflow.com/questions/45119595/how-to-add-maven-to-the-path-variable

--------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------

## Running the tests
You can use any IDE you want, such us IntelliJ IDEA, VSCode, etc...

To run this Test Automation project, you can either just run the TestRunner class (using this method the report will not be created), or run either mvn clean verify from the command line.

The test results will be recorded in the _target/site/serenity/index.html_ directory (The full path will be indicated at the end of the run in the SERENITY REPORTS section).

By default, the test will run using Chrome. You can run it in Firefox by overriding the driver system property, e.g.
$ mvn clean verify -Ddriver=firefox

### Commands to run the tests through the console:
- To run the complete suite:
  -     mvn clean verify -Dcucumber.filter.tags="@AureumChallenge and not @NoRun"

- To run only UI Scenarios:
  -     mvn clean verify -Dcucumber.filter.tags="@UiTests and not @NoRun"

- To run only API Scenarios:
  -     mvn clean verify -Dcucumber.filter.tags="@ApiTests and not @NoRun"


--------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------

## Objective
### UI Tests:

● Verify that an item can be added to the cart and is visible on the cart page.

● Ensure the user can complete the purchase/checkout process.

● Verify that inventory items can be sorted by price, high-to-low, and the sorting is
correct.

● Ensure that inventory can be sorted by name, Z-to-A, and the sorting is correct.

### API Tests:
● Create tests for API calls (POST, GET, PUT, DELETE), setting headers, body, and
making proper assertions. You can use this Swagger to do some examples of API Testing: https://petstore.swagger.io/
