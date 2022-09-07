## Selenium Movie Details Test 

A brief description of what this project does

### Prequisites
* Java 8 
* Selenium 4.4
* TestNG 7.6

### Steps to Execution
* Clone the Project into Eclipse .
* Add below External Jar into this project:
    * selenium-server-4.4.0
    * TestNG-7.6.1
* Navigate to src/link.properties and change below properties:
    * chromeDriver_URL -  ChromeDriver.exe file path,
    * imdb_link        - IMDB Movie link 
        (Sample - https://www.imdb.com/title/tt9389998/)
    * wikipedia_link   - Wikipedia Movie Link
        (Sample - https://en.wikipedia.org/wiki/Pushpa:_The_Rise)
* Right click on src/selenium/testMoviedetails.java -> Run as Java Application .             (OR)

* Navigate to testng.XML -> Right click any where inside the file -> Run as TestNG Suite.

* Once the execution is done , Go to testng-output -> emailable-report.html displays test result status.
