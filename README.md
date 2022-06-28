# Interview-TrusTrace

**Features:**
all popular browsers preconfigured
downloading OS specific binaries automatically
full control by annotations
page object pattern ready
take screenshot on test pass/fail
highlight clicked elements
pretty and highly readable console output
parallel test execution ready
libraries
utilizes
Data Driven
assertions, waits and test extensions
assertions with selenium specific and type safe matchers
waiting functions
meaningful test result report
template testing
Maven
Log 4J
TestNG
resuability java classes for future development
Extent Report

**Java:** Implemented JDK 11 and OOPS concepts playing a huge role in this framework.

**Implemented Browsers:**
Thanks to the awesome webdrivermanager it supports the following browsers and automatically downloads OS specific binaries for:

Chrome ./gradlew clean test -Dbrowser=chrome
Firefox ./gradlew clean test -Dbrowser=firefox
Opera ./gradlew clean test -Dbrowser=opera
Edge ./gradlew clean test -Dbrowser=edge (will work on windows machines only)
Phantomjs ./gradlew clean test -Dbrowser=phantom (headless)

**Page Object Model:**
The Page-Object-Pattern can be used straight away to specify elements etc. It will have out-of-the-box support for typical helper methods like isAt(), etc... To instantiate a page object in a test class just the the following:

**Screenshots:**
On test passes/failures screenshots will automatically be taken and stored under Screenshots folder. The screenshot files will be named with time and the date. It will place in the different folders based on the status.

**Synchronize:**
Testing web applications that are asynchroniously loading / rerendering parts of the page can become hard to test with Selenium. Awaitility is a DSL that allows you to express expectations of an asynchronous system in a concise and easy to read manner and is therefore added to this project.

**Maven:**
Maven is written in Java and is used to build projects written in C#, Scala, Ruby, etc. Based on the Project Object Model (POM), this tool has made the lives of Java developers easier while developing reports, checks build and testing automation setups.25-May-2022

**TestNG:**
TestNG makes automated tests more structured, readable, maintainable and user-friendly. It provides powerful features and reporting. Its high-end annotations like dataprovider, makes it easier to scale up, as you perform cross browser testing across multiple devices, browsers, and their versions.25-Jul-2019

**Assertions:**
Fluentlenium extends AssertJ with FluentWebElement, FluentList and FluentPage custom assertions. Therefore you'll be able to write more intuitive and selenium specific assertions to give you the possibility to easily assert things like if an element is displayed etc.

**Beautiful Console Output:**
The console output is more intuitive and better readable as the default one of Gradle, jUnit and Selenium. A colored console output will give you a clear overview about which tests are currently running. Furthermore obvious markers will be set at succeeded (green marker) and failed (red marker) tests.
To get an even more clear overview of the test execution the project uses the TestLoggerPlugin to pretty print executed tests. Also the logs will capture in a text file to share with clients.

