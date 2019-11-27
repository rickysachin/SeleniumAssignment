package com.bdd.Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:cucumber/Order.feature",
        // features = "@target/rerun.txt",
        glue = "com.bdd.StepDefs",
        //tags = {"@ChangeFisrtName"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report/com.test",
                "junit:target/cucumber-report/Cucumber.xml",
                "json:target/cucumber-report/Cucumber.json",
                "rerun:target/rerun.txt"})
public class TestRunner {

    public static void main(String[] args) {

    }
}
