# intelehealth Web Application Automation Framework

 - Project to run native for Web application using POM TestNG framework.
 
## Introduction:
 - Welcome to the documentation for MyWebFramework, a powerful and flexible web development framework. 
   This guide will help you get started with the testNG framework, understand its core concepts, and harness its 
   features to test web applications.

## Project overview
 - Total Testcases - 462
 - Regression Testcases(Automatable) - 270
 - High Priority Regression Testcases (Automatable) - 219

## Introduction on intelehealth app
  - Intelehealth is an Medical domain Non Profitable Organization Intelehealth leverages open-source technology for 
    Governments, NGO’s and Hospitals to seamlessly connect hard to reach population with high quality primary healthcare! 
    
## Tool and Language selection
 - Language Used: Java (JDK v17.0 and above)
 - Tool Used: Selenium Webdriver (4.12 and above)

## Framework selection:
 - POM TestNG framework to store all the locators in the page class and executable test scripts in test class files.
   
## Framework creation:
 - Create a simple Maven project.
 - Add all necessary dependencies for Selenium Webdriver, Apache POI, TestNG, Allure, ExtentReport etc.. 
 - Save and update the Maven project so that all the library files will be added.
 - Base Package - Contains class files to select the browser, environment and initialize Webdriver.
 - Listeners - Contains class files to provide the type of report (extent report, pdf report, Allure report, Tesults report)
 - utils package - Contains utility class files for storing the generic methods which are reusable in the Testscripts.

## framework details
 - Property file for selecting the environment, browser and URL.(src/main/java/com.intelehealth.config>config.qa.properties)
 - Takes screenshots at the end of every testcase execution (TestReports>screenshots)
 - Record the videos of Test execution (TestReports>test-recordings)
 - Extent reports is used for Reporting (TestReports>TestExecutionReport.html)
 
## Test Environment Setup:
 - 3 Environments - QA Env, Production Env, Staging Env
 - Environment setup is stored in Config property files and called using the methods.

## Test script Design:
 - All the Regression testcases with High priority are selected for Automation.
 - All the Locators are stored in Page File as per the Module, using By class with variable name for that element.
 - Methods are created as per the Testcase and the Modules.
 - Test scripts are stored in a separate class files based on Modules.
 - Each testcases are stored in TestNG annotations @Test methods.
 - @BeforeMethod and @AfterMethod will store the line of code for prerequisite and postrequsite.

## Test Data Management:
 - For creating the test data in application we have used Rest Assured scripts to call the API 
   and request for creating patients for awaiting visit module and appointments visit module.
 - For execution of Rest Assured API either you can directly execute from the script or by 
 - For test scripts execution patients need to be present in the application.

## Test Execution Plan:
 - Testscripts can be executed individually module wise.
 - Use xml file(testng_regression.xml) to execute all the testcases.
 - Modify in the xml file for running the testscripts based on Modules. 
   (ex: if need to run only Login & Dashboard module testcases you can just add those 2 modules in xml file).
 - Provision of Browser stack integration is made in framework if needed to execute from Browser stack. 
   Configurations of browserstack is specified in browserstack.yml file. And to execute in Browser stack 
   uncomment the configuration in pom.xml file.
 - For executing the scripts in headless mode you can change the value as true in com.intelehealth.config>
   config.qa.properties file
  
## Reporting:
 - Extent Report is mainly used in this framework. Can access from TestReports folder>TestExecutionReport.html file.
 - Contains HomePage, Dashboard Page, Categories Page.
 - Report contains the screenshots for each testcase(pass/fail).
 - Also displays the reason for failure testcases.
 - Provision for emailable report is done.

## Automation Scripts:
 - Automation Scripts are stored in GIT repository.
 - For Web App Automation Scripts - https://github.com/Intelehealth/QA-Automation-Web
 - Testscripts can be executed currently using xml file TestNG execution.

## Test Maintenance:
 - Page files need to be updated based on any changes made in locator values.

## Risks and Mitigations:
 - Verify the testdata in the application before execution.
 - Testscripts fails only if there is change in the application behaviour or attribute changes.
