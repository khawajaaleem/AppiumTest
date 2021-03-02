## Mobile Application Automation 

This framework uses open source Appium framework with Page Object Model using Cucumber BDD and maven as build tool. 

### Pre Requisites
* Java 8 or above
* Maven3
* Git (Optional - Need only if you want to clone)
* Android SDK with atleast one emulator
* Appium Server

### Steps to run
* Clone or download the project `https://github.com/khawajaaleem/AppiumTest.git`
* Start the Appium Server
* Edit the StepDefs file with correct device capabilities.
* To execute the tests run the command `mvn clean test` in project root directory

### Report
Upon successful execution you can find the cucumber report in `target/cucumber-html/report.html`
Below is the execution report
![Report](/readme/report.png)

> Note: This framework doesn't contain iOS tests, as Appium inspector is not working for iOS application under test
