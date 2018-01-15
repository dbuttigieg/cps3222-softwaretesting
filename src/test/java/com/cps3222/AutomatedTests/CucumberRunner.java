package com.cps3222.AutomatedTests;

/**
 * @author Denise Buttigieg, Raoul Fenech
 * @version 15/01/2017
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, glue = {"com.cps3222.AutomatedTests.stepdefs"}, features = {"src/test/java/com/cps3222/AutomatedTests/features"})
public class CucumberRunner {
}
