# OpenMRS

This is for OpenMRS

**Pre-requisites** 

  - JAVA 11
  - MAVEN

  **JAVA Installation:**
  https://www.java.com/en/download/help/download_options.html
  
  **MAVEN Installation:**
  https://www.javatpoint.com/how-to-install-maven

  Using homebrew:
  - brew install openjdk@11
  - brew install maven

**Run the test suite by using the following command**

  cd com.openmrs
  mvn clean test
 
**We can override the browser name by passing a Maven Argument like below**

  mvn clean test -Dbrowser=FF

After execution you can find report in test-output folder 

index.html
