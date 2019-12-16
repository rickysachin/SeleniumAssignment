The solution is build on top of openjdk version "1.8.0_202" and is a maven solution running on Apache Maven 3.5.2 using Intellij community edition.
As of now it runs only on Chrome & Firefox browser and switch can be change from config file located at \SeleniumAssignment\src\test\resources\properties\config.properties file.
By default it is set to chrome

Also this soultion eliminates the dependency on chrome driver or gecodriver.It uses webdrivermanager to manage those hence easier and reduces unneccesary size of project

The Feature files can be run in mutiple ways

1. Command Line using mvn test
   a.)Go to command prompt and change directory to Project location for e.g  cd D:\SeleniumAssignment
   b.)use commnad mvn test.This internally call TestRunner to run all the scenario from feature file Order.feature
   c.)In case need to run only specific scenario use following coomand

      mvn test -Dcucumber.options="--tags @ChangeFisrtName" or mvn test -Dcucumber.options="--tags @OrderTshirt"

2.Run TestRunner.java from intellij which is located at D:\SeleniumAssignment\src\test\java\com\bdd\Runner
  In case need to run specific scenario please use  following optionunder  @CucumberOptions( tags = {"@ChangeFisrtName"} or  tags = {"@OrderTshirt"} )
In case only need to run what has failed then uncomment features = "@target/rerun.txt" and comment features = "classpath:cucumber/Order.feature"
make sure  rerun.txt in D:\Seleniumbased\target has some entry populated which happens whenever there is a failure when running from testRunner 

3.One can also run the scenario by right clicking on scenario in the feature file itself located at D:\SeleniumAssignment\src\test\resources\cucumber\Order.Feature from the IDE.


Under following folder reports are generated in three formats xml,json and html after run is completed
D:\SeleniumAssignment\target\cucumber-report\


