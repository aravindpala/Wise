Project Set-Up 
    Install JDK and Eclipse 
    Open Eclipse
    Click on Help
    Go to Eclipse Market Place 
    Search for TestNG and Install
    After Installation completed it will automatically restart 
    JRE Version above 1.8
-----------------------------------------------------------------------
Importing Project 
    click on File
    Click on Import 
    Select Maven -> Existing Maven Project 
    select the POM file 
    click on finish 
  if using select git -> Project from git -> clone URI --> give url --> username & password click on import 
-------------------------------------------------------------------------
**Running Test Cases**
  In project structure there will be a testcase.xml file
  open testcases.xml file 
  right click and select click on Run as TestNG 
if  **Run as TestNG** Option not displaying are not your'e facing any error in project 
  Right click on Project Folder
  click on BuildPath --> open Configure Build Path
  Select Libraries 
  select classpath 
  on right side click on add Library 
  select TestNG
  click on Finish 
  Click on Apply and Finish
-----------------------------------------------------------------------

Project Structure 
   All Page Elements and Methods Under src/main/java/com.wise.pagefactory package
   Base Class under src/main/java/com.wise package
   Test cases are under src/test/java/com.wise.testcases package 
 ----------------------------------------------------------------------
 Test Reports 
 	open the Folder test-output
 	open the emailable-report.html file in web browser to see reports
  			or
  	open test-output -> Suite -> Test.html
 ----------------------------------------------------------------------
 you can change the browser and url and mobile number and otp from testcases.xml file
 		
in parameter's tag you can change value as per value it will execute
   browser will accept firefox and chrome   
