# automation-technical-test
This are the tests created for the automation technical test.

### Requirements to execute the tests
It is needed to have maven installed to be able to execute this tests.

### How to execute the tests
To be able to execute the tests you have to follow the next steps:
- Download or clone the code
- Open a terminal and go to the main folder of the project (where the pom.xml if found)
- Execute the command `mvn install -DskipTests` 
- Execute the command `mvn test`

With this the tests will be executed in headless mode.
To execute them in headful mode (so that the browser that executes the test is shown) modify this line in the BaseTest class:

`browser = Playwright.create().chromium().launch();`

to :

`browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));`
