
### Problem Statement: 

JRE-17

### Pre-requisite: 
1) Configuration can be controlled from ./src/test/resources/test.properties

1a) chromedriver.exe is located in ./src/test/resources/chromedriver.exe

*If you can not execute from a user directory then choose a different directory for chromedriver

CreateProcess error=5, Access is denied

1b) If the Chrome version doesn't match please find the correct platform-specific driver binary file

https://googlechromelabs.github.io/chrome-for-testing/

2) Test is configured to run headless. To make change 

### Test execution: 
To execute the test using Maven use the following command

mvn -Dtest=RunTest test

### Output:
Output is written to ./src/test/resources/test.log

### Java Spring template project

This project is based on a GitLab [Project Template](https://docs.gitlab.com/ee/gitlab-basics/create-project.html).

Improvements can be proposed in the [original project](https://gitlab.com/gitlab-org/project-templates/spring).

### CI/CD with Auto DevOps

This template is compatible with [Auto DevOps](https://docs.gitlab.com/ee/topics/autodevops/).

If Auto DevOps is not already enabled for this project, you can [turn it on](https://docs.gitlab.com/ee/topics/autodevops/#enabling-auto-devops) in the project settings.